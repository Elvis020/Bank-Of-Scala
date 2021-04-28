package Bank_Of_Scala_Project

object Dollars {
  def apply(a:Int) = new Dollars(a)
}
class Dollars (val amount:Int) extends AnyVal{
  def +(value:Dollars):Dollars = new Dollars(amount+value.amount)
  def -(value:Dollars):Dollars = new Dollars(amount-value.amount)
  def >(value:Dollars):Boolean = amount > value.amount

  override def toString: String = s"$$$amount"
}
