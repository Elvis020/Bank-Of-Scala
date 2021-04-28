//Converting the class in 04 into a companion object

object Employee3{
    private val documentCodeByName:Map[String,String] = Map(
    "HR" -> "Human Resources",
    "ACT" -> "Accounts",
    "R&D" -> "Research and Development",
    "MKT" -> "Marketing",
    "SLS" -> "Sales",
    "OPS" -> "Operations"
  )
//   Adding an apply method in order to use the fields
  def apply(first: String, last: String, stocks: Int): Employee3 = new Employee3(first, last, stocks)
  def getDepartmentName(code:String) = documentCodeByName.getOrElse(code, s"The department with the code name $code doesn't exist")
}

class Employee3(f:String,l:String,s:Int){
  private val first = f
  private val last = l
//  Because this is a var, it gives way for race conditions
//  private var stocks = s
//  Changing it to a val prevents this
  private val stocks = s

  def getFirst:String = first
  def getLast:String = last
  def getStocks:Int = stocks

// When var is used
//  def awardMoreStocks(numberOfStocks:Int):Unit = stocks += numberOfStocks

  // When val is used
  def awardMoreStocks(numberOfStocks:Int):Unit = Employee3(first,last,stocks + numberOfStocks)
  override def toString: String = s"$first $last $stocks"
}

val bobMartin= Employee3("Bob","Martin",10)
bobMartin.getFirst
bobMartin.getLast
bobMartin.getStocks

bobMartin.awardMoreStocks(23)
bobMartin.getStocks
Employee3.getDepartmentName("R&D")



// Benefits of immutability
// 1. Easy to reason: Since they cant be modified its easy to use with no complex state
// 2. Share freely: They can be shared freely without creating multiple copies
// 3. Concurrent Safety : Concurrent access to multiple threads  is safe
// since 2 threads cant get access to the object cuz its immutable(prevents race conditions)
// 4. Safe hash keys: They create safe hash table keys