val testFunction: ((Int,String) => String) = (a:Int,b:String) => {s"$b$a$b"}
val testFunction2 = (a:Int,b:String) => {s"$b$a$b"}
val result = testFunction(5,"-")
val result2 = testFunction2(5,"/")

/*
The function literal is a syntatic sugar for the def
  We use function literals when:
    1. we pass it to HOF
    2. we return it from a HOF
 */

val listOfCustomers:List[String] = List("Donald","Abena","Ama","Kofi","Bamboo","Fiifi","Donkor","Seymor")
/* Using function literals*/
val upper = listOfCustomers map(x => x.toUpperCase)