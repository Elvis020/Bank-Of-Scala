/*
  A partially applied function is a function where some or not all
  of it arguments are not supplied to the function and the return value is a function

  def sum(a:Int,b:Int,c:Int) = a+b+c
  sum(1,2,<not supplied>)
  sum(1,<not supplied>,3)
  sum(<not supplied>,2,3)
  sum(<not supplied>,<not supplied>,<not supplied>)
 */

def sum(a:Int,b:Int,c:Int) = a+b+c

/*Case 1 - When all arguments are supplied*/
val case1 = sum(1,2,3)

/*Case 2 - When one argument is not supplied*/
val case2a = sum(_:Int,2,3)
val case2b = sum(1,_:Int,3)
val case2c = sum(1,2,_:Int)
case2a(3)
case2b(4)
case2c(5)


/*Case 3 - When two arguments are not supplied*/
val case3a = sum(_:Int,_:Int,3)
val case3b = sum(1,_:Int,_:Int)
case3a(3,3)
case3b(4,6)

/*Case 4 - When no arguments are supplied*/
val case4a = sum(_:Int,_:Int,_:Int)
val case4b = sum _
case4a(3,3,5)
case4b(4,6,90)