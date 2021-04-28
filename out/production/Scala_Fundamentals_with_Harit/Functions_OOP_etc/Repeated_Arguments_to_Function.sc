/* Without repeated parameters */
def lengthOfStrings(strs: Seq[String]) = strs foreach(x => println(s"${x}-> ${x.length}"))
lengthOfStrings(Seq("s","aa","bb","ccc","dddd"))



/* With repeated parameters */
def lengthOfStringsWithR(strs: String*) = strs foreach(x => println(s"${x}-> ${x.length}"))
lengthOfStrings(Seq("zz","pasda","ewqrqw","cqecc","as"))


/* Repeated parameters but the caller has an array passed*/
def incrementBy1(nums:Int*) = nums map(_+1)
val ex1 = incrementBy1(1,2,3,4,5,6,7) //Normal usecase
val arr = Array(1,2,3,4,5,6,7)
val ex2 = incrementBy1(arr: _*) // If passed as an array