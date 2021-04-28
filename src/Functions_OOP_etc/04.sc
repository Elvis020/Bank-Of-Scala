class Employee3(f:String,l:String,s:Int){
  private val first = f
  private val last = l
  private var stocks = s
  private val documentCodeByName:Map[String,String] = Map(
    "HR" -> "Human Resources",
    "ACT" -> "Accounts",
    "R&D" -> "Research and Development",
    "MKT" -> "Marketing",
    "SLS" -> "Sales",
    "OPS" -> "Operations"
  )

  def getFirst:String = first
  def getLast:String = last
  def getStocks:Int = stocks

  def awardMoreStocks(numberOfStocks:Int):Unit = stocks += numberOfStocks
  def getDepartmentName(code:String) = documentCodeByName.getOrElse(code, s"The department with the code name $code doesn't exist")

  override def toString: String = s"$first $last $stocks"
}

val bobMartin= new Employee3("Bob","Martin",10)
bobMartin.getFirst
bobMartin.getLast
bobMartin.getStocks

bobMartin.awardMoreStocks(23)
bobMartin.getStocks
bobMartin.getDepartmentName("R&D")

// Singleton objects
//They are objects that can't be instantiated
//They are just one in memory
//Initialized on first access

// There are 2 primary use-cases of singleton objects:
// 1. Companion objects
// 2. Standalone Singleton objects

// Notes on Companion objects
//They are called companion because they are in the same file with the class with the same name
//The object and the class