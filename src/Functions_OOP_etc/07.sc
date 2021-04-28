/*
  Illustrating Inheritance with Abstract classes
  These are classes  with abstract fields and methods.
  i.e methods/fields without implementation
  They reason why abstract classes are used is because, You may want
  child classes to have a common field/method but different
  implementation
 */
abstract class Employee4{

//  abstract fields
  val first: String
  val last: String
}

/*
    The first concrete class that extends the abstract class
     defines  the values of the abstract fields
 */

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


/*
    Inheritance is a "is-a" relationship
    Composition is a "has-a" relationship
 */