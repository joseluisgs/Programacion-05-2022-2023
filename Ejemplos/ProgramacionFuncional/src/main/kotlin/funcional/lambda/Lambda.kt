package funcional.lambda

// función nombrada
fun funSuma(a: Int, b: Int): Int {
    return a + b
}

// función anónima
val sumaAnonima = fun(a: Int, b: Int): Int {
    return a + b
}

// función lambda
val sumaLambda = { a: Int, b: Int -> a + b }

fun operacionFunParam(a: Int, b: Int, accion: (Int, Int) -> Int): Int {
    return accion(a, b)
}

fun operacionFunRetorno(a: Int, b: Int, accion: (Int, Int) -> Int): (Int, Int) -> Int {
    return accion
}



fun main(args: Array<String>) {
    funSuma(1, 2) // 3
    sumaAnonima(1, 2) // 3
    sumaLambda(1, 2) // 3

    operacionFunParam(1, 2, sumaAnonima)
    operacionFunParam(1, 2, sumaLambda)
    operacionFunParam(1, 2, { a, b -> a + b })
    operacionFunParam(1, 2, { a, b -> a - b })
    operacionFunParam(1, 2, { a, b -> a * b })
    operacionFunParam(1, 2, { a, b -> a / b })
    operacionFunParam(1, 2, { a, b -> a % b })
    operacionFunRetorno(1, 2, { a, b -> a + b })

    // A la hora de llamar, si el lambda es el último parámetro, se puede poner fuera de los paréntesis
    operacionFunParam(1, 2) { a, b -> a + b }
    operacionFunParam(1, 2) { a, b -> a - b }
    operacionFunParam(1, 2) { a, b -> a * b }
    operacionFunParam(1, 2) { a, b -> a / b }
    operacionFunParam(1, 2) { a, b -> a % b }
    operacionFunRetorno(1, 2) { a, b -> a + b}

}