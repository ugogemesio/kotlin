package com.example.kotlin.module3

abstract class EFunctionalProgramming {

    // Lambdas
    data class Employee(
        val city: City,
        val age: Int
    )

    enum class City {
        PRAGUE,
        ROME
    }

    abstract val employees: List<Employee>

    fun averageAgeInPrague(): Double =
        employees
            .filter { it.city == City.PRAGUE }
            .map { it.age }
            .average()
    val result = ({x: Int, y: Int -> x + y})

    fun impl(){
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        employees.filter { it.age > 0 }

        //lambda syntax
        list.any({i:Int -> i > 0})
        list.any { i -> i > 0 }
        list.any{ it > 0 }
        //Multi-line lambda
        list.any{
            print("processing $it")
            it>0
        }
        //Destructuring declarations
        val map = mapOf(1 to "one", 2 to "two", 3 to "three")
        map.mapValues { entry -> "${entry.key}: ${entry.value}"}
        map.mapValues { (key, value) -> "$key: $value" }

        //argument that will not be used
        map.mapValues { (_, value) -> "$value" }



    }


}
