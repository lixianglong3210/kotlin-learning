import java.io.File

fun main() {
    // handleList()
    // handleMutableList()
    hadndleMutator()
    // handleUnRepeat()
    // handleMap()
}

/**
 * listof
 * 不可变list，可转mutableListOf
 */
fun handleList() {
    val list = listOf("Jack", "Json", "Jecy")
    println(list.getOrElse(4){ "unknow"})
    println(list.getOrNull(4))
}

/**
 * mutableListOf
 * 可变list，可转listOf
 */
fun handleMutableList() {
    val mutableList = mutableListOf("Jack", "Json", "Jecy")
    mutableList.add("Jimmy")
    mutableList.remove("Jecy")
    println(mutableList)
}

/**
 * mutator函数
 * 能修改可变列表mutableListOf的函数，统称mutator函数
 */
fun hadndleMutator() {
    val mutableList = mutableListOf("Jack", "Json", "Jecy")
    mutableList += "Jimmy"
    println(mutableList)
    mutableList -= "Jecy"
    println(mutableList)
    mutableList.removeIf { it.contains("Jack") }
    println(mutableList)
}

/**
 * 解构方式，_
 * 使用_，编译时不会出现该元素
 */
fun handleDeconstruction() {
    val (name1, _, name3) = listOf("Jack", "Json", "Jecy")
}

/**
 * list去重
 */
fun handleUnRepeat() {
    println(
        listOf("Jack", "Json", "Jecy","Jack").distinct()
    )
}

/**
 * setof
 * mutableSetOf
 */


/**
 * Array
 */
fun handleArray() {
    val intArray = intArrayOf(10, 20, 30)
    listOf(10, 20, 30).toIntArray()
    val array = arrayOf(File("aaa"), File("bbb"))
}

/**
 * map
 */
fun handleMap() {
    val map = mapOf("name1" to 10, "name2" to 20, "name3" to 30)
    println(
        map
    )
    println(
        mapOf(Pair("name1", 10), Pair("name2", 20), Pair("name3", 30))
    )

    // 读取
    println(map["name1"])
    println(map.getValue("name1"))
    println(map.getOrElse("name4"){"Unknow"})
    println(map.getOrDefault("name5", 0))

    // 遍历
    map.forEach{
        println("${it.key}, ${it.value}")
    }
    map.forEach{ (key:String, value:Int) ->
        println("$key $value")
    }

    // mutableMapOf()
    val mutableMap = mutableMapOf("name1" to 10, "name2" to 20, "name3" to 30)
    mutableMap += "name4" to 40
    mutableMap.put("name5", 50)
    mutableMap.getOrPut("name6"){60}
    println(mutableMap)
}