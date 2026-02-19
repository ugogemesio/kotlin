package com.example.kotlin.module3

/**
 * MEMBER REFERENCES TUTORIAL
 * ===========================
 * 
 * Member References (also called Method References) are a way to reference existing functions
 * or properties without invoking them immediately. They can be used in place of lambda expressions
 * in Kotlin and are denoted using the '::' operator.
 * 
 * SYNTAX:
 * - ClassName::memberName (for class members/methods)
 * - ::topLevelFunctionName (for top-level functions)
 * 
 * BENEFITS:
 * - More concise and readable than lambda expressions
 * - Better performance (no creation of anonymous objects)
 * - Clearer intent when referencing named functions
 */
class HMemberReferences {
    
    // Data class representing a Person with name and age properties
    class Person(val name: String, val age: Int)
    
    // Sample list of people to work with
    val people = listOf(
        Person("Alice", 29),
        Person("Bob", 31),
        Person("Carol", 31),
        Person("Dave", 32),
        Person("Eric", 33),
        Person("Fred", 34))
    
    // EXAMPLE 1: Using Lambda Expression
    // This uses a lambda to extract the age property from each Person and find the maximum
    // Lambda syntax: { it.age } - concise but requires understanding 'it' represents Person
    val person = people.maxBy { it.age }
    
    // EXAMPLE 2: Using Member Reference (PREFERRED APPROACH)
    // This does the same thing but using a member reference to Person::age
    // Member reference syntax: Person::age - more explicit and readable
    // The :: operator creates a reference to the 'age' property of the Person class
    // This is functionally equivalent to the lambda above but more maintainable
    val person1 = people.maxBy(Person::age)
    
    // ========================================
    // EXAMPLE 3: Top-Level Function Reference
    // ========================================
    
    // First, we define a lambda expression that checks if a number is even
    // This lambda is stored in a variable with type (Int) -> Boolean
    // Lambda syntax: { i:Int-> i % 2 == 0 } - the implementation is inline
    val isEven: (Int) -> Boolean =
        { i: Int -> i % 2 == 0 }
    
    // Now we create a member reference to the isEven function
    // Using the '::' operator to reference the function without calling it
    // ::isEven creates a function reference that can be passed around and called later
    // This reference has the same type: (Int) -> Boolean
    val predicate = ::isEven
    
    // The 'predicate' variable now holds a reference to the isEven function
    // You can call it like this: predicate(5) would return false
    // Or use it in higher-order functions: numbers.filter(predicate)

    // ================================================
    // EXAMPLE 4: Member Reference vs Lambda for Methods
    // ================================================
    
    // A function that sends an email to a Person
    // This demonstrates how member references can be used with class methods
    fun sendEmail(person: Person, message: String) {

    }
    
    // OPTION A: Using Lambda Expression
    // This creates a lambda that wraps the sendEmail function call
    // While functional, it's verbose and adds an unnecessary indirection layer
    val action = { person: Person, message: String ->
        sendEmail(person, message)
    }
    
    // OPTION B: Using Member Reference (MORE READABLE)
    // This creates a direct reference to the sendEmail function
    // ::sendEmail has the type (Person, String) -> Unit
    // This is cleaner and more direct than the lambda above
    val action2 = ::sendEmail

    // ========================================================
    // EXAMPLE 5: Passing Function References as Arguments
    // ========================================================
    
    // One of the most powerful uses of member references is passing them
    // to higher-order functions that expect a function parameter.
    // This makes the code more concise and readable.

    // A predicate function that checks if a number is even
    fun isEven1(i: Int): Boolean = i % 2 == 0

    // Sample list of integers to demonstrate filtering
    val list = listOf<Int>(1, 2, 3, 4, 5)
    
    // EXAMPLE 5a: Using member reference with list.any()
    // Instead of writing: list.any { i -> isEven1(i) }
    // We can pass the function reference directly: ::isEven1
    // This is more concise and the intent is clearer
    val listImpl = list.any(::isEven1)
    
    // EXAMPLE 5b: Using member reference with list.filter()
    // Similarly, we can pass ::isEven1 to filter()
    // This returns a new list containing only even numbers: [2, 4]
    val listImple = list.filter(::isEven1)


    // ================================================
    // EXAMPLE 6: Bound References
    // ================================================
    
    // A bound reference is a reference to a function that is "bound" to a specific instance.
    // Instead of ClassName::method (unbound), you use instance::method (bound).
    // An unbound reference requires you to pass the instance as a parameter.
    // A bound reference already includes the instance, so you don't need to pass it.
    
    class NewPerson(val name: String, val age: Int) {
        // Instance method that checks if the person is older than the specified ageLimit
        fun isOlder(ageLimit: Int) = age >= ageLimit
        
        // This method returns a bound reference to the isOlder method
        // The reference is bound to 'this' (the current NewPerson instance)
        // Type: (Int) -> Boolean (only requires the ageLimit parameter)
        fun getAgePredicate() = this::isOlder
    }
    
    // UNBOUND REFERENCE: ClassName::methodName
    // This requires both the instance (NewPerson) and the ageLimit (Int) as parameters
    // Type: (NewPerson, Int) -> Boolean
    // You must provide a NewPerson instance when calling it
    val agePredicate: (NewPerson, Int) -> Boolean = NewPerson::isOlder

    // Create an instance of NewPerson
    val alice = NewPerson("Alice", 29)
    
    // Function demonstrating the use of the unbound reference
    // Note: You must pass 'alice' as the first argument because it's an unbound reference
    fun impl() {
        // This calls agePredicate with alice and 2 as arguments
        // Since alice.age (29) >= 2, this returns true
        agePredicate(alice, 2) // true
    }

}