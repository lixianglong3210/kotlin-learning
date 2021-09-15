/**
 * 函数式编程
 */
fun main() {
    /** 变换 **/
    // handleMap()
    // handleflatMap()
    /** 过滤 **/
    // handleFilter()
    // handlePrime()
    /** 合并 **/
    // handleZip()
    handleFold()
}

/**
 * map
 */
fun handleMap() {
    val res = listOf("a", "bb", "ccc")
    val result = res
        .map { "a little baby $it" }
        .map { "$it ,with name" }
    println(res)
    println(result)
    println(res.map { it.length })
}

/**
 * flatMap
 */
fun handleflatMap() {
    val res = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
    val result = res.flatMap { it }
    println(result)
    println(res.flatten())
}

/**
 * filter
 */
fun handleFilter() {
    val res = listOf("Jack", "Json", "Tom", "lity").filter { it.contains("J") }
    println(res)
}
/**
 * 例：筛选素数【除了1和本身，不能被整除】
 */
fun handlePrime() {
    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val res = numbers.filter { number ->
        (2 until number).map { number % it }
            .none{ it == 0 }
    }
    println(res)
}

/**
 * zip
 */
fun handleZip() {
    val names = listOf("Jack", "John", "Tom")
    val ages = listOf(18, 20, 22)
    val res = names.zip(ages).toMap()
    println(res)
    println(names.zip(ages))
    println(res["Jack"])
}

/**
 * fold
 * 类似reduce
 * 描述：初始值，累加得到结果
 * 例：每个值乘以3，然后相加
 */
fun handleFold() {
    val foldedValue = listOf(1, 2, 3, 4).fold(0) {
        accumulator, number -> accumulator + number * 3
    }
    println(foldedValue)
}
