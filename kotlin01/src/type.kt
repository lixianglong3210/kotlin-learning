/**
 * 类型
 */
fun main(args: Array<String>) {
    // base()
    // compare()
    // print(decimalDigitValue('8'))
    // handleArray()
    // handleRows()
    handleStrMoudle()
}

/**
 * 使用下划线
 * */
fun base () {
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    println(oneMillion)
    println(creditCardNumber)
    println(socialSecurityNumber)
    println(hexBytes)
    println(bytes)
}

/**
 * 三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小
 */
fun compare () {
    val a: Int = 10000
    println(a === a) // true，值相等，对象地址相等

    // 经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    // 虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等
}

/**
 * 类型转换
 * 较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
 * toByte(): Byte
 * toShort(): Short
 * toInt(): Int
 * toLong(): Long
 * toFloat(): Float
 * toDouble(): Double
 * toChar(): Char
 */
fun conversion() {
    // val b: Byte = 1 // OK, 字面值是静态检测的
    // val i: Int = b // 错误

    val b: Byte = 1 // OK, 字面值是静态检测的
    val i: Int = b.toInt() // OK
    print(i)
}

/**
 * 字符，Char 必需是单引号 ' 包含起来的
 */
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // 显式转换为数字
}

/**
 * 数组
 * 数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数
 */
fun handleArray() {
    val a = arrayOf(1, 2, 3)
    val b = Array(3, { i -> (i * 2)})

    println(a[0])
    println(b[1])

    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]
    println(x[0])
}

/**
 * 多行字符串
 */
fun handleRows() {
    val text = """
       多行字符串 
       多行字符串 
    """
    println(text)
    //trimMargin()清除空格和字符
    //trimIndent()清除空格
    val txt = """
        |多行字符串
        |菜鸟教程
        |多行字符串
    """.trimIndent()
    println(txt)

}

/**
 * 字符串模板
 */
fun handleStrMoudle () {
    val i = 10
    val s = "i = $i"
    println(s)

    val l = "lxl"
    val str = "$l.length is ${l.length}"
    println(str)

    // 原生$转义方式
    val price = """
        $('$')9.99
    """.trimIndent()
    println(price)
}