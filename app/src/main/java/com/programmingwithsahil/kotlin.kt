package com.programmingwithsahil

fun main(){
    // variables are defined by var
    var count = 1
    // constants are defined by val
    val pi = 3.142
    print("value of count is "+count)

    // DataTypes --> syntax --> val / var variableName : datatype = value
    // It can also automatically give types without explicitly stating types

    // 1. Number
    val byteNum : Byte = 2 // size = 8 bit ; range = -2^(size-1) to 2*(size-1) + 1 ; eg -2^7 to 2^7 + 1
    val shortNum : Short = 1 // size = 16 bit ; -2^15 to 2^15+1
    val intNum : Int = 10000 // size = 32 bit
    val longNum : Long = 123421341241241241 // size = 64 bit
    val floatNum : Float = 244124.321F // size = 32 bit
    val doubleNum : Double = 594334214.0 // size = 64 bit

    // 2. Character
    var c : Char = 'q'
    var fname : String = "Sahil"
    var lname = "Gupta"
    print("\nMy name is $fname $lname")

    // 3. Boolean
    var isItRaining = true

    // Assessment
    var a = 63
    var b = 9
    var ans1: Char = (a+b).toChar()
    a = 44
    b = 57
    var ans2:Char = (a+b).toChar()
    a= 89
    b=32
    var ans3: Char = (a+b).toChar()
    println("\n"+ans1 + "" + ans2 + "" +ans3)

    // types of operators
    // unary(one-operand) eg : ++, -- , binary(two-operands) eg : +-*/% , ternary
    var x = 10
    println("Initialization value of x is $x")
    // if we dont want to us '\n' we can use println
    println("After pre-increment : ${++x}")
    println("After post-increment : ${x++}")

    x = 10
    x+=(x++)+(++x)+x
    // 10 + 10 (11) + 12 + 12
    println("${x}")

    // if-else
    if(5>2){
        println("greater")
    } else {
        println("Smaller")
    }

    // switch case
    val weekDay = 2
    when(weekDay){
        1 -> println("Sunday")
        2 -> println("Monday")
        3 -> println("Tuesday")
        4 -> println("Wednesday")
        5 -> println("Thursday")
        6 -> println("Friday")
        7,14,21 -> println("Saturday") // , is the or operator
        else -> println("Some Other Day $weekDay")
    }
    // range operator initial value..final value
    val num = -5
    when(num){
        in 0..9, in -9..-1 -> println("one digit number") // if number in 0 to 9 OR -0 to -9
        in 10..99 -> println("two digit number")
        in 100..999 -> println("three digit number")
        in 1000..9999 -> println("four digit number")
        else -> println("Very large number")
    }

    //loops
    //for
    for(x in 0..10){
        if (x==4) continue //skips the current iteration
        else if (x==7) break //breaks out of the loop
        else println(x)
    }
    for (x in 10 downTo 0 step 2) //step size -> x += 2
        println(x)
    var i = 0
    //while
    while(i < 20){
        if(i==11) break
        print(i)
        i++
    }
    //do-while
    do {
        println(i)
        i++
    }while (i<20)
    println("Function returned : ${addNum(2,3)}")
    // while calling we can also call by using named parameters
    namePrinter(firstName = "Sahil", lastName = "Gupta") // these in blue are named parameters
    println(multiplyByFactor(2.0))
    power(2,3)

    // Elvis Operator / Null pointer handler
    var str: String? = null
    println(str?.length)
    println(str?.length!!) // non-null assertion
}

// functions syntax
//fun functionName (arg1 : dataType, arg2 : dataType, arg3 : dataType) : returnType {
//    body
//}
fun addNum (num1 : Int, num2 : Int) : Int {
    return num1+num2
}
fun namePrinter(firstName: String, lastName:String){
    println("$firstName $lastName")
}
// default parameters (factor = 2.0) 2.0 is default value of factor argument
// shorthand notation syntax, if function only contain 1 return statement
fun multiplyByFactor(num : Double, factor: Double = 2.0 ):Double = num*factor

fun power(base:Int,exp:Int) {
    var res = 1
    for(i in 1..exp) res *= base
    println(res)
}
