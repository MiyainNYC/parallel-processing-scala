// ** sqrt() function **
def sqrtIter(guess: Double, x: Double): Double = {
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)
}

def improve(guess: Double, x: Double) = {
  (guess + x / guess) / 2
}
def isGoodEnough(guess: Double, x: Double) = {
    abs(guess * guess - x) < 0.001
}

def sqrt(x: Double) = sqrtIter(1.0, x)

// with nested functions
def sqrt(x: Double) = {
    def sqrtIter(guess: Double, x: Double): Double = {
        if (isGoodEnough(guess, x)) guess
        else sqrtIter(improve(guess, x), x)
    }

    def improve(guess: Double, x: Double) = {
        (guess + x / guess) / 2
    }

    def isGoodEnough(guess: Double, x: Double) = {
        abs(square(guess) - x) < 0.001
    }
    
    sqrtIter(1.0, x)
}

// using variables from outer scope
def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double = {
        if (isGoodEnough(guess)) guess
        else sqrtIter(improve(guess))
    }
    def improve(guess: Double) = {
        (guess + x / guess) / 2
    }

    def isGoodEnough(guess: Double) = {
        abs(square(guess) - x) < 0.001
    }

    sqrtIter(1.0)
}
