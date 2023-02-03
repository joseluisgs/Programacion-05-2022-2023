package funcional.clouseres

// Una clausura es una función que tiene acceso a las variables de su entorno
// incluso si estas no son pasadas como parámetros
// y puede definirse dentro de otra función
fun maximo(valor1: Int, valor2: Int): Int {

    fun maximoInterno(): Int {
        return if (valor1 > valor2) valor1 else valor2
    }
    return maximoInterno()
}

fun main(args: Array<String>) {
    println(maximo(10, 20))
}