package com.example.a2023_02_sup_parisa.model

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

    val randomName = RandomName()
    randomName.add("bobby")
    repeat(10) {
        println(randomName.next() + " ")
    }
}

class RandomName {
    private val list = arrayListOf("Toto", "Tata", "Titi")

    private var oldValue = ""

    fun next2() = Pair(nextDiff(), nextDiff())

    fun nextDiffV2() = list.filter { it != oldValue }.random().also { oldValue = it }
    fun nextDiff(): String {
        var value = next()
        while (value == oldValue) {
            value = next()
        }
        oldValue = value
        return value
    }

    fun add(name: String?) =
        if (!name.isNullOrBlank() && name !in list)
            list.add(name)
        //list += name
        else false

    fun next() = list.random()


}

/* -------------------------------- */
// API Weather
/* -------------------------------- */
data class WeatherBean(var main: TempBean, var wind: WindBean, var name: String, var weather:List<DescriptionBean>?)
data class TempBean(var temp: Double, var temp_min:Double, var temp_max:Double)
data class WindBean(var speed: Double)

data class DescriptionBean(var description:String, var icon:String)

/* -------------------------------- */
// Exo
/* -------------------------------- */

class PlaneBean(name: String) {
    var id = name.hashCode()
        private set

    var name = name
        set(value) {
            field = value
            id = name.hashCode()
        }
}

class UserBean(val name: String, var note: Int = 0) {
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