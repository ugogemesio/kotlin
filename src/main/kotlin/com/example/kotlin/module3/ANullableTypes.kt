package com.example.kotlin.module3

import com.example.kotlin.module2.foo

class ANullableTypes {
    //Problem of nullability
    //Nobody knows where to search;
    //Modern approach
    //compile-time error not
    //run-time
    val s1: String = "always not null"

    val s2: String? = null
    val s13: String? = "always not null"
    fun s() {
        //s13.length wrong
        s1.length
    }
    //val s3: String = null X error

    //Safe access
    class Foo {
        fun bar(): String? {
            return null
        }
    }

    fun implementsFoo() {
        val foo: Foo? = null
        val a = foo?.bar() // a will be null
    }

    //Nullability operators


    fun nullabilityAvoided() {
        val s: String? = null
        val length: Int? = if (s != null) s.length else null
        val length2: Int? = s?.length ?: 0
    }

    //Elvis Operator
    //foo?:bar
    //foo != null -> foo
    //foo == null -> bar

    //Control-flow analysis

    val s5: String? = null

    fun controlFlow(){
        if(s5 == null) return
        s5?.length
    }
    fun fail() {
        throw IllegalStateException()
    }

    //Making NPE explicit
    fun makingNPEExplicit(){
        val s: String? = null
        s!!
    }

    //Using not-null assertion

    class MyAction{
        val list = listOf(1, 2, 3)

        fun isEnabled(): Boolean =
            list.get(2) != null

        fun actionPerformed(){
            val value = list.get(0)!!
        }
    }
    //BAD EXAMPLE OF USING NOT-NULL ASSERTION

    //person.company!!.address!!.country

    class Name{
        val value: String? = null
    }

    //which line(s) won't compile?
    fun isFoo1(n:Name) = n.value == "foo" //null cannot be a value
    //fun isFoo2(n:Name?) = n.value == "foo" //compiler error: only safe(?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of a type Name?
    fun isFoo3(n:Name?) = n != null && n.value == "foo"
    fun isFoo4(n:Name?) = n?.value == "foo"

    fun isFoo5(){
        //isFoo1(null) // null cannot be a value
      //  isFoo2(null)
        isFoo3(null)
        isFoo4(null)
    }
    //Puzzler. What will be printed?
    fun puzzler(){
        val x: Int? = 1
        val y: Int = 2
        val sum = x?:0 + y
        println(sum)//1
    }
    //Operator precedence
    class Operator{
        val x: Int? = 1
        val y: Int = 2
        val s1 = x ?:  0 + y    //1
        val s2 = x ?: (0 + y)   //1
        val s3 = (x ?: 0) + y   //3
    }




}