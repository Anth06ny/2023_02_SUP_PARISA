package com.example.a2023_02_sup_parisa

import java.util.*

fun main() {
//    var car = CarBean("Seat", null)
//    car.color = "Grise"
//
//    println(car)
//    println("C'est une ${car.marque} ${car.model ?: "-"} ${car.color}")
//
//    var student = StudentBean("Toto")
//    student.note++

//    val plane = PlaneBean("Toto")
//    println("${plane.name} : ${plane.id}")
//    plane.name = "bob"
//    println("${plane.name} : ${plane.id}")
//    //L'id doit avoir changé

     var p =  PlaneBean("toto")
     var p2 =  PlaneBean("toto")
}

class PlaneBean (name:String){
    var id = name.hashCode()
        private set

    var name = name
        set(value) {
            field =value
            id = name.hashCode()
        }
}

class UserBean(val name:String, var note:Int = 0){
    val id = name.hashCode()
}

class PrintRandomIntBean(var max: Int) {
    private var random = Random()

    init {
        println("init")
        println(random.nextInt(max))
        println(random.nextInt(max))
        println(random.nextInt(max))
    }

    constructor() : this(100) {
        println("constructor 2")
        println(random.nextInt(max))
    }
}

class StudentBean(val name: String) {
    var note = 0
}

data class CarBean(var marque: String, var model: String?) {
    var color = ""
}