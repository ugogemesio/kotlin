package com.example.kotlin.module2

import java.io.IOException
import kotlin.jvm.Throws

class JException {
    //throw is an exception
    fun implPer(number: Int){
        val percentage =
            if (number in 0 ..100)
                number
            else
                throw IllegalArgumentException("A percentage must be between 0 and 100: $number")
    }
    //try is an expression
    fun implTry(string: String){
        val number = try{
            Integer.parseInt(string)
        }catch (e: NumberFormatException){
            return
        }
    }

    //@Throes annotation

    @Throws(IOException::class)
    fun foo(){
        throw IOException()
    }

    fun afoo() { throw IOException() }
}