//def time(n:Int, operation:Int => Unit) = {
//  val startTime = System.currentTimeMillis()
//  operation(n)
//  val elapsedTime = System.currentTimeMillis() - startTime
//  println(s"*************** Operation took $elapsedTime milliseconds ***************")
//}

//val operation = (n:Int) => {
//  Thread.sleep(1000)
//  val numbers = (1 to n).toList
//  println(s"Sum of first $n numbers is ${numbers.sum}")
//}

//val exec = time(100,operation)

/* Converting the time function to curried*/
def time(n:Int)(operation:Int => Unit) = {
  val startTime = System.currentTimeMillis()
  operation(n)
  val elapsedTime = System.currentTimeMillis() - startTime
  println(s"*************** Operation took $elapsedTime milliseconds ***************")
}

//val exec = time(100){operation} // {} can be replaced with () if argument is 1
time(10000){ n:Int =>
  val num = (1 until n+1).toList
  println(s" Sum of first $n numbers is ${num.sum}")
}