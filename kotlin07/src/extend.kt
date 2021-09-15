import com.json.kotlin.extension.randomTake as randomizer

fun main() {
    println("abc".addExt(2))
    "abc".eastPrint()

    "abc".lxlprint()

    "The people's Republic of China".numVowels.eastPrint()

    val nullableString: String? = null
    nullableString.printWithDefault("it is null")

    // 自定义扩展文件
    val list = listOf("Json", "Jon", "john")
    val set = setOf("Json", "Jon", "john")
    println(list.randomizer())
}

/**
 * 扩展函数【默认有个this属性，它是隐式调用】
 */
fun String.addExt(amount: Int = 1) = this + "!".repeat(amount)
fun Any.eastPrint() = println(this)

/**
 * 泛型扩展函数
 */
fun <T> T.lxlprint(): T {
    println(this)
    return this
}

/**
 * 扩展属性
 */
val String.numVowels
    get() = count { "aeiou".contains(it) }

/**
 * 可空类型扩展函数
 */
fun String?.printWithDefault(default: String) = println(this ?: default)

/**
 * infix关键字
 * 适用于单个参数
 * 接收者和函数之间的点.操作 以及参数的一堆括号（）都可以不要
 */
fun testInfix() {
    mapOf("jack" to 18) // infix
    // "jack".to(18) // 实际写法
}

/**
 * apply标准函数，其实现方式就是  泛型 扩展函数
 * 扩展函数也可以是匿名函数
 */
