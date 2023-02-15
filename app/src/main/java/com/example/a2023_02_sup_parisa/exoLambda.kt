package com.example.a2023_02_sup_parisa

import kotlin.concurrent.thread

fun main() {
    exo4()
}

data class PersonBean(var name:String, var note:Int)

fun exo4(){
    val list = arrayListOf(PersonBean ("toto", 16),
        PersonBean ("Tata", 20),
        PersonBean ("Toto", 8),
        PersonBean ("Charles", 14))

    println("Afficher la sous liste de personne ayant 10 et +")
    //println(list.filter { it.note >=10 })
    //Pour un affichage de notre choix
    println(list.filter { it.note >=10 }.joinToString("\n") { "-${it.name} : ${it.note}"})

    val isToto = {it:PersonBean -> it.name.equals("toto", true) }
    //TODO
    println("\n\nAfficher combien il y a de Toto dans la classe ?")
    list.count(isToto)

    println("\n\nAfficher combien de Toto ayant la moyenne (10 et +)")
    list.count { isToto(it) && it.note >= 10 }

    println("\n\nAfficher combien de Toto ont plus que la moyenne de la classe")
    val classAverage = list.map { it.note }.average()
    list.count { isToto(it) && it.note >= classAverage }

    println("\n\nAfficher la list triée par nom sans doublon")
    list.distinctBy { it.name.lowercase() }.sortedBy { it.name }.joinToString("\n") { "-${it.name}"}

    println("\n\nAjouter un point a ceux n’ayant pas la moyenne (<10)")
    list.filter{it.note < 10}.forEach { it.note++ }

    println("\n\nAjouter un point à tous les Toto")
    list.filter(isToto).forEach { it.note++ }

    println("\n\nRetirer de la liste ceux ayant la note la plus petite. (Il faut une ArrayList)")
    val minNote = list.minOf{it.note}
    list.removeIf { it.note == minNote }

    println("\n\nAfficher les noms de ceux ayant la moyenne(10et+) par ordre alphabétique")
    list.filter { it.note >= 10 }.sortedBy { it.name }.joinToString("\n") { "-${it.name}"}

}

fun exo2(){

    var compareUsersByName :(UserBean, UserBean)->UserBean =
        {u1, u2 -> if( u1.name.lowercase() >= u2.name.lowercase()) u1 else u2 }

    var comparUsersByNote :(UserBean, UserBean)->UserBean =
        {u1, u2 -> if( u1.note >= u2.note) u1 else u2 }

    val u1 = UserBean("Bob", 19)
    val u2 = UserBean("Toto", 45)
    val u3 = UserBean("Charles", 26)
    println(compareUsers(comparUsersByNote, u1, u2, u3)) // Toto 45
    println(compareUsers(compareUsersByName, u1, u2, u3)) // Bob 19

}

inline fun compareUsers(block:(UserBean, UserBean)->UserBean, u1:UserBean, u2:UserBean, u3:UserBean)= block(block(u1, u2), u3)

fun exo1() {
    val lower : (String)->Unit = { it:String -> println(it.lowercase())}
    val lowerV2 = { it:String -> println(it.lowercase())}
    val lowerV3 : (String)->Unit = { it -> println(it.lowercase())}
    val lowerv4 : (String)->Unit = { println(it.lowercase())}

    val heure :(Int) -> Int = {it/60}

    val max = {a: Int, b:Int-> Math.max(a,b)}
    val reverse :(String) -> String = {it.reversed()}

    val minToMinHour :(Int)-> Pair<Int,Int> = {Pair(it/60, it%60)}



    lower("Un Texte")
}