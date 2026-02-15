package com.example.kotlin.module2

import java.awt.Color.*


class GConditionals {
    fun impl(){
        val a = 1
        val b = 2
        val max = if (a > b) a else b
        //no ternary operator
    }
    enum class Color{
        RED,  BLUE, ORANGE, YELLOW, GREEN
    }
    //when as a switch
    fun getDescription(color: Color): String =
        when (color) {
            Color.BLUE -> "cold"
            Color.ORANGE -> "mild"
            Color.RED -> "hot"
            else -> "other"
        }
    fun getDescriptionDifferent(color: Color): String =
        when (color) {
            Color.BLUE -> "cold"
            Color.ORANGE -> "mild"
            Color.RED -> "hot"
            Color.YELLOW -> "other"
            Color.GREEN -> "another"
        }

    fun respondToInput(input: String) = when(input) {
        "y","yes" -> "I'm glad to learn"
        "n", "no" -> "Sorry. That sucks"
        else -> "Whatever"
    }
    fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            else -> throw Exception("Dirty color")

    }

    //Checking Types
    open class Pet {
        open fun woof(): String{
            return "a"
        }

    }
    class Dog: Pet(){
        override fun woof(): String{
            return "woof"
        }
    }
    class Cat: Pet(){
        fun meow(): String{
            return "meow"
        }
    }
    fun checkingTypes(pet:Pet){
        when(pet){
            is Dog -> pet.woof()
            is Cat -> pet.meow()
        }
    }
    //Capturing when subject in a variable
    fun whenSubInAVar(){
        val dog = Dog()
        val pet = getMyFavouritePet()
        when(pet){
            is Dog -> pet.woof()
            is Cat -> pet.meow()
        }
    }
    val pet = Dog()
    fun setMyFavouritePet(pet:Pet){}
    fun implSet(){
        setMyFavouritePet(pet)
    }
    fun getMyFavouritePet():Pet{
        return this.pet
    }

//    fun getMyFavouritePet(): Pet {
//        when(pet){
//            is Dog -> return pet
//            is Cat -> return pet
//            is Pet -> return pet
//        }
//    }
    fun implAnotherTopic(){
        when(val pet = getMyFavouritePet()){
            is Dog -> println(pet.woof())
            is Cat -> println(pet.meow())
        }
    }
    fun getSound(): String =
        when(val pet = getMyFavouritePet()){
            is Dog -> pet.woof()
            is Cat -> pet.meow()
            else -> "---"
        }


}