package com.example.kotlin.module2

import java.awt.Color
import java.awt.Color.BLUE
import java.awt.Color.ORANGE
import java.awt.Color.RED

class FromJavaToKotlin {
    //data generates equals, hashCode, toString
    data class Person(val name: String, val age: Int)

    //instatiate in kotlin
    val person = Person("Ugo", 30)

    fun printAge() {
        print(person.age)
    }

    fun updateWeatherJavaLike(degrees: Int) {
        val description: String
        val color: Color
        if (degrees < 10) {
            description = "cold"
            color = BLUE
        } else if (degrees < 25) {
            description = "mild"
            color = ORANGE
        } else {
            description = "hot"
            color = RED
        }
    }

    fun updateWeatherKotlinPair(degrees: Int) {
        val (description, color) =
            if (degrees < 10) {
                Pair("cold", BLUE)
            }else if (degrees < 25) {
                Pair("mild", ORANGE)
            }else{
                Pair("hot", RED)
            }
    }

    fun updateWeatherKotlinWhen(degrees: Int) {
        val (description, color) = when {
            degrees < 10 -> "cold" to BLUE
            degrees < 25 -> "mild" to ORANGE
            else -> "hot" to RED
        }
    }
    fun updateWeatherKotlinWhenPair(degrees: Int) {
        val (description, color) = when {
            degrees < 10 -> Pair("cold", BLUE)
            degrees < 25 -> Pair("mild", ORANGE)
            else -> Pair("hot", RED)
        }
    }
}