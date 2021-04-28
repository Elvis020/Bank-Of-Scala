class Status(val statusValue:String){
  override def toString: String = statusValue
}
class Priority(val PriorityValue:String){
  override def toString: String = PriorityValue
}
class Task(val taskValue:String,val priority:Priority,val status:Status){
  override def toString: String = s"[P: $priority ][S:$status] - $taskValue"
}


/* Priorities*/
val medium = new Priority("medium")
val high = new Priority("high")
val low = new Priority("low")

/* Statuses*/
val todo = new Status("todo")
val inProgress = new Status("inProgress")
val done = new Status("done")

/* Tasks*/
val t1 = new Task("Finish Scala Module", high,inProgress)
val t2 = new Task("Book tickets for flight",high,todo)
val t3 = new Task("Order wine for Friday",medium,todo)
val t4= new Task("Test Awesome feature ",medium,inProgress)
val t5 = new Task("Reply to Marc",low,todo)
val t6 = new Task("Get stuff done",high,done)
val t7 = new Task("Book accommodation for talk",medium,done)


val listOfTasks:Seq[Task] = Seq(t1,t2,t3, t4,t5,t6,t7)

/* Version 1 of Code*/
//def getHighestPriority:Seq[Task] =for {task <- listOfTasks; if task.priority == high}yield task
//def getLowestPriority:Seq[Task] =for {task <- listOfTasks; if task.priority == low}yield task
//def getInProgressStatus:Seq[Task] =for {task <- listOfTasks; if task.status == inProgress}yield task
//
//getHighestPriority foreach println
//println("------------------------------------")
//getLowestPriority foreach println
//println("------------------------------------")
//getInProgressStatus foreach println


/* Version 2 of Code*/
def taskMatcher(matcher:Task => Boolean):Seq[Task] = {
  for(task <- listOfTasks; if matcher(task)) yield task
}
def getHighestPriority = (task:Task) => task.priority == high
def getLowestPriority:Task => Boolean = (task:Task) => task.priority == low
def getInProgressStatus = (task:Task) => task.status == inProgress
def tasksTodo = (task:Task) => task.status == todo

taskMatcher(getHighestPriority) foreach println
println("------------------------------------")
taskMatcher(getLowestPriority) foreach println
println("------------------------------------")
taskMatcher(getInProgressStatus) foreach println
println("------------------------------------")
taskMatcher(tasksTodo) foreach println