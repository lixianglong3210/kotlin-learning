@file:JvmName("Hero")

import java.io.IOException
import kotlin.jvm.Throws

fun main() {
    val adversary = Jhava()
    println(adversary.utterGreeting())

    val level = adversary.determineFriendshipLevel()
    level?.toLowerCase()

    // java中需有get set方法
    adversary.hitPoints = 3
    println(adversary.hitPoints)

    handOverFood("apple")

    // java 抛异常 kotlin来处理，kotlin没有强制要try catch
    try {
        adversary.extendHandInFrienfship()
    } catch (e: Exception) {
        println(e)
    }
}

fun makeProclamation() = "Greetings, beast!"

// @JvmOverloads方便java调用时，不用参数、或随机个数参数
@JvmOverloads
fun handOverFood(leftHand: String = "berries", rightHand: String = "beef") {
    println("leftHand is $leftHand ,rightHand is $rightHand")
}

@Throws(IOException::class)
fun acceptApology() {
    throw IOException()
}

/**
 * 函数类型操作
 */
val translator = { utterance: String ->
    println(utterance.toLowerCase().capitalize())
}