package com.example.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.awt.Color
import java.awt.Color.BLUE
import java.awt.Color.ORANGE
import java.awt.Color.RED

@SpringBootApplication
class KotlinApplication

fun main(args: Array<String>) {
	runApplication<KotlinApplication>(*args)
    ugo(1)
    ugo(11)
    ugo(30)
}
fun ugo(degrees: Int){
    val description: String
    val color: Color
    if (degrees <10){
        description = "cold"
        color = BLUE
    }else if (degrees < 25){
        description = "mild"
        color = ORANGE
    }else{
        description = "hot"
        color = RED
    }
    println(description)
    println(color)
}

fun updateWeather(degrees: Int){
    val(description: String, color: Color) =
        if(degrees <10) {
            Pair("cold", BLUE)

        }else if (degrees < 25){
            Pair("mild", ORANGE)
        }else{
            Pair("hot", RED)
        }
}