
// Values and variables

// val
val pi = 3.142
pi = 3.14285 // <- error

// var
var sal = 10000.0
sal = sal * 1.05

// def
def f = { println("foo"); 1 + 2 }
f+3
f+5

// ** Block expressions **

val i = 2+5
val j = i*3

val j = { 
  val i = 2+5
  i*3
}

// ** nested block expressions **

val j = {
    val i = {
        val k = 2
        k*3
    }
    i+3
}

// ** match expressions **

val x = 10; val y = 20;
val max = (x > y) match {
    case true => x
    case false => y
}

val month = "Oct"
val kind = month match {
    case "Mar" | "Apr" | "May" | "Jun" => "Spring"
    case "Jul" | "Aug" | "Sep" => "Summer"
    case "Oct" | "Nov" => "Fall"
    case "Dec" | "Jan" | "Feb" => "Winter"
}

// value binding match
val message = "Ok"
val status = message match {
    case "Ok" => 200
    case other = {
        println(s"Couldn''t parse $other")
        -1
    }
}

// pattern guards
val response: String = null
response match {
    case s if s != null => println(s"Received '$s'")
    case s => println("Error! Received a null response")
}

// matching based on on type
val s = "Hello"
val y: Any = s

y match {
    case i: Int => "integer: " + i
    case _: Double => "a double"
    case s: String => "I want to say " + s
}


// ** if-else expression **

var x = 5
val lx = if ( x < 10 ) "lesser" else "greater"
x = 15
val gx = if ( x < 10 ) "lesser" else "greater"

var x = 5
val lx = if ( x < 10 ) "lesser" // lx: Any 
x = 15
val gx = if ( x < 10 ) "lesser" // <- gx: Any = ()

// ** While loop **

var i = 0
val x = while (i < 5) { 
    println(i)
    i = i+1
} // <- x: Unit = ()


// ** for comprehensions **

for (x <- 1 to 7) println( s"Day $x:" )

for (x <- 1 to 7) yield { s"Day $x:" }

for (x <- 1 to 5; y <- 1 to 3) 
  println( s"($x, $y)" )

val threes = 
  for (x <- 1 to 30 if x % 3 == 0) yield  x

val powersOf2 = 
  for (i <- 0 to 8; pow = 1 << i) yield pow

// ** methods and functions **

def sq(x: Int) = { x * x }
def area(r: Int) = 3.14 * sq(r)

// ** named and default arguments



def area(r: Double) = 3.14 * r * r
area // <- error

val area_fn = area(_)
area(2)
area_fn(2)

val area_fn = new Function1[Double, Double] {
    def apply(r: Double): Double = area(r)
}
area_fn(2)


// ** partial application of functions **

def multiply(x: Int, y:Int) = { x * y }
val double = multiply(2, _: Int)
double(10)
val thrice = multiply(3, _: Int)
thrice(10)

// ** Anonymous functions **

(x: Int) => x+1 // res68: Int => Int = <function1>
res68(10)

val add1 = (x: Int) => x+1
add1(10)

// anonymous fn with multiple parameters
val seq = (x: Int, y:Int) => { (x to y).mkString(",")}
seq(5, 10)

// with no parameters
val fileSep = () => { System.getProperty("file.separator") }
val platform = () => { 
    if( fileSep().equals("/") ) "Linux" 
    else "Windows"
}
platform // () => String = <function0>

def getName(path: String) = {
    path.substring( path.lastIndexOf(fileSep() + 1) )
}
getName( "/home/john/spark/README.md" )

// ** higher-order functions **

def reverser(s: String) = s.reverse
reverser(null) // <- error

def safeStringOp(s: String, f:String => String) = {
    if( s != null ) f(s) else s
}

safeStringOp("Awesome", reverser) // <- automatic eta-expansion
safeStringOp(null, reverser)

def toLower(args: String*) = {
    args.map( arg => arg.toLowerCase )
}
toLower("Dash", "THOMAS", "JAmes", "percy")


// ** placeholders **

def combine(x: Int, y: Int, f: (Int, Int) => Int) = f(x,y)
combine( 2, 5, _ * _ )

def combine(x: Int, y: Int, z: Int, f: (Int, Int, Int) => Int) = f(x,y,z)
combine( 2, 5, 6, _ * _ + _ )

// by-name parameters
def doubles(x: => Int) = {
    println("Now doubling " + x)
    x*2
}

doubles(5)

def f(i: Int) = { println(s"Hello from f($i)"); i}
doubles( f(5) )


def nano() = {
    println("Getting nano")
    System.nanoTime
}
def delayed(t: => Long) = { 
    println("In delayed method")
    println("Param: " + t)
    t
}
println(delayed(nano()))


// ** procedures **
def box(s : String) {
  val border = "-" * s.length + "--\n"
  println(border + "|" + s + "|\n" + border)
}

def box(s : String): Unit = {
  val border = "-" * s.length + "--\n"
  println(border + "|" + s + "|\n" + border)
}































