const val NAME = "Jimmy's friend"
const val NAMES = "Json, Jock, Jeasony"

fun main() {
    handleSubstring()
    handleSplit()
    handleReplace()
    handleYun()
    handleForeach()
}

/**
 * substring inRange
 */
fun handleSubstring() {
    val index = NAME.indexOf("\'")
    println(NAME.substring(0 until index))
}

/**
 * split 解构语法
 */
fun handleSplit() {
    val ( name1, name2, name3 ) = NAMES.split(',')
    println("$name1 $name2 $name3")
}

/**
 * replace lambda
 */
fun handleReplace() {
    val str1 = "The people's Republic of China"
    val str2 = str1.replace(Regex("[aeiou]")){
        when(it.value) {
            "a" -> "8"
            "e" -> "6"
            "i" -> "9"
            "o" -> "1"
            "u" -> "3"
            else -> it.value
        }
    }
    println(str1)
    println(str2)
}

/**
 * ==   ====
 */
fun handleYun() {
    val str1 = "Json"
    val str2 = "Json"
    val str3 = "json".capitalize()
    println(str1 == str2) // true
    println(str1 === str2) // true
    println(str1 == str3) // true
    println(str1 === str3) // false
}

fun handleForeach() {
    val str1 = "The people's Republic of China"
    str1.forEach {
        print("$it *")
    }
}