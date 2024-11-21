package repository

import slick.jdbc.MySQLProfile.api._

object RecipeRepository {

  val db = Database.forConfig("mydb")

}
