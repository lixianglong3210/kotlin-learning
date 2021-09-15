/**
 * reified
 * reified关键字能帮你检查泛型参数的类型，
 * Kotilin不允许对泛型参数T做类型检查，因为泛型参数类型会被类型擦除
 */
open class Human1(val age: Int)
class Boy1(val name: String, age: Int) : Human1(age) {
    override fun toString(): String {
        return "Boy1(name='$name',age='$age')"
    }
}
class Man1(val name: String, age: Int) : Human1(age) {
    override fun toString(): String {
        return "Man1(name='$name',age='$age')"
    }
}

class MagicBox1<T : Human1>() {
    inline fun <reified T> randomOrBackup(backup: () -> T): T {
        val items = listOf(
            Boy1("jack", 20),
            Man1("john", 35)
        )
        val random = items.shuffled().first()
        println(random)
        return if (random is T) {
            random
        } else {
            backup()
        }
    }
}

fun main() {
    val box1:MagicBox1<Boy1> = MagicBox1()
    val subject = box1.randomOrBackup {
        Man1("Jimmy", 38)
    }
    println(subject)
}