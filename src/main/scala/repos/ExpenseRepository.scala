package repos

import models._
import database.DbContext.ctx
import ctx._
import java.time.LocalDate
import java.time.format.DateTimeFormatter;

/**
 * This class acts as repository for expenses.
 * It performs basic db operations on expenses, such as saving and retrieving
 */
case class ExpenseRepository() {

//   val formatters: DateTimeFormatter  =  DateTimeFormatter.ofPattern("yyyy-MM-dd");

//  implicit val encodeDate = MappedEncoding[LocalDate, String](_.format(formatters))
 // implicit val decodeDate = MappedEncoding[String, LocalDate](LocalDate.parse(_))

  /**
   * returns the list of all expenses from the database
   * @return List[Expense]
   */
  def getAll(): List[Expense] =
    run {
      quote(query[Expense])
    }

  /**
   * saves an expense record to the database
   * @param expense The expense object
   * @return Int 1 for success, 0 for failure
   */
  def create(expense: Expense): Long =
    run {
      quote(query[Expense]).insert(lift(expense)) //1 success, 0 failure
    }

  def find(expense: Expense): List[Expense] =
    run {
      quote(query[Expense])
        .filter(ex => ex.reason == lift(expense.reason))
        .filter(ex => ex.date == lift(expense.date))
        .filter(ex => ex.value == lift(expense.value))
      //unique id
    }

  def search(expSearch: ExpenseSearch): List[Expense] =
    run {
      //quote(query[Expense]).filter(exp => exp.date.isAfter(lift(expSearch.dateFrom.minusDays(1))) )
      //quote(query[Expense]).filter(exp => exp.date.isAfter(lift(expSearch.dateFrom.minusDays(1))))
      quote(query[Expense]).filter(_.date >= (lift(expSearch.dateFrom)))
      // ctx.run( query[Expense].filter(exp => infix"#$isAfter(${exp.date}, ${expSearch.dateFrom})" ))
    }

  //ctx.run(query[Person].map(p => infix"#$functionName(${p.name})".as[Int]))

  /*
    if dateFrom is not set or is invalid, use the dafault dateFrom (current month date)
    If the dateTo is not set or is invalid, return only the records of the date in dateFrom


   def searchFilter(expense: Expense, expSearch: ExpenseSearch) : Boolean = {
     expense.date.isAfter(lift(expSearch.dateFrom.minusDays(1)))
   }
   */z
}
