/**
 * 基础语法
 */
fun main (args: Array<String>) {
//    println(sum(1, 1))
//    printSun(1, 2)
//    vars(1,2,3,4,5)
//    sumLambda(2, 3)
//    varName()
//    sumNull()
//    print(getStringLength("asdasdsadsa"))
    section()
}

// type
fun sum (a: Int, b:Int) = a + b

// return null
fun printSun(a: Int, b: Int) {
    print(a + b)
}

// for 不定长度
fun vars(vararg v:Int) {
    for (item in v) {
        print(item)
    }
}

// lambda
fun sumLambda(a:Int, b:Int) {
    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
    println(sumLambda(a, b))
}

// var val
fun varName() {
    var a = 1
    val s1 = "a is $a"
    println(s1)
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

// $
fun sumNull() {
    //类型后面加?表示可为空
    var age: String? = "23"
    //抛出空指针异常
    val ages = age!!.toInt()
    //不做处理返回 null
    val ages1 = age?.toInt()
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1
    println("age is ${age}")
    println("ages is ${ages}")
    println("ages1 is ${ages1}")
    println("ages2 is ${ages2}")
}

// is
fun getStringLength (obj: Any): Int? {
    if (obj !is String) {
        return null
    }
    return obj.length
}

// 区间
fun section() {
    for (i in 1..4) print(i) // 输出“1234”
    println()
    println("========")

    for (i in 4..1) print(i) // 什么都不输出
    println()
    println("========")

    val item = 2
    if (item in 1..10) { // 等同于 1 <= i && i <= 10
        println(item)
    }
    println()
    println("========")

    // 使用 step 指定步长
    for (i in 1..4 step 2) print(i) // 输出“13”
    println()
    println("========")

    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    println()
    println("========")


    // 使用 until 函数排除结束元素
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10
        print(i)
    }
    println()
    println("========")
    
}