package funcional.infix

// Infix, permite definir funciones que pueden ser llamadas sin el punto

// https://kotlinlang.org/docs/functions.html#infix-notation

infix fun Int.sumar(valor: Int): Int {
    return this + valor
}

infix fun Int.restar(valor: Int): Int {
    return this - valor
}

infix fun String.select(column: String): String {
    return "SELECT $column"
}

infix fun String.from(table: String): String {
    return "$this FROM $table"
}

infix fun String.where(condition: String): String {
    return "$this WHERE $condition"
}



fun main() {
    println(10 sumar 20)
    println(20.sumar(10))

    println(10 restar 20)
    println(20.restar(10))

    println("" select "nombre" from "persona" where "edad > 18")
}