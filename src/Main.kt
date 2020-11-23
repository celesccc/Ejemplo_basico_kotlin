fun main() {
    val a = ClasePadre()
    a.diHola()
    println(a.atributoPadre)
    a.diAdios()

    val b = ClaseHija()
    b.diHola()
    println(b.atributoPadre)
    println(b.atributoHijo)
    b.diAdios()

    // No se puede ya que ClasePadre es abstracto:
    // val c = ClasePadreAbstracto()
    val d = ClaseHijaAbstracta()
    println(d.atributoHijo)
    println(d.atributoPadre)
    d.funAbstracta()

    val f = ClaseHija2Abstracta()
    val lista = listOf(d,f)
    println("Cosas abstractas")
    println(lista[0].funAbstracta())
    println(lista[1].funAbstracta())

    val e = ClaseImplementaInterfaz1()
    val g = ClaseImplementaInterfaz2()

    // listOf<MyInterface1>(e, g) //creo una lista de interfaces1
    // No funciona xq "g" no implementa MyInterface1

    var listaInterface = listOf<MyInterface2>(g, e)
    listaInterface.forEach{
        it.funInterface2()
    }
}


open class ClasePadre {
    val atributoPadre = 1
    open fun diHola(){ //open para poder hacer override
        println("Hola")
    }
    fun diAdios(){
        println("Adios")
    }
}

class ClaseHija : ClasePadre() { //extends = :
    val atributoHijo = 2
    override fun diHola(){
        println("Saludos")
    }
}


abstract class ClasePadreAbstracto {
    val atributoPadre = 3
    abstract fun funAbstracta()
}

class ClaseHijaAbstracta : ClasePadreAbstracto() {
    val atributoHijo = 4
    override fun funAbstracta() {
        println("Soy funAbstracta")
    }
}

class ClaseHija2Abstracta : ClasePadreAbstracto() {
    val atributoHijo2 = 4
    override fun funAbstracta() {
        println(atributoHijo2)
    }
}

interface MyInterface1 {
    fun funInterface1()
}

interface MyInterface2 {
    fun funInterface2()
}

class ClaseImplementaInterfaz1 : MyInterface1, MyInterface2{
    override fun funInterface1() {
        println("Soy funInterface1")
    }

    override fun funInterface2() {
        println("Soy funInterface2")
    }
}

class ClaseImplementaInterfaz2 : MyInterface2{

    override fun funInterface2() {
        println("Soy funInterface2")
    }
}