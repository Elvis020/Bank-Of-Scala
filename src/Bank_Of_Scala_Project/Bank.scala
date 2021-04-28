package Bank_Of_Scala_Project

import java.time.LocalDate
import java.util.UUID

class Bank(val n:String,val c:String,val co:String,val e:Email) {
  println(s"$n Established 2018.")
  private var customers:Map[UUID,Customer] =Map.empty
  private var depositProducts:Map[UUID,Deposit]=Map.empty
  private var depositAccounts:Map[UUID,DepositAccount]=Map.empty
  private var lendingProducts:Map[UUID,Lending]=Map.empty
  private var lendingAccounts:Map[UUID,LendingAccount]=Map.empty


  def createNewCustomer(first:String,last:String, email:String,dateOfBirth:String):UUID = {
    def getEmail:Email = {
      val Array(value,domain) = email.split('@') // Array destructuring
      Email(value,domain)
    }
    def getDateOfBirth:LocalDate = {
      val Array(year,month,day) = dateOfBirth.split("/")
      LocalDate.of(year.toInt,month.toInt,day.toInt)
    }

    val customer = new Customer(first,last,getEmail,getDateOfBirth)
    customers += (customer.uniqueCustomerID -> customer)
    customer.uniqueCustomerID
  }

  def addNewDepositProducts(nameOfProduct:String,minBalance:Int, ratePerYear:Double,transactionsAllowedPerMonth:Int = 2):UUID = {
    val product = nameOfProduct match {
      case "CoreChecking" => new CoreChecking(Dollars(minBalance),ratePerYear)
      case "StudentChecking" => new StudentChecking(Dollars(minBalance),ratePerYear)
      case "RewardSavings" => new RewardSavings(Dollars(minBalance),ratePerYear,transactionsAllowedPerMonth)
    }
    depositProducts += (product.uniqueProductID -> product)
    product.uniqueProductID
  }
  def addNewLendingProducts(annualFees:Double,apr:Double, rewardsPercent:Double):UUID = {
    val product = new CreditCardFees(annualFees,apr,rewardsPercent)
    lendingProducts += (product.uniqueProductID -> product)
    product.uniqueProductID
  }

  def openDepositAccount(uniqueCustomerID:UUID,uniqueProductID:UUID,amount:Dollars):UUID = {
    require(customers.get(uniqueCustomerID).nonEmpty,s"Customer with id:$uniqueCustomerID not found!")
    require(depositProducts.get(uniqueProductID).nonEmpty,s"Deposit product with id:$uniqueProductID not found!")
    val account = new DepositAccount(customers(uniqueCustomerID),depositProducts(uniqueProductID),amount)
    depositAccounts += (account.uniqueAccountID -> account)
    account.uniqueAccountID
  }
  def openLendingAccount(uniqueCustomerID:UUID,uniqueProductID:UUID,balance:Dollars = Dollars(0)):UUID = {
    require(customers.get(uniqueCustomerID).nonEmpty,s"Customer with id:$uniqueCustomerID not found!")
    require(lendingProducts.get(uniqueProductID).nonEmpty,s"Lending product with id:$uniqueProductID not found!")
    val lAccount = new LendingAccount(customers(uniqueCustomerID),lendingProducts(uniqueProductID),balance)
    lendingAccounts += (lAccount.uniqueAccountID -> lAccount)
    lAccount.uniqueAccountID
  }

  def deposit(uniqueAccountID:UUID, dollars: Dollars) = {
    require(depositAccounts.get(uniqueAccountID).nonEmpty,s"A valid deposit account must be provided")
    depositAccounts(uniqueAccountID) deposit dollars
  }
  def withdraw(uniqueAccountID:UUID, dollars: Dollars) = {
    require(depositAccounts.get(uniqueAccountID).nonEmpty,s"A valid deposit account must be provided")
    depositAccounts(uniqueAccountID) withdraw  dollars
  }
  def useCreditCard(uniqueAccountID:UUID, dollars: Dollars) = {
    require(lendingAccounts.get(uniqueAccountID).nonEmpty,s"A valid lending account must be provided")
    lendingAccounts(uniqueAccountID) withdraw  dollars
  }
  def payCreditCardBill(uniqueAccountID:UUID, dollars: Dollars) = {
    require(lendingAccounts.get(uniqueAccountID).nonEmpty,s"A valid lending account must be provided")
    lendingAccounts(uniqueAccountID) payBill dollars
  }

  override def toString: String = s"[$n]" +
  s" - ${customers.size} customers " +
  s" - ${depositProducts.size} deposit products " +
  s" - ${depositAccounts.size} deposit accounts " +
  s" - ${lendingProducts.size} lending accounts " +
  s" - ${lendingAccounts.size} lending accounts "
}
