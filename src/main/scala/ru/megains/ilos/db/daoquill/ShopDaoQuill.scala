package ru.megains.ilos.db.daoquill

import ru.megains.ilos.db.dao.ShopDao
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx._
import ru.megains.ilos.item.ItemStack
import ru.megains.ilos.world.location.shop.{Group, Type}

class ShopDaoQuill  extends ShopDao{


    implicit val groupSchemaMeta: ctx.SchemaMeta[Group] = schemaMeta[Group]("shop_group")
    implicit val typeSchemaMeta: ctx.SchemaMeta[Type] = schemaMeta[Type]("shop_type")
   // implicit val itemSchemaMeta: ctx.SchemaMeta[ItemStack] = schemaMeta[ItemStack]("shop_item")

    override def getGroupsByShopId(id: Int): List[Group] = {
        run(
            quote{
                query[Group].filter(_.shopId == lift(id))
            }
        )
    }

    override def getGroupTypesByGroupId(id: Int): List[Type] = {
        run(
            quote{
                query[Type].filter(_.groupId == lift(id))
            }
        )
    }

    case class ShopItem(id:Int, typeId:Int, itemId:Int, amount:Int)

    override def getTypeItemsByTypeId(id: Int): List[ItemStack] = {
        run(
            quote{
                query[ShopItem].filter(_.typeId == lift(id))
            }
        ).map(si=> new ItemStack(si.id,si.itemId,si.amount))
    }


}
