package Bank_Of_Scala_Project

import java.time.LocalDate
import java.util.UUID

import Bank_Of_Scala_Project.BankOfScala.customerIds

import scala.util.Random

object BankOfScala extends App {
  /* new version*/
  println("Opening Bank")
  val bank = new Bank("Bank of Scala","AuckGhanaLand","Ghana",Email("bakOfSc","yahoo.com.gh"))
  val customerIds = getCustomers map {c => bank.createNewCustomer(c._1,c._2,c._3,c._4)}
  val depositingProductsIds = getdepositProducts map {p => bank.addNewDepositProducts(p._1,p._2,p._3)}
  val lendingProductsIds = getLendingProducts map {l => bank.addNewLendingProducts(l._2,l._3,l._4)}

  /* logging*/
  println(s"Bank: $bank")
  println(s"CustomerIDs: $customerIds")
  println(s"Deposit Products IDs: $depositingProductsIds")
  println(s"Bank: $lendingProductsIds")

  def openAccounts(customerId:UUID, productID:UUID, productType:String) = productType match {
    case "Deposits" => bank openDepositAccount(customerId,productID, _:Dollars)
    case "Lending" => bank openLendingAccount(customerId,productID, _:Dollars)
  }

  /*
  Bank clerk opening account. There is no money deposited in the account yet, so accounts are not yet active
 */

  val depositAccounts = for {
    c <- customerIds
    p <- depositingProductsIds
  } yield openAccounts(c,p, "Deposits")



  /* Depositing money into the accounts*/
  val random = new Random(100)
  val depositAccountIds = depositAccounts map{account => account(Dollars(1000 + random.nextInt(1000)))}

  /* Logging*/
  println(s"Deposits Account: $depositAccounts")
  println(s"Deposits Account Ids: $depositAccountIds")


  /*
  Open credit card account
  The bank process has not finished the credit check,so balance wil be known later
 */
  val lendingAccounts = for{
    c <- customerIds
    p <- lendingProductsIds
  } yield openAccounts(c,p, "Lending")
  val lendingAccountsIds = lendingAccounts map(account => account(Dollars(random.nextInt(500))))

  /* Logging*/
  println(s"Lending Account: $lendingAccounts")
  println(s"Lending Account Ids: $lendingAccountsIds")
  println(s"Bank: $bank")


  /* Performing Deposit Account Transactions*/
  val randomAmount = new Random(100)
  depositAccountIds foreach {accountId =>
    bank deposit(accountId, Dollars(1+randomAmount.nextInt(100)))
    bank withdraw (accountId, Dollars(1+randomAmount.nextInt(50)))
  }


  /* Performing Lending Account Transactions*/

  lendingAccountsIds.foreach{accountId =>
    bank useCreditCard (accountId, Dollars(1+randomAmount.nextInt(500)))
    bank payCreditCardBill (accountId, Dollars(1+randomAmount.nextInt(100)))
  }

  /* old version*/
  //  val coreChecking = new CoreChecking(new Dollars(1000),0.025)
//  val studentChecking = new StudentChecking(new Dollars(0),0.010)
//  val rewardSavings = new RewardSavings(new Dollars(1000),0.1,1)
//  val creditCard = new CreditCardFees(99.00,14.23,20)
//  val products = Set(coreChecking,studentChecking,rewardSavings,creditCard)
//
//
//  val bobMartin = new Customer("Bob","Martin",Email("bob","martin.com"),LocalDate.of(1983,12,2))
//  val bobCheckingAccount = new DepositAccount(bobMartin,coreChecking,Dollars(1000))
//  val bobSavingsAccount = new DepositAccount(bobMartin,rewardSavings,Dollars(20000))
//  val bobCreditAccount = new LendingAccount(bobMartin,creditCard,Dollars(4500))
//
//
//  val accounts = Set(bobCheckingAccount,bobSavingsAccount,bobCreditAccount)

//  println(bobCheckingAccount)
//  bobCheckingAccount deposit new Dollars(100)
//  println(bobCheckingAccount)
//
//  bobCheckingAccount withdraw new Dollars(200)
//  println(bobCheckingAccount)


  /* Data*/
  def getCustomers():Seq[(String,String,String,String)] = {
    Seq(
      ("Bob","Martin","bob@martin11.com","1976/11/25"),
      ("Amy","Jones","amy@jones321.com","1983/4/21"),
      ("Taylor","Jackson","taylor21@jackie.com","1985/4/5"),
    )
  }

  def getdepositProducts():Seq[(String,Int,Double)] = {
    Seq(
      ("CoreChecking",1000,0.025),
      ("StudentChecking",0,0.010),
      ("RewardSavings",1000,0.010)
    )
  }
  def getLendingProducts():Seq[(String,Double,Double,Double)] = Seq(("CreditCard",99.00,14.23,20.25))

}



