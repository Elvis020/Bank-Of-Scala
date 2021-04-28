package Bank_Of_Scala_Project

import java.time.LocalDate
import java.util.UUID

class Customer(firstName:String,lastName:String,email:Email,dateOfBirth:LocalDate) {
  val uniqueCustomerID:UUID = UUID.randomUUID()
  val f:String = firstName
  val l:String = lastName
  val e:Email = email
  val dob:LocalDate = dateOfBirth
  override def toString: String = s"$f,$l"
}
