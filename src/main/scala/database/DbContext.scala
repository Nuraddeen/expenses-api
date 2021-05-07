package database

import io.getquill.{SnakeCase, SqliteJdbcContext}

/**
 * THis object does basic database (sqlite in this case) connectivity to the app
 */
object DbContext {
  lazy val ctx: SqliteJdbcContext[SnakeCase.type] = new SqliteJdbcContext(SnakeCase, "ctx")

}
