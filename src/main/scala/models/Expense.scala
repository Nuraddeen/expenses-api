package models

/**
 * The case class for expense
 * @param date String the date of the expense [required]
 * @param value Float The value of the expense [required]
 * @param reason String The reason of the expense [required]
 */
case class Expense(date: String, value: Float, reason: String)
