import java.io.File

fun main() {
    // handleLet()
    // handleRun()
    // handleWith()
    // handleAlso()
    // handleTakeIf()
    handleTakeUnless()
}

/**
 * apply函数,隐式调用（即file.setReadable、file.setWritable），没有传入，返回当前接受者
 */
fun handleApply() {
    // 配置一个file实例
    val file1 = File("E://lxl//前端知识库//GIT//常用.txt")
    file1.setReadable(true)
    file1.setWritable(true)
    file1.setExecutable(false)
    // 使用apply
    val file2 = File("E://lxl//前端知识库//GIT//常用.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }
}

/**
 * let函数，传入接受者，返回lambda最后一行
 */
fun handleLet() {
    println(listOf(3,2,1).last().let {
        it * it
    })

    val name = null
    println(name?.let { "welcome $it" } ?: "what's your name")
}

/**
 * run函数，与apply类似，隐式调用，没有入参，但不返回接受者，而是返回lambda最后一行结果
 */
fun handleRun() {
    val file = File("E://lxl//前端知识库//GIT//常用.txt")
    println(
        file.run {
            readText().contains("remote")
        }
    )

    // 执行函数引用
    "The people's Republic of China".run(::isLong).run(::showMessage).run(::println)
}
fun isLong(name: String) = name.length > 10
fun showMessage(isLong: Boolean): String {
    return if (isLong) {
        "The name is too long"
    } else {
        "The name is OK!"
    }
}

/**
 * with函数，与run一样，只是调用方式不同，值参作为其第一个参数传入
 */
fun handleWith() {
    println(
        with("The people's Republic of China") {
            length > 10
        }
    )
}

/**
 * also函数，与let函数相似，但also返回接受者对象
 */
fun handleAlso() {
    var flieContents:List<String>
    File("E://lxl//前端知识库//GIT//常用.txt")
        .also {
            println(it.name)
        }.also {
            flieContents = it.readLines()
        }
    println(flieContents)
}

/**
 * takeif函数，判断一个lambda表达式，返回true or false
 * true 则返回接受对象
 * false 则返回null
 */
fun handleTakeIf() {
    println(
        File("E://lxl//前端知识库//GIT//常用.txt")
            .takeIf { it.exists() && it.canRead() }
            ?.readText()
    )
}

/**
 * takeUnless函数，刚好与takeIf函数相反
 * false 则返回接受对象
 * true 则返回null
 */
fun handleTakeUnless() {
    println(
        File("E://lxl//前端知识库//GIT//常用.txt")
            .takeUnless { it.isHidden }
            ?.readText()
    )
}