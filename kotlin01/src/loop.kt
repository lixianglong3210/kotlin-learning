/**
 *  循环控制
 */
fun main(args: Array<String>) {
    handleBase()
    // handleLoop()
    // handleWhile()
}

fun handleBase() {
    for (i in 1..4) print(i) // 打印结果为: "1234"
    println()
    for (i in 4 downTo 1) print(i) // 打印结果为: "4321"
    println()
    for (i in 1..4 step 2) print(i) // 打印结果为: "13"
    println()
    for (i in 4 downTo 1 step 2) print(i) // 打印结果为: "42"
    println()
    for (i in 1 until 10) { // i in [1, 10), 不包含 10
        print(i)
    }
}

/**
 * item, index
 */
fun handleLoop() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

/**
 * do...while
 */
fun handleWhile() {
    println("---while 使用 ----")
    var x = 5
    while (x > 0) {
        println(x--)
    }
    println("---do while 使用 ----")
    var y = 5
    do {
        println(y--)
    } while (y > 0)
}