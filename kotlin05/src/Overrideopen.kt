import java.io.File

open class Overrideopen(val name: String) {
    fun description() = "Product $name"
    open fun loading() = "loading....1"
}

class Chi : Overrideopen("lxl") {
    override fun loading() = "loading....2"

    fun special() = "special class ...."
}

fun main() {
    val p: Overrideopen = Chi()
    println(p.loading())

    // is 类型检测
    println(p is Overrideopen)
    println(p is Chi)
    println(p is File)

    // as 类型转换
    if(p is Chi) {
        println((p as Chi).special())
    }
    // kotlin是智能类型转换，只要一次，后面都可以访问
    println((p as Chi).special())

    // Any是所有类的超类
    println(p is Any)
}