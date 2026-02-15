package com.example.kotlin.module2

class BHelloWorld {
    fun main(args: Array<String>){
        val name = if (args.size > 0) args[0] else "Kotlin"
        println("Hello, $name!")
    }
    fun callFunctionInString(args: Array<String>) {
        println("Hello, ${args.getOrNull(0)}")
    }
}