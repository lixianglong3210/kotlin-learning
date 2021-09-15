/**
 * 类和对象
 */
fun main(args: Array<String>) {
    // var person: Person = Person()
    //
    // person.lastName = "wang"
    // println("lastName:${person.lastName}")
    //
    // person.getNo = 9
    // println("getNo:${person.getNo}")
    //
    // person.getNo = 20
    // println("getNo:${person.getNo}")

    // val runoob = Runoob("菜鸟教程", 10000)
    // println(runoob.siteName)
    // println(runoob.url)
    // println(runoob.country)
    // runoob.printTest()

    // val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
    // println(demo)
    // val demo2 = Outer().Inner().innerTest()
    // println(demo2)

    handleInterFace()

}

/**
 * 属性、geter、setter
 */
class Person {
    var lastName: String = "zhang"
        get() = field.toUpperCase()
        set

    var no: Int = 100
        get() = field   // 后端变量
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }

    var height: Float = 145.4f
        private set
}

/**
 * 主构造函数、次构造函数
 */
class Runoob constructor(name: String) {
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名称： ${name}")
    }
    // 次构造函数
    constructor(name: String, alexa: Int): this(name) {
        println("$name 排名 $alexa")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

/**
 * 抽象类
 */
open class Base {
    open fun f() {}
}
abstract class Derived: Base() {
    override abstract fun f()
}

/**
 * 嵌套类、内部类
 */
class Outer {
    private val bar: Int = 1
    var v = "成员属性"
    class Nested {
        fun foo() = 2
    }
    /**嵌套内部类**/
    inner class Inner {
        fun foo() = bar     // 访问外部类成员
        fun innerTest() {
            var o = this@Outer   // 获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}

/**
 * 匿名内部类
 */
interface TestInterFace {
    fun test()
}
class Test {
    var v = "成员属性"
    fun setInterface(test: TestInterFace) {
        test.test()
    }
}
fun handleInterFace() {
    var test = Test()
    test.setInterface(object: TestInterFace {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}