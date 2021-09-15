/**
 * object类，俗称单列
 * 只有一个类做状态管理，用完即丢
 * 使用有3种方式
 * 1.对象声明
 * 2.对象表达式
 * 3.伴生对象
 */
import java.io.File

fun main() {
    ApplicationConfig.setSomething()
    println(ApplicationConfig)
    println(ApplicationConfig)

    // 对象表达式
    // val p = object : Player() {
    //     override fun loading() = "class loading"
    // }
    // println(p.loading())

    ConfigMap.load()
}

/**
 * 对象声明
 * 只提供一个单例对象，一份，不用每次new对象都要申请内存
 */
object ApplicationConfig {
    init {
        println("do nothing....")
    }
    fun setSomething() {
        println("set Something")
    }
}

/**
 * 对象表达式
 * 如果你只需要用一次，不一定非要定义一个新的命名类，或者你需要某个现有类的一种辩题实例
 * 连命名都可以省了，这个对象表达式式XX的子类，只能有一个实例
 */
open class  Player {
    open fun loading() = "loading nothing"
}

/**
 * 伴生对象
 * 如果你想将某个对象的初始化和一个类实例捆绑在一起
 * 一个类只能有一个伴生对象
 */
open class ConfigMap {
    // companion 关键字
    // 只有初始化ConfigMap类或调用load函数时，伴生对象的内容才会载入内存
    // 而且无论实例化ConfigMap类多少次，这个伴生对象始终只有一个实存在
    companion object {
        private const val PATH = "E://lxl//前端知识库//GIT//常用.txt"

        fun load() = File(PATH).readBytes()
    }
}
