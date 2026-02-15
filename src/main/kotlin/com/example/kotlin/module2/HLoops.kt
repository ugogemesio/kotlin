package com.example.kotlin.module2
class HLoops {
    //for
    fun impl(){
        val list = listOf("a", "b", "c")
        for (s: String in list) {
            println(s)
        }

        val map = mapOf("1" to 1,
                        "2" to 2,
                        "3" to 3)
        for ((key, value) in map) {
            println("$key = $value")
        }

        for((index, element) in list.withIndex()){
            println("$index: $element")
        }

        for (i in 1..9){
            print(i)
        }
        for (i in 1 until 9){
            print(i)
        }
        for (i in 9 downTo 1 step 2){
            print(i)
        }
        for(ch in "abc"){
            print(ch+1)//bcd
        }
        for (ch in '1' until '9'){
            print(ch)
        }
    }
}