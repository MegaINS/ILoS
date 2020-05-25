package ru.megains.ilos.db.daoquill

import io.getquill.{MysqlJdbcContext, SnakeCase}
import ru.megains.ilos.db.dao.{DaoFactory, ItemDao, LocationDao, PlayerDao, ResGenDao, ShopDao, WarpDao}
import ru.megains.ilos.item.Items
import ru.megains.ilos.world.location.{Locations, ResGens}
import ru.megains.ilos.world.location.shop.Shops
import ru.megains.ilos.world.warp.Warps

object QuillDaoFactory extends DaoFactory {

    lazy val ctx: MysqlJdbcContext[SnakeCase.type] = new MysqlJdbcContext(SnakeCase,"ctx")

    override def getPlayerDao: PlayerDao = new PlayerDaoQuill

    override def getLocationDao: LocationDao =  new LocationDaoQuill

    override def getWarpDao:WarpDao = new WarpDaoQuill

    override def getResGenDao: ResGenDao = new ResGenDaoQuill

    override def getItemDao: ItemDao = new ItemDaoQuill

    override def getShopDao: ShopDao = new ShopDaoQuill

    override def installDao(): Unit = {
        Locations.locationDao = getLocationDao
        Warps.warpDao = getWarpDao
        ResGens.resGenDao = getResGenDao
        Items.itemDao = getItemDao
        Shops.shopDao = getShopDao
    }
}
