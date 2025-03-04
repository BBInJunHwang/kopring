package com.example.mykopring.study

class KotlinBasic {
    val name: String = "Kotlin" // val == final 변경 불가능 (Immutable)
    var age: Int = 1 // var == 변경 가능 (Mutable)

    var name2: String? = null // null 허용

    // 함수 선언
    fun greet(): String {
        println("Hello, $name!")
        return "Hello, $name!"
    }

    // greet() 함수를 한줄함수로 변경
    fun greet2(name: String) = "Hello, $name!"

    // greet2() 함수에 default parameter 추가
    fun greet3(name: String = "default param") = "Hello, $name!"

}