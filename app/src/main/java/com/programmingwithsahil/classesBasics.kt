package com.programmingwithsahil

// import kotlinx.coroutines.ParentJob

//best practice is to use important parameters before default parameters
class Car(model:String, make:String="Maruti", color:String="White"){
    // init is generally used to assign variables to parameters such that they can be used inside class
    init {
        println("Car is being created $make  $model and $color")
    }
}

// constructor defined while declaring class are primary constructor
class Person constructor(firstName:String, lastName:String){
    // example of custom getter and setter , we dont need this generally
    // if we do declare by private, we cannot read or edit this variable from outside Person class
    var fname : String = "defaultValue"
        // reading the value, to restrict read from outside -> private get()
        get() = field //getter for fname
        // setting the value, to restrict setting from outside -> private set()
        set(value) { //setter for fname
            // you can do variable validations in our setter
            if(value.length > 4) {
                field = value
            }
        }

    lateinit var lname : String
    // this is the secondary constructor, function overloading
    // Also secondary constructor must call primary constructor , thatsy this
    constructor(firstName:String, lastName:String,age:Int) : this(firstName , lastName ) {
        println("Creating a person with age $age")
    }
    // init function is called when creating an object out of class
    // init method has access to all the parameters passed in class
    init {
        println("Creating a person with name $firstName $lastName")
        fname = firstName
        lname = lastName
    }
    fun eat(){
        println("$fname $lname started eating.")
    }

}

//same as classes but only used to store data, need
data class User(var firstName: String , var lastName: String){

}

// Inheritance
// by default all classes are final(cannot be inherited from) in kotlin, hence we need to add open before class
open class Animal(type:String, name:String){
    var atype: String
    var aname : String
    init {
        atype = type
        aname = name
    }
    // open is written for function overriding
    open fun play(){
        println("$atype $aname is playing")
    }
}

class Dog(type:String, name:String, breed:String) : Animal(type,name) {
    var dbreed: String
    init {
        dbreed = breed
    }
    fun bark(){
        println(" $dbreed is barking")
    }
    override fun play(){
        println("$dbreed is playing ")
    }
}

//interface
interface myInterface {
    fun foo()
    fun bar()
}
class Child : myInterface {
    override fun foo(){
        TODO("Not yet implemented")
    }
    override fun bar() {
        TODO("Not yet implemented")
    }
}

fun main(){
    var car1 = Car("XL6") // rest values are coming from default parameters
    // when we create an object with 3 parametes it calls the secondary constructor
    var p1 = Person("Sahil","Gupta", 21)
    p1.fname = "NewSaghik"
    p1.lname = "LateSahil"
    p1.eat()
    var p2 = Person("Shreeya","Gupta")
    p2.eat()

}

fun myfun(a:Int){
    val a = 10 //Shadowing , function's parameter is being shadowed
    println(a)
}
