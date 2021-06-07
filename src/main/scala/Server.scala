import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.failWith
import models._
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

    val expenseRepo = ExpenseRepository()

    val expenseRoutes = new ExpenseRoutes(expenseRepo).route

    val bindingFuture = Http().newServerAt("localhost", 8080).bind(expenseRoutes)

    bindingFuture.onComplete {
      case Success(_) =>
        println(s"Server online at http://localhost:8080")
      case Failure(_) =>
        println(s"Unable to start the server")
    }

    Await.result(bindingFuture, 2.seconds)


  //  val exp = Expense("2021-09-23", 2000, "Transport")
    // println(expenseRepo.find(exp).nonEmpty)

   //  println(new ExpenseSearch("", "", 0, 0).defaultDateTo)
    // println(new ExpenseSearch("", "", 0, 0).defaultDateFrom)
    }

}
