package funcional.receiver

import java.time.LocalDate


/*
Lambda con Rceiver es una mezcla de Lambda Funciones de extensión
Las lambdas con receptores son básicamente iguales a las funciones de extensión,
solo se pueden almacenar en propiedades y pasar a las funciones.
https://kotlinlang.org/docs/lambdas.html#function-literals-with-receiver
MyX.()->Unit  == (MyX)->Unit
Dentro del cuerpo de la función literal, el objeto receptor pasado a la llamada
se convierte en un implícito this.
De esta manera conseguimos que en el cuerpo de la lambda
podamos acceder a las propiedades y métodos del objeto receptor.
Nos sirve para extender funciones de una clase y aplicar una funcion a cada una de las funciones de la clase
con ello podemos hacer safebuilders o DSL
https://www.baeldung.com/kotlin/lambda-receiver
*/

// Función normal
fun suma(numero1: Int, numero2: Int): Int {
    return numero1 + numero2
}

// Función anónima en una variable
val sumaFunAnonima: (Int, Int) -> Int = { numero1, numero2 -> numero1 + numero2 }

val sumaLambda = { numero1: Int, numero2: Int -> numero1 + numero2 }

// Función de extensión
fun Int.sumaExt(numero: Int): Int {
    return this + numero
}

// Funciones de extensión con receptor
val sumaExtenReciever: Int.(Int) -> Int = { numero -> this + numero }


fun StringBuilder.builder(block: () -> String): String {
    // Nos nos sirve para todo
    this.append(block())
    return this.toString()
}

// Operaciones con lambda con receiver y extensión
// Una función para crear cadenas de texto de forma segura
// que recibe un bloque de código que se ejecuta sobre un StringBuilder
fun StringSafeBuilder(block: StringBuilder.() -> Unit): String {
    // Creamos un StringBuilder
    val stringBuilder = StringBuilder()
    // Ejecutamos el bloque de código sobre el StringBuilder
    // Podemos porque es cualquier método de extensión o de Builder
    // porque así lo hemos definido
    stringBuilder.block()
    // Devolvemos el resultado
    return stringBuilder.toString()
}

fun String.builder(block: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder(this)
    stringBuilder.block()
    return stringBuilder.toString()
}

class Persona {
    var nombre: String = ""
    var apellido: String = ""
    var edad: Int = 0

    override fun toString(): String {
        return "Persona(nombre='$nombre', apellido='$apellido', edad=$edad)"
    }
}

class PersonaException(mensaje: String) : Exception(mensaje)
fun safeBuilderPersona(block: Persona.() -> Unit): Persona {
    val persona = Persona()
    persona.block()
    check(persona.nombre.isNotBlank()) {throw PersonaException("El nombre no puede estar vacío") }
    check(persona.apellido.isNotBlank()) { "El apellido no puede estar vacío" }
    check(persona.edad > 0) { "La edad debe ser mayor que 0"}
    return persona
}




fun main() {
    val numero = 10
    val numero2 = 20

    println(suma(numero, numero2))

    println(sumaFunAnonima(numero, numero2))

    println(sumaLambda(numero, numero2))

    println(numero.sumaExt(numero2))

    println(sumaExtenReciever(numero, numero2))
    println(numero.sumaExtenReciever(numero2))

    println(StringBuilder().builder {
        "Hola Mundo" + "Hola a todos" + "Hola que tal"
    })

    println(StringSafeBuilder {
        append("Hola")
        append(" ")
        append("Mundo")
    })



    println("Hola".builder {
        append(" ")
        append("Mundo")
    })

    println("Hola".builder {
        append(" ")
        append("Mundo")
    })

    println(String().builder {
        append("Hola")
        append(" ")
        append("Mundo")
    })

    println(safeBuilderPersona {
        nombre = "Pepe"
        apellido = "Perez"
        edad = 20
    })

    val persona = safeBuilderPersona {
        nombre = arrayOf("Pepe", "Juan", "Maria").random()
        apellido = arrayOf("Perez", "Garcia", "Lopez").random()
        edad = (1..100).random()
    }

    println(persona)

    val persona2 = safeBuilderPersona {
        nombre = "Pepe"
        apellido = "Perez"
        edad = LocalDate.now().year - 1990
    }

    println(persona2)


    val persona3 = safeBuilderPersona {
        nombre = ""
        apellido = "Perez"
        edad = -1
    }

}