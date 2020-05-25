package ru.megains.ilos.db.dao

abstract class DaoFactory {

    def installDao():Unit

    def getShopDao: ShopDao

    def getItemDao: ItemDao

    def getResGenDao: ResGenDao

    def getPlayerDao:PlayerDao

    def getLocationDao:LocationDao

    def getWarpDao:WarpDao

}
