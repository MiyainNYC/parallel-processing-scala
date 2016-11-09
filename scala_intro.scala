// Databricks notebook source exported at Wed, 9 Nov 2016 19:04:53 UTC
var sal = 10000

// COMMAND ----------

sal = sal * 4.5

// COMMAND ----------

var sal = 10000.0
sal = sal *1.05

// COMMAND ----------

def f = {println("foo"); 1+2}

// COMMAND ----------

val x = f 

// COMMAND ----------

val i = 2+5; val j = i+3

// COMMAND ----------

val j = {
  val i = 2 + 5
  i * 3
  }

// COMMAND ----------

val x = 10; val y = 20

// COMMAND ----------

val max = (x > y) match {
  case true => x
  case false => y
}

// COMMAND ----------

val status = 300

// COMMAND ----------

val message = status match {
  case 200 => "OK"
  case 404 =>"Not Found"
  case 500 => "Internal Server Error"
  case 502 => "Bad Gateway"
  case _ => "Error"
}

// COMMAND ----------

val message = "not ok"

// COMMAND ----------

val status = message match{
  case "OK" => 200
  case other => {
    println(s"couldn't parse $other")
    -1
  }
}

// COMMAND ----------

val response: String = "200"

// COMMAND ----------

response match{
  case s if s != null => println(s"Received '$s'")
  case s => println("Error! Received a null response")
}

// COMMAND ----------

var x = 8

// COMMAND ----------

val lx = if (x<10) "lesser" else 0

// COMMAND ----------

var i = 0

// COMMAND ----------

val x = while(i<5) {println(i); i = i+1}

// COMMAND ----------

var line = ""
while ((line = readLine()) != "") // This doesn't work
println("Read: "+line)

// COMMAND ----------

for (x <-1 to 7) println( s"Day $x:")

// COMMAND ----------

for (x <- 1 to 7) yield ( s"Day $x:")

// COMMAND ----------

for (x<- 1 to 5; y<- 1 to 3)
println (s"($x, $y)")

// COMMAND ----------

val threes = 
for (x <- 1 to 30 if x%3 == 0) yield x

// COMMAND ----------

val powersOf2 = 
for (i <- 0 to 8; pow = 1<<i) yield pow

// COMMAND ----------

def sq(x:Int) = {x*x}

// COMMAND ----------

def area(r:Int) = 3.14 * sq(r)

// COMMAND ----------

area(8)
