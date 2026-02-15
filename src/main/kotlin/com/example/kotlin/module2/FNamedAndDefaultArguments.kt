package com.example.kotlin.module2;

class FNamedAndDefaultArguments {
    fun printK(){
        println(listOf('a','b','c').joinToString(
            separator = "", prefix = "(", postfix = ")",
        ))
    }//(abc)

    fun displaySeparator(character: Char = '*', size: Int = 10){
        repeat(size){
            print(character)
        }
    }
    //automatic overload
    fun callDisplaySeparator(){
        displaySeparator('*',1)
        displaySeparator('/',2)
        displaySeparator(' ',2)
        displaySeparator('+')
        displaySeparator(size = 1, character = '-')
        displaySeparator(size = 1)
    }
    //8 possible call
    fun sum(a: Int = 0, b: Int = 0, c: Int = 0): Int {
        return a + b + c
    }

    //4 possible call
    @JvmOverloads
    fun sums(a: Int = 0, b: Int = 0, c: Int = 0): Int {
        return a + b + c
    }

}
