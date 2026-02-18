package com.example.kotlin.module3

abstract class FCommonOperationsOnCollections {
    data class Employee(
        val city: City,
        val age: Int
    )

    enum class City {
        PRAGUE,
        ROME
    }
    abstract val employees: List<EFunctionalProgramming.Employee>

    fun impl(){
        //filter:
        val list = listOf(1, 2, 3, 4, 5)
        val pairValue = list.filter{it % 2 == 0}  //(2,4)
        //map: transforms
        val map = list.map{ it * it}// (1,4,9,16,25)
        //any(all, none)
        val any = list.any { it % 2 ==0  } //true
        val all = list.all { it > 2} //true
        val none = list.none { it < 0 } //true
        val find = list.find { it % 2 == 0 } //2
        val first = list.first { it % 2 == 0 } //2
        val firstOrNull = list.firstOrNull { it % 2 == 0 } //2
        val count = list.count() { it %2 ==0 } //2
        val partition = list.partition { it % 2 == 0 } // (2,4),(1,3)
        val groupBy = employees.groupBy { it.age } // 29->(Bob,29),31->((Alice,31), (Carol, 31))


        println(pairValue)
        println(map)
        println(any)
        println(all)
        println(none)

    }



}