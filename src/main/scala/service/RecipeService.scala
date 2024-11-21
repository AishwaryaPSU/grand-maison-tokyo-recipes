package service

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import model.Recipe
import spray.json.DefaultJsonProtocol


object RecipeJsonProtocol extends DefaultJsonProtocol {
  implicit val recipeFormat = jsonFormat6(Recipe)
}

object RecipeService extends SprayJsonSupport {
  import RecipeJsonProtocol._

  // Static list of recipes
  private val recipes = List(
    Recipe(
      id = 1,
      title = "Pancakes",
      makingTime = "20 minutes",
      cost = "5",
      serves = "2 people",
      ingredients = List("Flour", "Eggs", "Milk", "Sugar", "Butter")
    ),
    Recipe(
      id = 2,
      title = "Spaghetti Bolognese",
      makingTime = "40 minutes",
      cost = "10",
      serves = "4 people",
      ingredients = List("Spaghetti", "Tomato Sauce", "Minced Meat", "Onions", "Garlic")
    )
  )

  // Function to retrieve all recipes
  def getAllRecipes: List[Recipe] = recipes
}

