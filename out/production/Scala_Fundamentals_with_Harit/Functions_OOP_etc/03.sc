class Employee3(f:String,l:String,s:Int){
  private val first = f
  private val last = l
  private var stocks = s

  def getFirst:String = first
  def getLast:String = last
  def getStocks:Int = stocks

  def awardMoreStocks(numberOfStocks:Int):Unit = stocks += numberOfStocks

  override def toString: String = s"$first $last $stocks"
}

val bobMartin= new Employee3("Bob","Martin",10)
bobMartin.getFirst
bobMartin.getLast
bobMartin.getStocks

bobMartin.awardMoreStocks(23)
bobMartin.getStocks