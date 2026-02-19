package com.example.kotlin.module3

class IReturnLambda {

    // This function tries to duplicate all non-zero elements in the list.
    // Note: The `return` inside the lambda is tricky—it will attempt to return from the
    // enclosing function `duplicateNonZero`, not just the lambda.
    fun duplicateNonZero(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0) return listOf() // ⚠️ This returns from the outer function, not just the lambda!
            listOf(it, it)
        }
    }

    fun imple() {
        println(duplicateNonZero(listOf(3, 0, 5))) // Will print [] because of the previous return behavior
    }

    // Standard return from a normal function
    // When you use `return` here, it returns from the function itself, not a lambda.
    fun containsZero(list: List<Int>): Boolean {
        for (i in list) {
            if (i == 0) return true
        }
        return false
    }

    // ✅ Correct way to return from a lambda is using a label
    val list = listOf(0, 1, 2)
    val result = list.flatMap {
        if (it == 0) return@flatMap listOf<Int>() // `return@flatMap` returns only from the lambda, not the outer function
        listOf(it, it)
    }

    // You can also name the lambda with a label
    val result1 =
        list.flatMap ls@{ // label `ls` for this lambda
            if (it == 0) return@ls listOf<Int>() // returns only from this lambda
            listOf(it, it)
        }

    // Using the label solution inside a function
    fun duplicateNonZero1(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0) return@flatMap listOf<Int>() // safe return only from lambda
            listOf(it, it)
        }
    }

    // Using a local function: avoids `return` confusion
    // Here, `duplicateNonZeroElement` is a normal function, so `return` behaves normally.
    fun duplicateNonZeroLocalFunction(list: List<Int>): List<Int> {
        fun duplicateNonZeroElement(e: Int): List<Int> {
            if (e == 0) return listOf()
            return listOf(e, e)
        }
        return list.flatMap(::duplicateNonZeroElement) // pass the function reference
    }

    // Using anonymous functions: `return` inside an anonymous function
    // behaves like a normal function, so it does not affect the outer function.
    fun duplicateNonZero2(list: List<Int>): List<Int> {
        return list.flatMap(fun(e): List<Int> {
            if (e == 0) return listOf()
            return listOf(e, e)
        })
    }

    // Another simple solution: no `return` keyword needed
    fun duplicateNonZero3(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0)
                listOf() // the last expression is returned implicitly
            else
                listOf(it, it)
        }
    }

    // 💡 Key Takeaways:
    // 1. `return` inside a lambda by default tries to return from the enclosing function (non-local return).
    // 2. Use `return@lambdaLabel` to return from a lambda only.
    // 3. Anonymous functions treat `return` like a normal function return, so they are safe for inline returns.
    // 4. Using local functions or avoiding `return` inside lambdas also helps simplify logic.
}
