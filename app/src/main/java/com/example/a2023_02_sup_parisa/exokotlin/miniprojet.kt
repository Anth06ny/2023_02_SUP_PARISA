package com.example.a2023_02_sup_parisa.exokotlin

import com.example.a2023_02_sup_parisa.model.RequestUtils

fun main() {
    //val html = RequestUtils.sendGet("https://www.google.fr")
//    val html = RequestUtils.sendGet("https://api.openweathermap.org/data/2.5/weather?q=Toulouse&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")
//    println("html=$html")

    val weather = RequestUtils.loadWeather("Nice")
    println("Il fait ${weather.main.temp}° à ${weather.name} avec un vent de ${weather.wind.speed} km/h")

}