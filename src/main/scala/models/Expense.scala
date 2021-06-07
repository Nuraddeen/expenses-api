package models
import java.time.LocalDate 

import io.getquill.MappedEncoding 

/**
 * The case class for expense
 * @param date String the date of the expense [required]
 * @param value Float The value of the expense [required]
 * @param reason String The reason of the expense [required]
 */
case class Expense(val date: String, val value: Float, val reason: String)


case class ExpenseSearch(val dateFrom: String, val dateTo: String, val minAmount : Float, val maxAmount: Float) {

 //   val defaultDateFrom = LocalDate.now(); // 2020-09-01
  //  val defaultDateTo = new SimpleDateFormat ("yyyy-MM-dd").format(currentDate) //today's date
  //  val defaultDateFrom = new SimpleDateFormat ("yyyy-MM-dd").format(new Date()) //+ "01" //beginning of this month's date
}

 