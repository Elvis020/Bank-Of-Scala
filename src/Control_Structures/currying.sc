/* Function with no curry*/
def multiplyDem(a:Int,b:Int) = a*b
val result = multiplyDem(2,3)

/* Function with  curry*/
def multiplyDemAgain(a:Int)(b:Int) = a*b
val result2 = multiplyDemAgain(2)(9)
val b = multiplyDemAgain(3) _
val c = b(78)