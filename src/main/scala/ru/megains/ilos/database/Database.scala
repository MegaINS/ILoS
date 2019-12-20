package ru.megains.ilos.database

import java.sql.Connection

trait Database {


    def withConnection[A](block: Connection => A): A = {
        withConnection(autocommit = true)(block)
    }
    def withConnection[A](autocommit: Boolean)(block: Connection => A): A = {
        val connection  = DBConfig.getConnection
        try {
            block(connection)
        } finally {
            connection.close()
        }
    }
}
