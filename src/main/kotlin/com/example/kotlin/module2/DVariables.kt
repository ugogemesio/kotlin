package com.example.kotlin.module2

//how to define variables in kotlin
//val vs var
//val = values
//var = variables
//values = read-only
class DVariables {

    val question =
        "life, the universe, " +
                "and everything"
    //val corresponds to final variable in Java
    //question = "a" //not possible

    //var question = 1 not possible
    fun printQuestion () {
        println("$question?")
    }

    val greeting: String = "hi"
    val num = 1
    val number: Int = 2
    val languages = mutableListOf("Java", "Kotlin")
    val list = listOf("Java", "Kotlin")


    fun addLanguage (languages: MutableList<String>, language: String) {
        this.languages.add(language)
    }
        //wrong
//    fun addLanguage (languages: List<String>, language: String) {
//        this.languages.add(language)
//    }

    fun implements(){
        //addLanguage(list, "Java") error you cannot add items to a list that is not muttable
        addLanguage(languages, "Kotlin")
    }
}