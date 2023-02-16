package com.example.a2023_02_sup_parisa.exokotlin

import com.example.a2023_02_sup_parisa.model.PlaneBean
import com.google.gson.Gson

fun main() {
    var planeBean = PlaneBean("Toto")
    var p2 : PlaneBean? = null

    println(planeBean.toJson())
    println(p2.toJson())
}

fun Any?.toJson() = Gson().toJson(this ?: "{}")