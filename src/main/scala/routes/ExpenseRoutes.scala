
package routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import models.Expense
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
   */

  def route: Route = pathPrefix("api" / "expenses") {
    post{
      entity(as [Expense]) { expense =>
        if(expenseRepo.create(expense) == 0)
          failWith(new Exception(s"Cannot create expense $expense "))
        else
          complete(s"Expense created successfully $expense ")
      }
    } ~
      get{
        complete(expenseRepo.getAll())
      }

  }

}