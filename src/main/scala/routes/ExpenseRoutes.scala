
package routes

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.model.http2.Http2Exception
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import models._ 
import repos.ExpenseRepository

/**
 * Defines all the routes for expenses
 * @param expenseRepo An instance of ExpenseRepository (injected)
 */
class  ExpenseRoutes (expenseRepo: ExpenseRepository)  {

  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._

  /**
   *  add routes
   * 
   */

  def route: Route = pathPrefix("api" / "expenses") {
    post{
      entity(as [Expense]) { expense =>
        if(expenseRepo.find(expense).nonEmpty)
          complete(StatusCodes.InternalServerError -> "Sorry, that expense record already exists")
        else if(expenseRepo.create(expense) == 0)
          failWith(new Exception(s"Cannot create expense $expense "))
        else
          complete(s"Expense created successfully $expense ")
      }
    } ~
      get{
       // complete(expenseRepo.getAll())
       entity(as [ExpenseSearch]) { expenseSearch =>
       // complete(expenseRepo.search(expenseSearch))
       complete("Finished")
      }
      }

  }

}