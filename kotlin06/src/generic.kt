fun main() {
    val cat: Topic<Cat> = Topic(Cat("111", 11))
    val dog: Topic<Dog> = Topic(Dog("222"))


    val boy: Topic1<Boy> = Topic1(Boy("jack", 11))
    val man: Man? = boy.fetch {
        Man(it.name, it.age.plus(15))
    }
    // 匿名函数写法，等价于 val man1: Man? = boy.fetch({Man(it.name, it.age.plus(15))})

    val box1: MagicBox<Cat> = MagicBox(
        Cat("aaa", 11),
        Cat("bbb", 22),
        Cat("ccc", 33)
    )
    box1.available = true

    box1[1]
}

/**
 * 泛型
 */
class Topic<T>(item: T) {
    private var subject: T = item
    var available = false
}

class Cat(val name: String, val age: Int)
class Dog(val name: String)

/**
 * 泛型函数、多泛型参数
 */
open class Human(val age: Int) // 泛型约束

class Topic1<T : Human>(item: T) {
    private var subject: T = item
    var available = false

    // 泛型函数
    fun fetch(): T? {
        return subject.takeIf { available }
    }

    // 多泛型参数
    fun <R> fetch(subjectModFunction: (T) -> R) : R? {
        return subjectModFunction(subject).takeIf { available }
    }
}
class Boy(val name: String, age: Int) : Human(age)
class Man(val name: String, age: Int) : Human(age)

/**
 * vararg
 */
class MagicBox<T>(vararg item: T) {
    var available = false
    private var subject: Array<out T> = item

    fun fetch(index: Int): T? {
        return subject[index].takeIf { available }
    }

    // []运算符重载
    operator fun get(index: Int): T? = subject[index].takeIf { available }
}