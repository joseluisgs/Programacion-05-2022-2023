package funcional.lambda

// función nombrada

fun calculo(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}
fun calculo(a: Double, b: Double, operacion: (Double, Double) -> Double) {
    operacion(a, b)
}

fun main(args: Array<String>) {
    // Suma
    calculo(1, 2) { a, b -> a + b }
    // Resta
    calculo(1, 2) { a, b -> a - b }
    // Multiplicación
    calculo(1, 2) { a, b -> a * b }
    // División
    calculo(1, 2) { a, b -> a / b }

    // Suma
    calculo(1.0, 2.0) { a, b -> a + b }
}