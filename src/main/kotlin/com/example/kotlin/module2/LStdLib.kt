package com.example.kotlin.module2


//Kotlin Std Lib = Java Std Lib + Kotlin Extensions
class LStdLib {
    val set = hashSetOf(1,7,53)
    val list = arrayListOf(1,7,53)
    val map = hashMapOf(
        1 to "one",
        7 to "seven",
        53 to "fifty-three"
    )
    fun impl(){
        println(set) //class.util.HashSet
        println(list)//class.util.ArrayList
        println(map) //class.util.HashMap
        list.max()
        list.min()
        //etc
    }

    //exampleJoinString
    fun exampleListJoinString(){
        println(listOf('a','b','c','d','e')
            .joinToString(separator = "", prefix = "(", postfix = ")"))
    }
    //gerOrNull
    fun exampleExtGetOrNull(args: Array<String>){
        println("Hello, ${args.getOrNull(0)}" )
    }

    //withIndex
    fun withIndex(){
        for((index,element) in list.withIndex()){
            println("$index: $element")
        }
    }
    //untill
    infix fun Int.until(to: Int): IntRange {
        return IntRange(this,to)
    }
    //to
//    infix fun <A,B> A.to(that: B): Pair(this, that){
//
//    }
    val q = """To code,
        or not to code?..."""
    val r = q.trimMargin()
    val s = q.trimMargin(marginPrefix = "#")
    fun implement(){
        println(q)
        //To code,
        //  or not to code?..
        println(r)
        //To code,
        //or not to code?..
        println(s)
        //To code,
        //or not to code?..
    }
    val regex = "\\d{2}\\.\\d{2}\\.\\d{4}".toRegex()
    fun imple(){
        regex.matches("15.02.2016") //false
        regex.matches("15.02.16")  //true
    }

    //conversion to numbers

    fun toNumber(){
        "123".toInt()
        "1e-10".toDouble()
        "xx".toInt() // number format exception
        "xx".toIntOrNull() // number format exception
    }


    fun sum(list: List<Int>): Int {
        var result = 0
        for (i in list) {
            result += i
        }
        return result
    }
    fun sum2(){

    }

}