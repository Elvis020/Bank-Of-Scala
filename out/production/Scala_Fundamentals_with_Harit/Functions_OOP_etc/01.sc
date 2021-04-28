println("Welcome to Scala with Harit 😅 ")
class Employee{
  var first:String = ""
  var last:String = ""
  override def toString: String = s"$first $last"
}

val amyJones = new Employee
amyJones.first = "Amy"
amyJones.last = "Jones"

val bobMartin = new Employee
amyJones.first = "Bob"
amyJones.last = "Martin"

val taylorJackson = new Employee
amyJones.first = "Taylor"
amyJones.last = "Jackson"

// Note that there are differences between class parameters and fields
