/**
 * 继承
 */
fun main(args: Array<String>) {
    val s = Student("lxl", 18, "S123456", 89)
    s.study()
}

/**
 * 有主构造函数
 */
// open class Person1(var name: String, var age: Int) {
//
// }
// class Student(name: String, age: Int, var getNo: String, var score: Int): Person1(name, age) {
//
// }

/**
 * 子类没有主构造函数
 */
open class Person1(name: String) {
    constructor(name: String, age: Int): this(name) {
        println("-------基类次级构造函数---------")
    }
    open fun study() {
        println("我毕业了")
    }
}
class Student: Person1 {
    constructor(name: String, age: Int, no: String, score: Int):super(name, age) {
        println("学生姓名： $name")
        println("年龄：$age")
        println("学生号： $no")
        println("成绩： $score")
    }

    /**
     * 重写
     */
    override fun study() {
        // super.study()        // 会输出父类的study方法，即：我毕业了
        println("我在读大学")
    }
}
