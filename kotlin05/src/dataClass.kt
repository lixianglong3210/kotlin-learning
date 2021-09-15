/**
 * 数据类
 * 1.实现了toString()方法
 * 2.重写了equires方法，使用==时，不再时比较引用，而是比较内容
 * 3.重写了hashcode方法
 *
 * copy函数
 * 解构方法，数据类可以直接按照集合的方式写解构
 *
 * 应用场景：经常需要比较、复制或打印自身
 * 数据类必须满足条件：
 * 1.主构造函数必须至少带一个参数；
 * 2.参数必须是var、val
 * 3.不能使用abstract、open、sealed或inner修饰符
 */
fun main() {
    // 实现了toString()方法
    // println(Coordinate(10, 20))
    // 使用==时，不再时比较引用，而是比较内容
    // println(Coordinate(10, 20) == Coordinate(10, 20))

    // copy函数
    // val s = Student("Jack")
    // val copy = s.copy("Rose")
    // println(s)
    // println(copy)

    // 解构
    // val (x, y) = Coordinate(10, 20)
    // println("$x, $y")
    // 如果不是数据类，需要加上operator声明的component1
    // val (m, n) = PlayerScore(30, 40)
    // println("$m, $n")

    // 运算符重载
    val c1 = Coordinate2(10, 20)
    val c2 = Coordinate2(10, 20)
    println(c1 + c2)
}

data class Coordinate(var x: Int, var y: Int) {
    val isInBounds = x > 0 && y > 0
}

/**
 * copy函数，类似于clone
 * 可以很方便的复制一个对象
 */
data class Student(var name: String, var age: Int) {
    private val hobby = "music"
    val subject: String
    var score = 0

    init {
        println("init")
        subject = "math"
    }

    // 旧版本的kotlin，copy函数不会继承super中的constructor
    constructor(_name:String) : this(_name, 10) {
        score = 10
    }

    override fun toString(): String {
        return "Student(name='$name', age=$age, hobby='$hobby', subject='$subject')"
    }
}

class PlayerScore(val experience: Int, var level: Int) {
    operator fun component1() = experience
    operator fun component2() = level
}

/**
 * 加法运算符
 */
data class Coordinate2(var x: Int, var y: Int) {
    val isInBounds = x > 0 && y > 0
    operator fun plus(other: Coordinate2) = Coordinate2(x + other.x, y + other.y)
}