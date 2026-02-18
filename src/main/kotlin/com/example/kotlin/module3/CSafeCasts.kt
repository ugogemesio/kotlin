package com.example.kotlin.module3

class CSafeCasts {

    //Type cast: as

    fun implementsFoo(any: Any, a: Any?) {
        if(any is String) {
            val s = any as String
            s.uppercase()
        }
        if(any is String) {
            any.uppercase()
            //smart cast
        }

        (any as String)?.uppercase()
        val s: String? = any as? String//smaart //==
        val c = if (a is String) a else null
    }
    fun main(args: Array<String>) {
        val s: Any = "abc"
        println(s as? Int)    // null
        println(s as Int?)    // exception
    }

}
