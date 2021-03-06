package ru.megains.ilos.world.location.shop


import ru.megains.ilos.item.Items
import ru.megains.ilos.network.packet.server.PacketShop
import ru.megains.ilos.player.Player
import ru.megains.ilos.world.location.LocationType.LocationType
import ru.megains.ilos.world.location.{Location, LocationType}


class LocationShop(id: Int, name: String,shopId: Int,width: Int,height: Int) extends Location(id,name, width, height) {


    var locationType: LocationType = LocationType.SHOP

    val groups: List[Group] = Shops.getGroupsByShopId(shopId)


    override def correctCoordinate(x: Int, y: Int): Boolean = false

    def buyItem(id: Int, amount: Int, player: Player): Unit = {

        player.inventory.addItem(Items.getItem(id), amount)
    }

    override def sendData(player: Player): Unit = {
        player.sendPacket(new PacketShop(this))
    }

    override def enterObject(player: Player): Unit = {
        warps.last.in(player)
    }

}
