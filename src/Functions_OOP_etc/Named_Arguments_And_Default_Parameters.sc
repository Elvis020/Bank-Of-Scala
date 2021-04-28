import java.time.LocalDate

def division(numerator:Int,denominator:Int):Double = numerator.doubleValue()/denominator.doubleValue()
// If you don't want to use named parameters, order does matter
val withoutNamed = division(20,10)
// If you want to use named parameters,order doesn't matter
val withNamed = division(denominator = 32,numerator = 11)

def log(message:String,eventTime:LocalDate = LocalDate.now) = println(s"$eventTime -> $message")
log("I am getting better with Scala")