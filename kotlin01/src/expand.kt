/**
 * 扩展函数
 */
fun main(args: Array<String>) {
    // val l = mutableListOf(1, 2, 3)
    // l.swap(0, 2)
    // println(l.toString())

    // var c = C1()
    // c.foo()

    // var t = null
    // println(t.toString())

    // println("getNo: ${MyClass.getNo}")
    // MyClass.foo()

    val f: F = F()
    val e: E = E()
    f.caller(e)
}

/**
 * 基本用法
 */
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

/**
 * 如果扩展函数与成员函数一致，则优先使用成员函数
 */
class C1 {
    fun foo() { println("成员函数") }
}

fun C1.foo() { println("扩展函数") }

/**
 * 扩展一个空对象
 */
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

/**
 * 生对象的扩展
 */
class MyClass {
    companion object {}
}
fun MyClass.Companion.foo() {
    println("伴随对象的扩展函数")
}
val MyClass.Companion.no: Int
    get() = 10

/**
 * 扩展声明成员
 * 在一个类内部你可以为另一个类声明扩展。
 */
class E {
    fun bar() { println("E bar") }
}
class F {
    fun baz() { println("F bar") }
    fun E.foo() {
        bar()   // 调用 E.bar
        baz()   // 调用 F.baz
    }
    fun caller(e: E) {
        e.foo()
    }
}