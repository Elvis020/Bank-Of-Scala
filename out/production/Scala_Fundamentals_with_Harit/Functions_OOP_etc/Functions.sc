/* Without local functions */
class Calculator{
  def double(n:Int):Int = n * 2
  def squared(n:Int):Int= math.pow(n,2).intValue()
  def cubed(n:Int):Int= math.pow(n,3).intValue()
  def sumOfSquares(a:Int,b:Int):Int = squared(a)+squared(b)
  def multiplyDoubles(a:Int,b:Int):Int = double(a)*double(b)
  def divisionOfCube(a:Int,b:Int):Int = cubed(a)/cubed(b)
}
/*
  Using Local functions, we nest some functions into others, so that
  we abstract it from the client
 */

//val calc= new Calculator
//val summy = calc.sumOfSquares(2,3)
//val multy = calc.multiplyDoubles(2,3)
//val divvy = calc.divisionOfCube(5,2)


/* With local functions */
class LocalizedCalcuator{
  def sumOfSquares(a:Int,b:Int):Int = {
    def squared(n:Int):Int= math.pow(n,2).intValue()
    squared(a)+squared(b)
  }
  def multiplyDoubles(a:Int,b:Int):Int ={
    def double(n:Int):Int = n * 2
    double(a)*double(b)
  }
  def divisionOfCube(a:Int,b:Int):Int = {
    def cubed(n:Int):Int= math.pow(n,3).intValue()
    cubed(a)/cubed(b)
  }
}

val calc= new LocalizedCalcuator
val summy = calc.sumOfSquares(2,3)
val multy = calc.multiplyDoubles(2,3)
val divvy = calc.divisionOfCube(5,2)
