import scala.annotation.tailrec

/*
  Recursion: Occurs when a thing is defined in terms of itself or of its type
  Properties of a recursive function includes:Base case and Recurs to reduce
  The stack grows until the base case is found or stack overflow
  Once the base stack is found, it add up back to the parent stack(or until the first stack is reached)


  With tail recursion, there is no more than 1 stack for the computation of a case
  constant memory is consumed no matter the case.
*/

val n = 5
def sumR(n:Int):Int = {
  if(n==1) n
  else n + sumR(n-1)
}
val rec = sumR(20)

def sumTR(m:Int):Int = {
  @tailrec
  def go(currentNum:Int, totalSoFar:Int = 0):Int = {
    if(currentNum == 0) totalSoFar
    else go(currentNum -1,totalSoFar+currentNum)
  }
  go(m)
}

val tRec = sumTR(20)