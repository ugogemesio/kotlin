package com.example.kotlin.module2

class KExtension {
    //Extension functions
    fun String.lastChar() = this.get(this.length -1)
    fun String.lastChar2() = (this.length - 1)
    val c: Char = "abc".lastChar()
    fun List<Int>.sum():Int{
        var result = 0
        for (x in this) {
            result += x
        }
        return result
    }

    //Calling Extension Function from java code
    //Java Resource


}