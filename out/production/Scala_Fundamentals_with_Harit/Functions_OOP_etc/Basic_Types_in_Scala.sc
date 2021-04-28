/* No interpolator */
val color = "White"
val price = 10.23
println("The price for " + color + " poster is: " + price)

/* Using string interpolator */
println(s"The price for $color poster is: $price")
// String interpolator doesn't work well when working with the
// properties of objects.So {} is used

class Poster(val width:Int,val height:Int,val color:String,val price:Double)
val whitePoster = new Poster(8,11,"white",10.23)
println(s"$whitePoster.price")//doesn't work well with obj properties

println(s"The price is ${whitePoster.price}")
s"The price of ${whitePoster.width}x${whitePoster.height} ${whitePoster.color} poster is: ${whitePoster.price}"

/* Using raw interpolator */
"I treat escape literals(\\ \\ \\ -> prints 3) differently"
raw"I don't treat escape literals(\\ \\ \\ -> prints 6) differently"

/* Using f-string interpolator */
math.E
f"${math.E}%.2f"

/* prefix Operator */
val negative = -100

/* postfix Operator */
val hun = 100 toLong

/* infix Operator */
val add = 100.+(32)

/* Unary Operator */
class Text(val str:String){
  def unary_!() = new Text(s"$str !!")
  override def toString: String = str
}
val newText = new Text("wow")
!newText