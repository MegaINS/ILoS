package ru.megains.ilos.db.daoquill

import ru.megains.ilos.db.dao.PlayerDao
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx
import ru.megains.ilos.db.daoquill.QuillDaoFactory.ctx._
import ru.megains.ilos.db.dto.{AuthDto, PlayerDto}

class PlayerDaoQuill extends PlayerDao {

    implicit val authSchemaMeta: ctx.SchemaMeta[AuthDto] = schemaMeta[AuthDto]("auth")
    implicit val playerSchemaMeta: ctx.SchemaMeta[PlayerDto] = schemaMeta[PlayerDto]("player")

    override def getBySession(session: String): Option[(AuthDto, PlayerDto)] = {
        run(
            quote{
                query[AuthDto]
                    .join(query[PlayerDto])
                    .on(_.id == _.id)
                    .filter(
                        _._1.session == lift(session)
                    )
            }
        ).headOption
    }
}
