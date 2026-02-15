package com.example.kotlin.module2

class KExtension {
    //Extension functions
    fun String.lastChar() = this.get(this.length -1)
    fun String.lastChar2() = (this.length - 1)
    val c: Char = "abc".lastChar()
    //Calling Extension Function from java code
    //Java Resource


}