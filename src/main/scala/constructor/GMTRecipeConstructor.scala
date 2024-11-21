package constructor

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.Materializer

import scala.concurrent.Future
import service.RecipeService
import service.RecipeJsonProtocol._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import service.RecipeService.getRecipeById


object GMTRecipeConstructor {

  implicit val system: ActorSystem = ActorSystem("recipe-system")
  implicit val materializer: Materializer = Materializer(system)
  implicit val executionContext = system.dispatcher

  val route =
    pathPrefix("recipes") {
      pathEnd {
        get {
          complete(RecipeService.getAllRecipes)
        }
      } ~
        path(IntNumber) { id =>
          get {
            getRecipeById(id) match {
              case Some(recipe) => complete(recipe)
              case None => complete(s"Recipe with ID $id not found")
            }
          }
        }~
        delete {
          complete {
            RecipeService.deleteRecipe(id).map {
              case 1 => s"Recipe with ID $id deleted successfully"
              case _ => s"Recipe with ID $id not found"
            }
          }
        } ~
        put {
          entity(as[Recipe]) { updatedRecipe =>
            complete {
              RecipeService.updateRecipe(id, updatedRecipe).map {
                case 1 => s"Recipe with ID $id updated successfully"
                case _ => s"Recipe with ID $id not found"
              }
            }
          }


  def startServer(): Future[Http.ServerBinding] = {
    Http().newServerAt("localhost", 8080).bind(route)
  }

  def main(args: Array[String]): Unit = {
    startServer().onComplete {
      case scala.util.Success(binding) =>
        println(s"Server online at http://localhost:8080/")
      case scala.util.Failure(ex) =>
        println(s"Failed to bind HTTP server: ${ex.getMessage}")
        system.terminate()
    }
  }
}


