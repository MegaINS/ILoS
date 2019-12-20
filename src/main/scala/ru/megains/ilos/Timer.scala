package ru.megains.ilos

class Timer(val targetTick:Double) {

    var lastLoopTime = .0
    var tick = 0
    var currentTime = .0


    def init(): Unit = {
        lastLoopTime = Timer.getCurrentTime
    }




    def update(): Unit = {
        currentTime = Timer.getCurrentTime
        tick = Math.floor((currentTime - lastLoopTime) * targetTick).toInt
        lastLoopTime += (1f / targetTick) * tick

        if (tick > 20) tick = 20

    }
}

object Timer{

    def getCurrentTime: Double = System.nanoTime / 1000000000.0

    def getTime(ns:Int = 0, s:Int = 0, m:Int = 0): Double ={
        getCurrentTime + ns/1000D + s + m * 60D
    }
}
