package com.example.a2023_02_sup_parisa

fun main() {
    //val html = RequestUtils.sendGet("https://www.google.fr")
    val html = RequestUtils.sendGet("https://api.openweathermap.org/data/2.5/weather?q=Toulouse&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")
    println("html=$html")
}