package com.example.kotlin.module3

class IReturnLambda {
    fun duplicateNonZero(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0) return listOf()
            listOf(it, it)
        }
    }

    fun imple() {
        println(duplicateNonZero(listOf(3, 0, 5))) //[]
    }

    fun containsZero(list: List<Int>): Boolean {
        for (i in list) {
            if (i == 0) return true
        }
        return false
    }

    val list = listOf(0, 1, 2)
    val result = list.flatMap {
        if (it == 0) return@flatMap listOf<Int>()
        listOf(it, it)
    }
    val result1 =
        list.flatMap l@{
            if (it == 0) return@l listOf<Int>()
            listOf(it, it)
        }
   // println(result) // [1, 1, 2, 2]

}