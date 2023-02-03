package funcional.funextension

import java.lang.StringBuilder
import kotlin.math.pow
import kotlin.math.roundToInt

open class A(val a: Int) {
    fun foo() = println("A.foo()")
}

// Con herencia
class myA(a: Int) : A(a) {
    fun bar() = println("myA.bar()")
}

// Con extension
fun A.bar() = println("A.bar()")
fun String.middle() {
    this.substring((this.length / 2) - 1, (this.length / 2) + 1)
}

fun Int.isEven() = this % 2 == 0
fun Int.isOdd() =this % 2 != 0

fun Double.round(decimales: Int): Double {
    val factor = 10.0.pow(decimales)
    return((this * factor).roundToInt() / factor)
}

typealias ArrayInt = Array<Int>
fun Array<Int>.bubbleSort() {
    for (i in 0 until this.size - 1) {
        for (j in 0 until this.size - 1 - i) {
            if (this[j] > this[j + 1]) {
                val aux = this[j]
                this[j] = this[j + 1]
                this[j + 1] = aux
            }
        }
    }
}

typealias Matriz = Array<Array<Int>>

fun Matriz.print() {
    for (i in 0 until this.size) {
        for (j in 0 until this[i].size) {
            print("${this[i][j]} ")
        }
        println()
    }
}




fun main() {
    myA(1).foo()
    myA(1).bar()
    A(1).bar()

    val s = "Hola"
    println(s.middle())

    println(2.isEven())
    println(2.isOdd())

    val num = 3
    if (num.isOdd()) {
        println("Es impar")
    } else {
        println("Es par")
    }

    val pi = 3.1415926535897932384626433832795
    println(pi.round(2))
    println(pi.round(3))
    println(pi.round(4))

    val a = arrayOf(3, 2, 1)
    a.bubbleSort()
    println(a.contentToString())

    val matrix = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6),
        arrayOf(7, 8, 9)
    )

    matrix.print()

}
