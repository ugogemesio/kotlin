package com.example.kotlin

import com.example.kotlin.module2.DVariables
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class KotlinApplication

fun main(args: Array<String>) {
    runApplication<KotlinApplication>(*args)

    val variables = DVariables()
    variables.printQuestion()
}