/*
  Given: (x:Int) => x+y
  x is the bounded variable
  y is the free variable
 */
//val sum =  (x:Int) => x+y // -> wont work because y is not known
val y = 900
val sum2 =  (x:Int) => x+y // -> will work because y is known
sum2(3)

/*
  Where the compiler catches free variables in the context of function
   literals is called CLOSURE
   Function values dont have free variables: (x:Int) => x+1
   Closures  have free variables: y=8;(x:Int) => x+y
 */


/*Case 1 - Free variables change after function value is created*/
var caseFree = 20
val summy = (x:Int) => x+ caseFree
summy(80)
caseFree = 10
summy(80)


/*Case 2 - Function value changes the value of the free variables*/
var case2var = 10
val calculateSum = (numbers:Seq[Int]) => numbers.foreach(case2var += _)
calculateSum(Seq(1,2,3,4,5,6,7,8,9,10))
case2var


/*Case 3 - The free variable is a local variable in the function literal*/
def multiplier(factor:Int) = (n:Int) => n* factor
val double = multiplier(2)
val quadruple = multiplier(4)
double(2)
quadruple(4)

/* Free variables are stored on the heap not the stack*/