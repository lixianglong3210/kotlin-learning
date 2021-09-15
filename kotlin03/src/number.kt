import kotlin.math.roundToInt

fun main() {
    handleToInt()
}

/**
 * 安全转换函数
 */
fun handleToInt() {
    val number1: Int? = 8.98.toInt()
    val number2: Int? = "8.98".toIntOrNull()
    val number3: Int? = 8.98.roundToInt()
    val number4 = "%.2f".format(8.9865)
    println(number1)
    println(number2)
    println(number3)
    println(number4)
}