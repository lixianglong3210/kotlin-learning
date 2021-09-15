/**
 * 条件
 */
fun main(args: Array<String>) {
    // hanldeSimple()
    // handleJudge()
    handleWhen()
}

/**
 * 三元操作
 */
fun hanldeSimple() {
    var a = 1
    var b = 2
    val c = if (a>=b) a else b
    println("c 的值为 $c")
}

/**
 * 区间
 */
fun handleJudge() {
    val x = 5
    if(x in 1..8) {
        println("x 在区间内")
    }
}

/**
 * when 类似 Switch
 */
fun handleWhen () {
    val x = 31
    val validNumbers = 10..20
    when(x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        3, 4 -> println("x == 3 or x== 4")
        in 5..10 -> print("x is in the 5---10")
        in validNumbers -> print("x is in the 10---20")
        else -> {
            println("x 未知")
        }
    }

    when(x) {
        is Int -> println("x is Int")
        else -> false
    }

    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}