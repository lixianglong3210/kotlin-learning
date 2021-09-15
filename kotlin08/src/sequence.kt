/**
 * 序列
 * 【GenerateSequence迭代器函数】
 * 不是用于指针，而是产生不确定数量的集合
 */
fun main() {
    // handleNormalWay()
    handleGenerateSequence()
}

/**
 * 目标：获取头1000个素数
 */

/**
 * 普通方法
 */
fun handleNormalWay() {
    val toList = (1..5000).toList()
        .filter { number -> (2 until number).map { number % it }.none{ it == 0} }
        .take(1000)
    println(toList)
    println(toList.size) // 无法确定有1000个
}

/**
 * GenerateSequence
 */
fun handleGenerateSequence() {
    val res = generateSequence (1) { value -> value + 1 }
        .filter { number -> (2 until number).map { number % it }.none{ it == 0} }
        .take(1000)
    println(res.toList())
    println(res.toList().size)
}