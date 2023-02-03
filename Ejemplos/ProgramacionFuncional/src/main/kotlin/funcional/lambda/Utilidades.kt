package funcional.lambda

fun myRepeat(times: Int, action: (Int) -> Unit) {
    for (i in 0 until times) {
        action(i)
    }
}

fun forEach(list: Array<Int>, action: (Int) -> Unit) {
    for (i in list) {
        action(i)
    }
}

fun filter(list: Array<Int>, predicate: (Int) -> Boolean): Array<Int> {
    val result = arrayListOf<Int>()
    for (i in list) {
        if (predicate(i)) {
            result.add(i)
        }
    }
    return result.toTypedArray()
}

fun myRequire(predicate: Boolean, messageFun: () -> String) {
    if (!predicate) {
        throw IllegalArgumentException(messageFun())
    }
}


fun main() {
    myRepeat(10) { i ->
        println("Hola $i")
    }

    var list = arrayOf(1, 2, 3, 4, 5)
    forEach(list) { it ->
        println("Valor $it")
    }

    list = arrayOf(1, 2, 3, 4, 5)
    forEach(list) {
        val result = it * 2
        println("Valor $result")
    }

    var result = filter(list) { i ->
        i % 2 == 0
    }
    println(result.contentToString())

    result = filter(list) { i ->
        i % 2 != 0
    }
    println(result.contentToString())

    result = filter(list) { i ->
        i > 3
    }
    println(result.contentToString())

    myRequire (list.size > 99) { "El tamaño del array debe ser mayor que 99" }
}