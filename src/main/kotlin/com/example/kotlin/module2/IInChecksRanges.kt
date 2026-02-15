package com.example.kotlin.module2

import java.util.Date

class IInChecksRanges {

    fun impl(){
        for (i in 'a'..'z'){
            //impl
        }

        val c='a'

        c in 'a' ..'z'

        isLetter('q')

        isLetter('*')
        isNotDigit('s')
        recognize('!')
    }
    fun isLetter(c: Char) =  c in 'a' .. 'z' || c in 'A' .. 'Z'
    //c in 'a' .. 'z' = 'a' <= c && c <= 'z'
    fun isNotDigit(c: Char) = c !in '0'..'9'
    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z',
        in 'A'..'Z' -> "It's a letter!"
        else -> "I don't know..."
    }

    fun imple (){
        for (i in 0..9){
            print(i)
        }
        'a' in '0'..'9'

        ///
        "Kotlin" in "Java".."Scala"
        "Kotlin" in setOf("Java","Scala")
    }
    //Range of custom types

    fun impla(myDate: Date, endDate: Date, startDate: Date) {
        if(myDate.compareTo(startDate) >= 0 &&
            myDate.compareTo(endDate) >= 0){
        }
    }
    abstract class MyDate: Comparable<MyDate>
    fun impla(myDate: MyDate, endDate: MyDate, startDate: MyDate) {
        if(myDate.compareTo(startDate) >= 0 &&
            myDate.compareTo(endDate) >= 0){
        }
        if(myDate >= startDate && myDate <= endDate){}
        if(myDate in startDate..endDate){}
    }
    //Belonging to collection

    var list = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g')
    var element = 'a'
    fun imp(){
        if (element in list){}//equalTo V
        if(list.contains(element)){}
    }



}