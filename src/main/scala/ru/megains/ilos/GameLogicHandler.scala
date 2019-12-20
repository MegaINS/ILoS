package ru.megains.ilos

import java.util.concurrent.locks.ReentrantReadWriteLock
import java.util.concurrent.{ConcurrentLinkedQueue, ExecutorService, Executors}

import ru.megains.ilos.utils.Logger


class GameLogicHandler(server: IloSServer) extends Runnable with Logger[GameLogicHandler]{



    val poolSize:Int = 10
    val pool: ExecutorService = Executors.newFixedThreadPool(poolSize)
    val readWriteLock: ReentrantReadWriteLock = new ReentrantReadWriteLock
    val inboundPacketsQueue: ConcurrentLinkedQueue[() => Unit] = new ConcurrentLinkedQueue[() => Unit]

    def start(): Unit ={
        for(_<-0 until poolSize){
            pool.execute(this)
        }
    }

    def addPacketToProcess(packet: () => Unit): Unit = {
        inboundPacketsQueue.add(packet)
    }

    override def run(): Unit = {
        while (server.isActive){
            var task:() => Unit = null
            readWriteLock.readLock.lock()
            try {
                if(!inboundPacketsQueue.isEmpty){
                    task = inboundPacketsQueue.poll()
                }
            } finally{
                readWriteLock.readLock.unlock()
            }
            if(task!=null){
                task()
            }else{
                Thread.sleep(1)
            }
        }
    }
}
