package service

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import model.Recipe
import repository.RecipeRepository
import spray.json.DefaultJsonProtocol
import spray.json.DefaultJsonProtocol.jsonFormat6

import scala.concurrent.Future

object RecipeService extends SprayJsonSupport {

  def getAllRecipes: Future[List[Recipe]] = {
    RecipeRepository.getAllRecipes
  }

  def getRecipeById(id: Int): Future[Option[Recipe]] = {
    RecipeRepository.getRecipeById(id)
  }

}

