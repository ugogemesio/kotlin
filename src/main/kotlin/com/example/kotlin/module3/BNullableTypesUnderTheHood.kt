package com.example.kotlin.module3

import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

class BNullableTypesUnderTheHood {
    //@Nullable, @NotNull
    //
    //Nullable types!=Optional
    class Optional<T>(var value: T){
        fun isPresent() = value != null
        fun get() = value?:
        throw NoSuchElementException("No value present")
    }
    //How many objects are created to store the value of a nullable String?

    //A)
    //Two objects: one object to store a String value,
    // another (a wrapper) to store a nullable String

    //B) That one
    //Only one object to store a String value


    //the thing
    fun foo(): String = "foo"
    fun bar(): String? = "bar"

    //the implementation
    //@NotNull
//    public static final String foo(){
//        return "foo";
//    }

    //@Nullable
//    public static final String bar(){
//        return "bar";
//    }

    //List of Nullable elements vs nullable list

    val a: List<Int?> = listOf(null, 1, null, 2)
    val b: List<Int>? = null

    fun foo(list1: List<Int?>, list2: List<Int>?) {
        list1.size
        //list2.size
        val i: Int
          //  list1.get(0)
        //val j: Int =
          //  list2.get(0)
    }
    fun String?.isEmptyOrNull(): Boolean {
        return this == null || this.isEmpty()
    }

    fun impl(args: Array<String>) {
        val s1: String? = null
        val s2: String? = ""
        check(s1.isEmptyOrNull() == true)
        check(s2.isEmptyOrNull() == true)
        val s3 = "   "
        check(s3.isEmptyOrNull() == false)
    }


}