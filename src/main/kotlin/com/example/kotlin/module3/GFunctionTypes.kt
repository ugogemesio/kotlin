package com.example.kotlin.module3

class GFunctionTypes {

    // Function type inferred by Kotlin
    val sum = { x: Int, y: Int -> x + y }
    // Type of 'sum' is automatically inferred as (Int, Int) -> Int

    // Function type explicitly declared
    val sum2: (Int, Int) -> Int = { x, y -> x + y }
    // Explicit declaration can help readability and type safety

    val isEven = { i: Int -> i % 2 == 0 }
    // Kotlin infers the type as (Int) -> Boolean

    val isEven2: (Int) -> Boolean = { i: Int -> i % 2 == 0 }
    // Explicit type declaration, same type as isEven

    val isEven3 = { i: Int -> i % 2 == 0 }
    // Another inferred function, same as isEven

    val list = listOf(1, 2, 3, 4)

    fun a() {
        // Passing a function variable as argument
        list.any(isEven)
        // 'any' expects a predicate: (Int) -> Boolean
        // isEven matches that type

        list.filter(isEven)
        // 'filter' also expects a predicate: (Int) -> Boolean

        run { println("hey!") }
        // 'run' executes a lambda with no parameters and no return value
        // Its type is () -> Unit

        // Function variables can be nullable
  //      val f1: () -> Int? = null
        // This will not compile: you cannot assign null to a non-nullable function type

        val f2: () -> Int? = { null }
        // Correct: a lambda returning nullable Int

        val f3: (() -> Int)? = null
        // Correct: nullable function type, can hold null

    //    val f4: (() -> Int)? = { null }
        // Correct: nullable function type assigned a lambda
    }
}
