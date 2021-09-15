import kotlin.reflect.KProperty

/**
 * 委托
 */
fun main(args: Array<String>) {
    // val b = BaseImpl(10)
    // Derived0(b).print()

    val e = Example()
    println(e.p)    // 访问该属性，调用 getValue() 函数
    e.p = "Runoob"  // 调用 setValue() 函数
    println(e.p)
}

/**
 * 类委托
 */
interface Base0 {
    fun print()
}
class BaseImpl(val x: Int): Base0 {
    override fun print() {
        print(x)
    }
}
class Derived0(b: Base0): Base0 by b

/**
 * 属性委托
 */
// 委托的类
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef,这里委托了 ${property.name} 属性"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}
// 定义包含属性委托的类
class Example {
    var p: String by Delegate()
}
