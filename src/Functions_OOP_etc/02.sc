class Employee2(val first:String,val last:String){
  override def toString: String = s"$first $last"
}

val bobMartin = new Employee2("Bob", "Martin")
bobMartin
bobMartin.first
bobMartin.last


// Scala visibility modifiers include: val, var, default, private


class Color(val value:String)
val c = new Color("red")
c.value

class Shape(var value:String)
val s = new Shape("circle")
s.value
s.value = "square"
s.value