fun main(args: Array<String>) {

    val joe = Person("Joe", "Jones", 45);
    val jane = Person("jane", "Smith", 12);
    val marry = Person("marry", "Wilson", 70);
    val john = Person("john", "Adams", 32);
    val jean = Person("jean", "Smithson", 66);

    val (fName, lName, age) = joe

    println("fname = $fName, lName = $lName, age = $age")

    val people = mapOf("Jones" to joe,
        "Smith" to jane,
        "Wilson" to marry,
        "Adams" to john,
        "Smithson" to jean)

    println(people.filter { it.value.lastName.startsWith('S') }.count())

    val namePairs = people.map { Pair(it.value.firstName, it.value.lastName) }
    println(namePairs)

    val firstName = people.map { it.value.lastName }
    val lastNames = people.map { it.value.lastName }
    val namePairs2 = firstName.zip(lastNames)
    println(namePairs2)


    // also function

    people.also {
        it.map { println("${it.value.firstName} is ${it.value.age} years old") }
    }

    val  list1 = listOf(1, 2, 4,5,6, 7)
    val  list2 = listOf(4, 55, -83, 22, 101)

    val list3 = list1.filter { it in list2 }
    println(list3)

    val list3_1 = list1.filter { list2.contains(it) }
    println(list3_1)

    val regularPaper = Box<Regular>()
    var paper = Box<Paper>()
    paper = regularPaper

//    paper.addPaper(Premium())



}

class Person(val firstName: String, val lastName: String, val age: Int) {

    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age

}

// Covariant
class Box<out T> {

//    fun takePaper() : T {
//
//    }
//
//    fun addPaper(paper: T) {
//
//    }

}

open class Paper {

}

class Regular : Paper() {

}

class Premium: Paper() {

}