def code = { 123 }

assert code() == 123

assert code.call() == 123


def isOdd = { int i -> i%2 != 0}

assert isOdd(3) == true 

assert isOdd(4) == false

assert isOdd.call(2) == false               