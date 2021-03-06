package ru.megains.ilos.world.location

import ru.megains.ilos.item.{Item, Items}

import scala.util.Random

case class ResGen(id:Int,itemId:Int, min:Int, max:Int,chance:Float) {

    val item: Item = Items.getItem(itemId)

    def generate(loc: LocationMine): Unit ={

        val width = loc.width-2
        val height = loc.width-2
        val resAmount: Float = width * height * chance /100f
        var resTotal = 0

        while(resAmount>resTotal){
            val x = 1 + Random.nextInt(width)
            val y = 1 + Random.nextInt(height)
            val res = min + Random.nextInt(max-min)
            val tile = loc.tileGrounds( x + y *loc.height)
            if(tile > 0 && !loc.resources.exists(r => r.x == x && r.y ==y )){
                loc.resources += new Resource(item,res,x,y)
                resTotal += res
            }
        }
    }
}
