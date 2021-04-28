/*
  Composition Example
 */

abstract class Employee4{
  val first: String
  val last: String
}
abstract class DepartmentEmployee extends Employee4{
  private val secret = "Big Secret"
  val department:String
  val departmentCode:String
  val numberOfStocks:Int
  override def toString: String = s"[$first,$last,$department,$numberOfStocks]"
}


class RnDEmployee(f:String,l:String) extends DepartmentEmployee{
  val department = "Research and Development"
  val departmentCode = "R&D"
  val numberOfStocks = 100
  val first = f
  val last = l
}

class MarketingEmployee(f:String,l:String) extends DepartmentEmployee{
  val department = "Marketing"
  val departmentCode = "MKT"
  val numberOfStocks = 85
  val first = f
  val last = l
}


val rnDEmployee = new RnDEmployee("Amy","Winehouse")
val marketingEmployee = new MarketingEmployee("Bob","Martin")


abstract class Company{
  val name:String
  val numberOfEmployees:Int
  val employees: Set[Employee4]
}
class PluralSight(n:String,emps:Set[Employee4]) extends Company{
   val name = n
   val numberOfEmployees = emps.size
   val employees = emps
}

val pluralSight = new PluralSight("PluralSight Inc.",Set(rnDEmployee,marketingEmployee))
pluralSight.numberOfEmployees

println("Adding numbers in an array trick")
val numbers = Array(1,2,3,4,5,6,7,8,9,10)
println(numbers.foldLeft(0) {(a,b) =>a+b})