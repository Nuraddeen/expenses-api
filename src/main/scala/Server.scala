import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import repos.ExpenseRepository
import routes.ExpenseRoutes

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success}

object Server {


  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem(Behaviors.empty, "my-system")
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.executionContext

    val expenseRoutes = new ExpenseRoutes(ExpenseRepository()).route

    val bindingFuture = Http().newServerAt("localhost", 8080).bind(expenseRoutes)

    bindingFuture.onComplete {
      case Success(_) =>
        println(s"Server online at http://localhost:8080")
      case Failure(_) =>
        println(s"Unable to start the server")
    }

    Await.result(bindingFuture, 2.seconds)
  }

}
