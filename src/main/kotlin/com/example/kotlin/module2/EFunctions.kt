@file:JvmName("Crau")
package com.example.kotlin.module2
fun foo () = 0
fun another() = 3

class EFunctions {


    fun max(a: Int ,b: Int): Int {
        return if (a>b) a else b
    }

    fun maxKotlin(a: Int, b: Int) = if (a>b) a else b

    fun displayMax(a: Int, b: Int) {
        println(maxKotlin(a,b))
        println(max(a,b))
    }
    fun displayMaxUnit(a: Int, b: Int):Unit {
        println(maxKotlin(a,b))
        println(max(a,b))
        displayMax(a,b)
    }
    //calling into java
    fun foo () = 2


}