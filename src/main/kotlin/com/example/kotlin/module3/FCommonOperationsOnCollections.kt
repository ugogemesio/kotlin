package com.example.kotlin.module3

/**
 * COMMON OPERATIONS ON COLLECTIONS - TUTORIAL
 * =============================================
 * 
 * This class demonstrates the most commonly used operations for working with collections
 * (lists, sets, maps) in Kotlin. These functional operations make it easy to transform,
 * filter, and manipulate data without writing imperative loops.
 * 
 * KEY BENEFITS:
 * - Write more concise and readable code
 * - Compose operations in a functional style
 * - Reduce bugs by avoiding manual iteration
 * - Improve code maintainability with clear intent
 * 
 * MAIN CATEGORIES:
 * 1. Filtering operations (filter, find, first)
 * 2. Transformation operations (map, flatMap, flatten)
 * 3. Checking operations (any, all, none)
 * 4. Ordering and grouping (groupBy, associateBy, partition)
 * 5. Combining collections (zip, zipWithNext)
 */
abstract class FCommonOperationsOnCollections {
    
    // Data class representing an Employee with their city and age
    data class Employee(
        val city: City,
        val age: Int
    )

    // Enum representing different cities where employees can be located
    enum class City {
        PRAGUE,
        ROME
    }
    
    abstract val employees: List<EFunctionalProgramming.Employee>

    fun impl(){
        // =====================================================
        // SECTION 1: FILTERING OPERATIONS
        // =====================================================
        // These operations select elements that match a condition
        
        val list = listOf(1, 2, 3, 4, 5)
        
        // filter: keeps only elements that match the predicate
        // Result: [2, 4] (keeps only even numbers)
        // Use when: you need to remove unwanted items from a collection
        val pairValue = list.filter { it % 2 == 0 }
        
        // find: returns the FIRST element matching the predicate, or null
        // Result: 2 (the first even number)
        // Use when: you need at most one element and want null safety
        val find = list.find { it % 2 == 0 }
        
        // first: returns the FIRST element matching the predicate
        // Throws NoSuchElementException if nothing matches
        // Result: 2
        // Use when: you're certain an element will match
        val first = list.first { it % 2 == 0 }
        
        // firstOrNull: returns the first element matching the predicate, or null if none match
        // Result: 2
        // Use when: you want null safety without exception handling
        val firstOrNull = list.firstOrNull { it % 2 == 0 }
        
        // ========================================================
        // SECTION 2: TRANSFORMATION OPERATIONS
        // ========================================================
        // These operations convert each element into a new value
        
        // map: transforms each element using the provided lambda
        // Result: [1, 4, 9, 16, 25] (each number squared)
        // Use when: you need to convert each element into something else
        val map = list.map { it * it }
        
        // ========================================================
        // SECTION 3: CHECKING OPERATIONS
        // ========================================================
        // These operations return Boolean values about the collection
        
        // any: returns true if AT LEAST ONE element matches the predicate
        // Result: true (there are even numbers: 2 and 4)
        // Use when: you need to check if at least one item matches
        val any = list.any { it % 2 == 0 }
        
        // all: returns true if ALL elements match the predicate
        // Result: false (not all numbers are > 2; 1 and 2 are not)
        // Use when: you need to validate that all items satisfy a condition
        val all = list.all { it > 2 }
        
        // none: returns true if NO elements match the predicate
        // Result: true (there are no negative numbers)
        // Use when: you need to ensure no items have a certain property
        val none = list.none { it < 0 }
        
        // count: returns the number of elements matching the predicate
        // Result: 2 (there are exactly 2 even numbers: 2 and 4)
        // Use when: you need to count how many items match a condition
        val count = list.count { it % 2 == 0 }
        
        // =========================================================
        // SECTION 4: PARTITION - SPLITTING INTO TWO GROUPS
        // =========================================================
        
        // partition: splits the collection into two lists based on a predicate
        // Returns a Pair of (matching, notMatching)
        // Result: ([2, 4], [1, 3, 5])
        // Use when: you need to separate items into two distinct groups
        val partition = list.partition { it % 2 == 0 }
        
        // =========================================================
        // SECTION 5: GROUPING AND ASSOCIATION OPERATIONS
        // =========================================================
        // These operations organize elements based on a key
        
        // groupBy: groups elements by the result of the provided function
        // Creates a Map where each key has a list of all matching elements
        // Example result: {29 -> [Employee(..., age=29)], 31 -> [Employee(...), Employee(...)]}
        // Use when: you need to organize items by a common property and keep ALL matches
        val groupBy = employees.groupBy { it.age }
        
        // associateBy: creates a map using the provided function as the key
        // If multiple elements have the same key, the LAST one is kept
        // Example result: {29 -> Employee(..., age=29), 31 -> Employee(..., age=31)}
        // Note: We lose information if different employees have the same age!
        // Use when: you need a direct key-value mapping and duplicates aren't needed
        val associateBy = employees.associateBy { it.age }
        
        // associate: creates a map by transforming each element into a key-value pair
        // The key is computed by one function, the value by another
        // Result: {'a' -> 10, 'b' -> 20, 'c' -> 30, 'd' -> 40}
        // So for value 1: 'a' + 1 = 'a', 10 * 1 = 10
        // Use when: you need to transform collection elements into key-value pairs
        val associate = list.associate { 'a' + it to 10 * it }
        
        // =========================================================
        // SECTION 6: COMBINING COLLECTIONS
        // =========================================================
        
        val list2 = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g')
        
        // zip: combines two collections element-by-element into pairs
        // Stops when the shorter collection ends (extra elements are ignored)
        // Result: [(1, 'a'), (2, 'b'), (3, 'c'), (4, 'd'), (5, 'e')]
        // Note: list2 has 'f' and 'g' but they're ignored because list has only 5 elements
        // Use when: you need to pair up elements from two collections
        val zip = list.zip(list2)
        
        // zipWithNext: creates pairs of adjacent elements in the same collection
        // Result: [(1, 2), (2, 3), (3, 4), (4, 5)]
        // Use when: you need to compare or combine each element with the next one
        val zipWithNext = list.zipWithNext()
        
        // =========================================================
        // SECTION 7: FLATTENING OPERATIONS
        // =========================================================
        
        // flatten: converts a collection of collections into a single flat collection
        val flat = listOf(listOf('a','b','c'), listOf('d','e','f'), listOf('g','h'))
        
        // Result: ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
        // Use when: you have nested collections and want to merge them into one level
        val flatten = flat.flatten()
        
        // =========================================================
        // SECTION 8: FLATMAP - TRANSFORM AND FLATTEN
        // =========================================================
        
        // flatMap: transforms each element AND flattens the result in one operation
        // It's equivalent to map + flatten
        val flatMap1 = "abc"
        val flatMap2 = "def"
        
        // Explanation:
        // 1. listOf("abc", "def") creates a list with 2 strings
        // 2. flatMap { it.toList() } transforms each string into a list of characters
        //    - "abc".toList() -> ['a', 'b', 'c']
        //    - "def".toList() -> ['d', 'e', 'f']
        // 3. The results are automatically flattened into one collection
        // Result: ['a', 'b', 'c', 'd', 'e', 'f']
        // Use when: you need to transform elements into collections and combine them
        val flattened = listOf(flatMap1, flatMap2).flatMap { it.toList() }

        println(flattened) // [a, b, c, d, e, f]

    }


}