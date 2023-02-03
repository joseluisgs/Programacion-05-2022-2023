# Programación - 05 Programación Funcional

Tema 04 Programación Funcional. 1DAM. Curso 2022/2023.

![imagen](https://raw.githubusercontent.com/joseluisgs/Programacion-00-2022-2023/master/images/programacion.png)

- [Programación - 05 Programación Funcional](#programación---05-programación-funcional)
  - [Contenidos](#contenidos)
  - [Programación Funcional](#programación-funcional)
    - [Closure](#closure)
    - [Funciones anónimas](#funciones-anónimas)
    - [Funciones lambda](#funciones-lambda)
    - [Funciones de orden superior](#funciones-de-orden-superior)
  - [Funciones de extensión](#funciones-de-extensión)
  - [Sobrecarga de operadores](#sobrecarga-de-operadores)
  - [Funciones inline](#funciones-inline)
  - [Funciones refied](#funciones-refied)
  - [Funciones infix o infijas](#funciones-infix-o-infijas)
  - [Funciones con receiver](#funciones-con-receiver)
  - [Scope functions](#scope-functions)
    - [let](#let)
    - [run](#run)
    - [with](#with)
    - [apply](#apply)
    - [also](#also)
  - [Recursos](#recursos)
  - [Autor](#autor)
    - [Contacto](#contacto)
    - [¿Un café?](#un-café)
  - [Licencia de uso](#licencia-de-uso)

## Contenidos
1. Programación Funcional
2. Funciones de extensión
3. Sobrecarga de operadores
4. Funciones inline
5. Funciones refied
6. Funciones infix o infijas
7. Funciones con receiver
8. Scope functions

## Programación Funcional
La programación funcional es un paradigma de programación que trata de la evaluación de funciones matemáticas y evitar el uso de estados y datos mutables. En este paradigma, las funciones son tratadas como valores de primera clase, lo que significa que las funciones pueden ser pasadas como argumentos a otras funciones, pueden ser devueltas por otras funciones y pueden ser asignadas a variables o elementos de datos.

```kotlin
// Función como definición
fun suma(a: Int, b: Int): Int {
    return a + b
}
// Función como expresión
fun suma(a: Int, b: Int): Int = a + b
// Función anónima
val suma = fun(a: Int, b: Int): Int = a + b
// Función lambda
val suma = { a: Int, b: Int -> a + b }
```
### Closure
La función closure es una función que recuerda el entorno en el que se ha creado y con ello podemos definir una función dentro de otra función, y que esta nueva función pueda acceder a las variables de la función que la contiene.

```kotlin
fun suma(a: Int, b: Int): Int {
    
    fun sumar(): Int {
        return a + b
    }

    return sumar()
}

fun main() {
    val resultado = suma(2, 3)
    println(resultado)
}
```

### Funciones anónimas
Las funciones anónimas son funciones que no tienen nombre. En Kotlin, las funciones anónimas se definen con la palabra clave fun seguida de un conjunto de parámetros entre paréntesis, un operador de flecha (->) y un cuerpo de función. Las funciones anónimas se pueden asignar a variables o pasar como argumentos a otras funciones.

```kotlin
// Función anónima
val suma = fun(a: Int, b: Int): Int = a + b

// Uso de la función anónima
fun main() {
    val resultado = suma(2, 3)
    println(resultado)
}
```

### Funciones lambda
Las funciones lambda son funciones anónimas que se pueden pasar como argumentos a otras funciones y definimos su comportamiento cuando lo necesitemos. En Kotlin, las funciones lambda se definen entre llaves y se pueden asignar a variables o pasar como argumentos a otras funciones.

```kotlin
// Función lambda
val suma = { a: Int, b: Int -> a + b }

// Uso de la función lambda
fun main() {
    val resultado = suma(2, 3)
    println(resultado)
}
```

### Funciones de orden superior
Las funciones de orden superior son funciones que toman otras funciones como argumentos o devuelven funciones como resultado. En Kotlin, generalmente se usan lambda para pasar funciones como argumentos indicando el comportamiento que queremos que tengan.

Debemos tener en cuenta que si la función pasada por parámetro es la última, podemos colocarla fuera de los paréntesis.

El parámetro de la función lambda se puede omitir si solo se usa una vez en el cuerpo de la función lambda. Usaremos el nombre it para referirnos a ese parámetro si es necesario.

```kotlin
// Función de orden superior, operación es una función que acepta dos enteros y devuelve un entero
fun operar(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}

// myRepeat es una función que acepta un entero y una función que acepta un entero y no devuelve nada
fun myRepeat(times: Int, op: (Int) -> Unit) {
    for (i in 0 until times) {
        op(i)
    }
}

fun myForEach(list: List<Int>, op: (Int) -> Unit) {
    for (i in list) {
        op(i)
    }
}

// Uso de la función de orden superior, como el parametro que pasamos como lambda es la última podemos colocarlo fuera de los paréntesis
fun main() {
    val resultado = operar(2, 3) { a, b -> a + b }
    println(resultado)

    myRepeat(5) { println("Hola $it") }

    myForEach(listOf(1, 2, 3, 4, 5)) { println(it) }
}
```

## Funciones de extensión
Las funciones de extensión son funciones que se pueden añadir a una clase/tipo sin heredar de ella. En Kotlin, las funciones de extensión se definen con la palabra clave fun seguida del nombre de la clase a la que se añaden, un punto y el nombre de la función.

```kotlin
// Función de extensión
fun String.repetir(times: Int): String {
    var result = ""
    for (i in 0 until times) {
        result += this
    }
    return result
}

fun Int.sumar(a: Int): Int {
    return this + a
}

// Uso de la función de extensión
fun main() {
    val resultado = "Hola ".repetir(3)
    println(resultado)

    val resultado2 = 2.sumar(3)
    println(resultado2)
}
```
## Sobrecarga de operadores
La sobrecarga de operadores es la posibilidad de definir el comportamiento de los operadores para nuestros propios tipos. En Kotlin, la sobrecarga de operadores se define con la palabra clave operator seguida del nombre del operador y el cuerpo de la función y [redefiniendo la función asociada](https://kotlinlang.org/docs/operator-overloading.html).

```kotlin
// Sobrecarga de operadores
operator fun String.times(times: Int): String {
    var result = ""
    for (i in 0 until times) {
        result += this
    }
    return result
}

operator fun Int.plus(a: Int): Int {
    return this + a
}

// Uso de la sobrecarga de operadores
fun main() {
    val resultado = "Hola " * 3
    println(resultado)

    val resultado2 = 2 + 3
    println(resultado2)
}
```

## Funciones inline
Las funciones de orden superior tienen ciertas penalizaciones de tiempo de ejecución:
cada función es un objeto y captura un cierre.
Un cierre es un ámbito de variables a las que se puede acceder en el cuerpo de la función.
Las asignaciones de memoria (tanto para objetos de función como para clases) y
las llamadas virtuales introducen una sobrecarga de tiempo de ejecución.
- Con [inline](https://kotlinlang.org/docs/inline-functions.html), pegamos el cuerpo de la lambda en el lugar donde se llama a la función. Crece el código, pero ahorramos memoria y tiempo de ejecución. Hay que buscar el equilibrio entre el tamaño del código y el tiempo de ejecución. No siempre interesa.
- noinline: para que no se haga inline una función lambda o función de orden superior eligiendo la que queremos que no se haga inline o no.
- crossinline: para que no se haga inline una función lambda aunque se llame desde una inline. Con ello evitamos que se puedan hacer retunes, pues recuerda que el inline pega el código. [Revisa este enlace para más información](https://www.baeldung.com/kotlin/crossinline-vs-noinline).

```kotlin
// Función inline
inline fun myRepeat(times: Int, op: (Int) -> Unit) {
    for (i in 0 until times) {
        op(i)
    }
}

// Uso de la función inline, pegamos el cuerpo de la lambda en el lugar donde se llama a la función a nivel de código intermedio (bytecode)
fun main() {
    myRepeat(5) { println("Hola $it") }
}
```

## Funciones refied
Las funciones refied son funciones que permiten acceder a la información de tipo en tiempo de ejecución. En Kotlin, las funciones refied se definen con la palabra clave reified seguida del nombre de la función y el cuerpo de la función.

Kotlin y Java borran la información de tipo genérico en el momento de la compilación o sea todos los posibles formas de genéricos se manfiestan como raw raw en tiempo de ejecución. Es decir List<Int> y  List<String> son solo List en tiempo de ejecución. Con refied podemos acceder a la información de tipo genérico en tiempo de ejecución

```kotlin
// Función refied
inline fun <reified T> isA(value: Any) = value is T

// Uso de la función refied
fun main() {
    println(isA<String>("Hola"))
    println(isA<String>(123))
}
```

## Funciones infix o infijas
Las funciones infix son funciones que permiten llamar a una función como si fuera un operador. En Kotlin, las funciones infix se definen con la palabra clave infix seguida del nombre de la función y el cuerpo de la función.

```kotlin
// Función infix
infix fun String.repetir(times: Int): String {
    var result = ""
    for (i in 0 until times) {
        result += this
    }
    return result
}

infix fun Int.pow(n: Int): Int {
    return this.toDouble().pow(n).toInt()
}

// Uso de la función infix
fun main() {
    val resultado = "Hola " repetir 3
    println(resultado)

    val resultado2 = 2 pow 3
}
```

## Funciones con receiver
Lambda con Receiver es una mezcla de Lambda Funciones de extensión. Las[ lambdas con receptores](https://kotlinlang.org/docs/lambdas.html#function-literals-with-receiver) son básicamente iguales a las funciones de extensión, solo se pueden almacenar en propiedades y pasar a las funciones. Dentro del cuerpo de la función literal, el objeto receptor pasado a la llamada se convierte en un implícito this y con ello ejecutar cualquier propiedad o método disponible.
De esta [manera](https://www.baeldung.com/kotlin/lambda-receiver) conseguimos que en el cuerpo de la lambda podamos acceder a las propiedades y métodos del objeto receptor.
Nos sirve para extender funciones de una clase y aplicar una función a cada una de las funciones de la clase
con ello podemos hacer safebuilders o DSL

```kotlin
// Aquí esta claro que extendemos  con una función de extensión y con una función de receptor
fun Int.sumExtension(other: Int): Int = this + other
// 3.sumExtension(4) --> 7 pero yo no puedo hacer sumExtension(3,4), pierdo esa opción

// Pero vamos a hacerlo de esta manera. De esta manera usamos el lambda con el receptor
// tenemos implicito el this
val sum: Int.(Int) -> Int = { a -> this + a } // this es el Int que recibe la función


// Aqui extendemos con opp que a su vez como parámetro usa en vez de una función o lambda una función de extensión
fun Int.opp(f: Int.() -> Int): Int = f()

// safebuilders o DSL
// accedemos a la función append de la clase StringBuilder al ser el receptor
fun buildString(actions: StringBuilder.() -> Unit): String {
    val builder = StringBuilder()
    // Aquí usamos la función de extensión append de la clase StringBuilder y ejecutamos
    // el bloque de código que nos pasan como parámetro
    builder.actions()
    return builder.toString()
}


fun main() {
    // Uso de la función de extensión
    println(3.sumExtension(4)) // 7

    // Uso de la función de receptor
    println(sum(3, 4)) // 7
    println(3.sum(4)) // 7

    // Uso de la función de extensión con la función de receptor
    println(3.opp { this + 4 })

    // safebuilders o DSL
    val result = buildString {
        append("Hola")
        append(" ")
        append("Mundo")
    }.toUpperCase()
    println(result) // HOLA MUNDO
}
```

## Scope functions
Las [funciones de alcance](https://kotlinlang.org/docs/scope-functions.html) son funciones que se pueden llamar en un objeto y que proporcionan un contexto adicional. Las usaremos dependiendo de la situación. Las funciones de alcance son: let, run, with, apply y also. Cada una de ellas tiene sus propias características y se usa en diferentes situaciones dependiendo de si usa o no el contexto del objeto receptor y si devuelve el objeto receptor o no.

![img](Extras/scope2.png)

### let
La función let se usa para ejecutar un bloque de código en el contexto de *un objeto que se le pasa como parámetro*. La función let *devuelve el resultado del bloque de código*. La función let es útil cuando queremos ejecutar un bloque de código en el contexto de un objeto y queremos devolver un valor. La usaremos para evitar el uso de nullables y seria el equivalente a un if not null.

```kotlin
// Ejemplo de uso de let
fun main() {
    val nombre: String? = "José Luis"
    val apellido: String? = "González Sánchez"

    // Uso de let
    nombre?.let { println(it) }
    apellido?.let { println(it) }

    // es equivalente a
    if (nombre != null) {
        println(nombre)
    }
    if (apellido != null) {
        println(apellido)
    }

    // Uso de let con el operador Elvis
    val nombreCompleto = nombre?.let { n -> apellido?.let { a -> "$n $a" } }
    println(nombreCompleto)
    
    // es equivalente a
    if (nombre != null && apellido != null) {
        val nombreCompleto = "$nombre $apellido"
        println(nombreCompleto)
    }
}
```

### run
La función run se usa para ejecutar un bloque de código en el contexto de un *objeto que se le pasa como receiver*. La función run *devuelve el resultado del bloque de código*. La función run es útil cuando queremos ejecutar un bloque de código en el contexto de un objeto y queremos devolver un valor. Se suele usar para inicializar objetos. 
También podemos usarlo como rama de else junto a let.

```kotlin
// Ejemplo de uso de run
class Persona(var nombre: String, var apellido: String) {
    fun nombreCompleto(): String = "$nombre $apellido"
}

fun main() {
    val persona = Persona("José Luis", "González Sánchez")

    // Uso de run
    val nombreCompleto = persona.run { nombreCompleto() }
    println(nombreCompleto)

    // es equivalente a
    val nombreCompleto2 = persona.nombreCompleto()
    println(nombreCompleto2)

    // Uso de let run como if else
    val nombre: String? = "José Luis"
    val apellido: String? = "González Sánchez"

    // Uso de let
    nombre?.let { println(it) } ?: run { println("No hay nombre") }
    apellido?.let { println(it) } ?: run { println("No hay apellido") }

    // es equivalente a
    if (nombre != null) {
        println(nombre)
    } else {
        println("No hay nombre")
    }
    if (apellido != null) {
        println(apellido)
    } else {
        println("No hay apellido")
    }
}
```

### with
La función with se usa para ejecutar un bloque de código en el contexto de un *objeto que se le pasa como parámetro*. La función with *devuelve el resultado del bloque de código*. La función with es útil cuando queremos ejecutar un bloque de código en el contexto de un objeto y queremos devolver un valor. Es ideal cuando queremos acceder a las propiedades de un objeto sin tener que usar el operador punto.

```kotlin
// Ejemplo de uso de with
class Persona(var nombre: String, var apellido: String) {
    fun nombreCompleto(): String = "$nombre $apellido"
}

fun main() {
    val persona = Persona("José Luis", "González Sánchez")

    // Uso de with, objeto como parámetro
    with(persona) { 
        it.nombre = "José Luis"
        it.apellido = "González Sánchez"
    }
    println(nombreCompleto)
}

```

### apply
La función apply se usa para ejecutar un bloque de código en el contexto de *un objeto que se le pasa como receiver*. La función apply *devuelve el objeto sobre el que se ejecuta*. La función apply es útil cuando queremos ejecutar un bloque de código en el contexto de un objeto y queremos devolver el objeto. Es ideal cuando queremos inicializar y configurar un objeto.

```kotlin
// Ejemplo de uso de apply
class Persona(var nombre: String, var apellido: String) {
    fun nombreCompleto(): String = "$nombre $apellido"
}

fun main() {
    val persona = Persona("José Luis", "González Sánchez")

    // Uso de apply, objeto como receiver this
    persona.apply { 
        nombre = "José Luis"
        apellido = "González Sánchez"
    }
    println(nombreCompleto)
}

```

### also
La función also se usa para ejecutar un bloque de código en el contexto de *un objeto que se le pasa como parámetro*. La función also *devuelve el objeto sobre el que se ejecuta*. La función also es útil cuando queremos ejecutar un bloque de código en el contexto de un objeto y queremos devolver el objeto. Es ideal para indicar efectos adicionales en nuestras acciones.

```kotlin
// Ejemplo de uso de also
class Persona(var nombre: String, var apellido: String) {
    fun nombreCompleto(): String = "$nombre $apellido"
}

fun main() {
    val persona = Persona("José Luis", "González Sánchez")

    // Uso de also, objeto como parámetro it
    persona.apply { 
        it.nombre = "José Luis"
        it.apellido = "González Sánchez"
    }.also {
        println(it.nombreCompleto())
    }
}

```

![img2](Extras/scope.png)


## Recursos
- Twitter: https://twitter.com/joseluisgonsan
- GitHub: https://github.com/joseluisgs
- Web: https://joseluisgs.github.io
- Discord del módulo: https://discord.gg/RRGsXfFDya
- Aula DAMnificad@s: https://discord.gg/XT8G5rRySU


## Autor

Codificado con :sparkling_heart: por [José Luis González Sánchez](https://twitter.com/joseluisgonsan)

[![Twitter](https://img.shields.io/twitter/follow/joseluisgonsan?style=social)](https://twitter.com/joseluisgonsan)
[![GitHub](https://img.shields.io/github/followers/joseluisgs?style=social)](https://github.com/joseluisgs)

### Contacto
<p>
  Cualquier cosa que necesites házmelo saber por si puedo ayudarte 💬.
</p>
<p>
 <a href="https://joseluisgs.github.io/" target="_blank">
        <img src="https://joseluisgs.github.io/img/favicon.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://github.com/joseluisgs" target="_blank">
        <img src="https://distreau.com/github.svg" 
    height="30">
    </a> &nbsp;&nbsp;
        <a href="https://twitter.com/joseluisgonsan" target="_blank">
        <img src="https://i.imgur.com/U4Uiaef.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://www.linkedin.com/in/joseluisgonsan" target="_blank">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/768px-LinkedIn_logo_initials.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://discordapp.com/users/joseluisgs#3560" target="_blank">
        <img src="https://logodownload.org/wp-content/uploads/2017/11/discord-logo-4-1.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://g.dev/joseluisgs" target="_blank">
        <img loading="lazy" src="https://googlediscovery.com/wp-content/uploads/google-developers.png" 
    height="30">
    </a>    
</p>

### ¿Un café?
<p><a href="https://www.buymeacoffee.com/joseluisgs"> <img align="left" src="https://cdn.buymeacoffee.com/buttons/v2/default-blue.png" height="50" alt="joseluisgs" /></a></p><br><br><br>

## Licencia de uso

Este repositorio y todo su contenido está licenciado bajo licencia **Creative Commons**, si desea saber más, vea la [LICENSE](https://joseluisgs.github.io/docs/license/). Por favor si compartes, usas o modificas este proyecto cita a su autor, y usa las mismas condiciones para su uso docente, formativo o educativo y no comercial.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Licencia de Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">JoseLuisGS</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="https://joseluisgs.github.io/" property="cc:attributionName" rel="cc:attributionURL">José Luis González Sánchez</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Reconocimiento-NoComercial-CompartirIgual 4.0 Internacional License</a>.<br />Creado a partir de la obra en <a xmlns:dct="http://purl.org/dc/terms/" href="https://github.com/joseluisgs" rel="dct:source">https://github.com/joseluisgs</a>.
