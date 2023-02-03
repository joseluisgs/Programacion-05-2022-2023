package funcional.inline

// https://kotlinlang.org/docs/inline-functions.html

// La poner inline, quiere decir que "pego"
// el código de la función en el lugar donde
// se llama a la función

fun Array<Int>.sumar(): Int {
    var total = 0
    for (i in this) {
        total += i
    }
    return total
}

inline fun Array<Int>.forEach(action: (Int) -> Unit) {
    for (i in this) {
        action(i)
    }
}

inline fun Array<Int>.find(predicate: (Int) -> Boolean): Int? {
    for (i in this) {
        if (predicate(i)) {
            return i
        }
    }
    return null
}

fun Array<Int>.filter(predicate: (Int) -> Boolean): Array<Int> {
    val resultado = mutableListOf<Int>()
    for (i in this) {
        if (predicate(i)) {
            resultado.add(i)
        }
    }
    return resultado.toTypedArray()
}

fun Array<Int>.map(transform: (Int) -> Int): Array<Int> {
    val resultado = mutableListOf<Int>()
    for (i in this) {
        resultado.add(transform(i))
    }
    return resultado.toTypedArray()
}

data class Persona(val nombre: String, val edad: Int)
typealias PersonasArray = Array<Persona>


fun PersonasArray.map(transform: (Persona) -> Int): Array<Int> {
    val resultado = mutableListOf<Int>()
    for (i in this) {
        resultado.add(transform(i))
    }
    return resultado.toTypedArray()
}


fun main() {
    val numeros = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println(numeros.sumar())
    /*var total = 0
    for (i in numeros) {
        total += i
    }
    println(total)*/

    numeros.forEach { println(it) }
    /*for (i in numeros) {
        println(i)
    }*/




     println(numeros.find { it < 5 && it!=2} )
    println(numeros.filter { it % 2 == 0 })
    println(numeros.map { it * 2 })

    println(numeros
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .sumar()
    )

    val personas = arrayOf(
        Persona("Juan", 20),
        Persona("Pedro", 30),
        Persona("Maria", 40),
        Persona("Ana", 50),
    )

    println()

    personas.map { it.edad }
        .filter { it > 30 }
        .forEach { println(it) }

}