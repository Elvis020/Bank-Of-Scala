package Bank_Of_Scala_Project

import java.util.UUID

abstract class Product {
  val uniqueProductID:UUID = UUID.randomUUID()
  val nameOfProduct:String
  override def toString: String = s"Name Of Product = $nameOfProduct"
}
/********************* Deposit Products******************* */
abstract class Deposit extends Product{
  val interestPerYear: Double
  val minimumBalancePerYear:Int
}
abstract class Lending extends Product{
  val annualFee: Double
  val apr:Double
  val rewardsPercent:Double
}
/********************* Checking Products******************* */
abstract class Checkings extends Deposit
class CoreChecking(balance:Dollars, rate:Double) extends Checkings{
  println("Created Core Checking Product")
   val interestPerYear: Double = rate
   val minimumBalancePerYear: Int = balance.amount
   val nameOfProduct: String = "Core Checking"
}
class StudentChecking(balance:Dollars, rate:Double) extends Checkings{
  println("Created Student Checking Product")
  val interestPerYear: Double = rate
  val minimumBalancePerYear: Int = balance.amount
  val nameOfProduct: String = "Student Checking"
}



/********************* Savings Products******************* */
abstract class Savings extends Deposit{
  val transactionsAllowedPerMonth: Int
}
class RewardSavings(balance:Dollars, rate:Double, trans:Int) extends Savings{
  println("Created Reward Savings Product")
   val transactionsAllowedPerMonth: Int = trans
   val interestPerYear: Double = rate
   val minimumBalancePerYear: Int = balance.amount
  val nameOfProduct: String = "Reward Savings"
}


/********************* Lending Products******************* */
class CreditCardFees(fees:Double, rate:Double, percent:Double)  extends Lending{
   val annualFee: Double = fees
   val apr: Double = rate
   val rewardsPercent: Double = percent
   val nameOfProduct: String = "Credit Card"
}
