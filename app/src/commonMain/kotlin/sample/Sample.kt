package sample

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun hello(): String = "Hello from ${Platform.name}"

class Common {
    fun getHelloMessage() = hello()
}

fun main() {
    println(hello())
}