package Bank_Of_Scala_Project

object Email {
  def apply(value:String, domain:String) = new Email(value,domain)
}
class Email(val value:String, val domain:String) {
  override def toString: String = s"$value@$domain"
}
