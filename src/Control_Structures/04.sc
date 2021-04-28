/* Using function literals with byName and ByValue*/
def assertTrue(predicate: => Boolean):Boolean = predicate

val ass1 = assertTrue(2>4)
val ass2 = assertTrue(2 +9 > 4-21)

/*By value: Code evaluated before being passed to function*/
def ifEval(predicate: Boolean, ifTrue:String, ifFalse: String):String = {
  if (predicate) ifTrue else ifFalse
}

ifEval(1>0,
  {println("true branch executed");"TRUE"},
  {println("false branch executed");"FALSE"},
)

/*By name: Code evaluated only when a condition matches*/
def ifByName(predicate:Boolean, ifTrue: => String, ifFalse: =>String) = if (predicate) ifTrue else ifFalse



ifByName(1>0,
  {println("true branch executed");"TRUE"},
  {println("false branch executed");"FALSE"},
)












