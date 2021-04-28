package Bank_Of_Scala_Project

import java.util.UUID

abstract class Account{
  val uniqueAccountID:UUID = UUID.randomUUID()
  val customer: Customer
  val product: Product
  def getBalance: Dollars
}

/*
    the function require is a pre-condition: Tests an expression,
    throwing an IllegalArgumentException if false.
 */

class DepositAccount(val customer:Customer, val product:Product,private var balance: Dollars ) extends Account {

  def deposit(dollars: Dollars):Unit = {
    require(dollars.amount > 0, "amount deposited should be greater than 0")
    println(s"Depositing $$${dollars.amount} to $customer account")
    balance += dollars
  }
  def withdraw(dollars: Dollars) = {
    require(dollars.amount > 0 && balance > dollars, "amount should be greater " +
      "than 0 and requested amount should be less than or equal to the balance")
    println(s"Withdrawing $$${dollars.amount} to $customer account")
    balance -= dollars
  }

  override def getBalance:Dollars = balance
  override def toString: String = s"$customer with $product has remaining balance of $$$balance"

}
class LendingAccount(val customer: Customer, val product:Lending,private var balance: Dollars ) extends Account {

  def payBill(dollars: Dollars) = {
    require(dollars.amount > 0, "The payment must be made for an amount greater than 0")
    println(s"Paying bill of $$${dollars.amount} against $customer account")
    balance += dollars
  }
  def withdraw(dollars: Dollars) = {
    require(dollars.amount > 0, "Withdrawal amount should be greater than 0")
    println(s"Debiting $$${dollars.amount} from $customer account")
    balance -= dollars
  }
  override def getBalance:Dollars = balance
  override def toString: String = s"$customer with $product has remaining balance of $$$balance"

}
