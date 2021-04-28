/*
  Any function that takes a function as an input is known as higher
  order function
 */


def transform(numbers:Seq[Int], functionArgs:Int => Int) = {
  numbers.map(number => functionArgs(number))
}

val someNumbers = Seq(0,1,2,3,4,5,6,7,8,9,10)
val numbersIncrementedBy1 = transform(someNumbers, _+1)
//OR
//val numbersIncrementedBy1 = transform(someNumbers,(x:Int) => x+1)
val numbersSquared = transform(someNumbers, x => math.pow(x,2).intValue())
val multipliedBy2 = transform(someNumbers,  2 * _)


/* Function literal to Function value
  Anytime we write a function literal, Scala does 2 things:
  1. Compile to a class with -> Function traits(Function0,Function1,Function2,...,Function22)

  Function literal: What we write in the source code
  Function value: The object/instance that is generated after the function
  literal is compiled, implementing the Function[N] traits
 */


def multiply:Function2[Int,Int,Int] = (a:Int,b:Int) => a*b
//OR
def multiply2:((Int,Int) =>Int) = (a:Int,b:Int) => a*b
//OR
def multiply3= (a:Int,b:Int) => a*b

/*Function literal as an object*/
multiply
multiply2
multiply3

/*Function literal as a function*/
multiply(2,3)
multiply2(9,8)
multiply3(7,3)