  // sum of all integers between given two integers a and b
  // sumOfInts(2,5) = 2+3+4+5 = 14
  
  def sumOfInts(a:Int, b:Int): Int = {
    if(a > b) 0 else a + sumOfInts(a+1, b)
  }                                               

  sumOfInts(2,5)                                 

  // sum of squares for all integers between given a and b
  // sumOfSquares(2,5) = 2^2 + 3^2 + 4^2 + 5^2
  
  def square(x:Int) = x*x                        
  def sumOfSquares(a:Int, b:Int):Int = {
    if(a > b) 0 else square(a) + sumOfSquares(a+1, b)
  }                                              
  
  sumOfSquares(2,5)                             
  
  // sum of all powers of two
  // sumPowersOfTwo(2,5) = 2^2 + 2^3 + 2^4 + 2^5
  // 2^5 = 2*2*2*2*2 = 2*2^4 = 2*2*2^3
  // 2^n = 2*2^(n-1)
  def powerOfTwo(x: Int):Int = if(x==0) 1 else 2*powerOfTwo(x-1) // Math.pow(2,x)
                                                 
  def sumPowersOfTwo(a:Int, b:Int): Int = {
    if(a > b) 0 else powerOfTwo(a) + sumPowersOfTwo(a+1, b)
  }                                              
  
  // SUM_i=(a to b)  f(i)
  // f(i) = i
  
  // --------------------------------------------------
  def sum( a:Int, b:Int, f: Int => Int):Int = {
     if( a > b ) 0 else f(a) + sum( a+1, b, f )
  }                                             

  def sumOfSquares_2(a:Int, b:Int): Int = sum(a,b,square)
                                                 
  def sumPowersOfTwo_2(a:Int, b:Int): Int = sum(a,b,powerOfTwo)

  def identity(x:Int) = x                         
  def sumOfInts_2(a:Int, b:Int): Int = sum(a,b, identity)
  
  // --------------------------------------------------

  // Function literals AKA anonymous function
  def sumOfSquares_3(a:Int, b:Int):Int = sum(a, b, (x:Int) => x*x)

  def sumOfCubes(a:Int, b:Int): Int = sum(a, b, (x:Int) => x*x*x )

  def sumOfInts_3(a:Int, b:Int): Int = sum(a, b, (x:Int) => x )

  def foo(str: String) = { str + "_foo" }        


  val s = "Hello"                                 
  foo(s)                                        

  foo("Hello")                                    //> res3: String = Hello_foo
