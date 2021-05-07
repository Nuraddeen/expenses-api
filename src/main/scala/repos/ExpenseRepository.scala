package repos

import models.Expense
import database.DbContext.ctx
import  ctx._
/**
 * This class acts as repository for expenses.
 * It performs basic db operations on expenses, such as saving and retrieving
 */
case class ExpenseRepository () {
  val expenses = quote(query[Expense])


  /**
   * returns the list of all expenses from the database
   * @return List[Expense]
   */
  def getAll(): List[Expense] = run {
    expenses
  }

  /**
   * saves an expense record to the database
   * @param expense The expense object
   * @return Int 1 for success, 0 for failure
   */
  def create(expense: Expense): Long = run {
    expenses.insert(lift(expense)) //1 success, 0 failure
  }


}
