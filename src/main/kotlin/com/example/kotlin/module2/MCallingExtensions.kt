package com.example.kotlin.module2

class MCallingExtensions {
    open class Parent{

    }
    //Child extends Parent
    class Child : Parent()
    fun Child.foo() = "Child"
    fun Parent.foo() = "Parent"
    fun impl(){
        val parent: Parent = Child()
        print(parent.foo())//Parent
    }

    fun String.get(index:Int) = '*'

    fun imp(){
        print("abc".get(2))//c
    }
    //Extensions can overload members

    class A{
        fun foo() = "member"
    }
    fun A.foo(i: Int) = "extension($i)"

    fun implw(){
        A().foo()
        A().foo(1)
    }
}