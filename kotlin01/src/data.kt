/**
 * 数据类与密封类
 */
fun main(args: Array<String>) {
    // val jack = User(name="Jack", age = 1)
    // val olderJack = jack.copy(age = 2)
    // println(jack)
    // println(olderJack)
    // val jane = User("jane", 35)
    // val (name, age) = jane // 解构声明
    // println("$name, $age years of age")

    // var strCo: runOut<String> = runOut("a")
    // var anyCo: runOut<Any> = runOut<Any>("b")
    // anyCo = strCo
    // println(anyCo.foo())

    var strDCo = runIn("a")
    var anyDCo = runIn<Any>("b")
    strDCo = anyDCo
}

data class User(val name: String, val age: Int)

/**
 * 密封类
 */
sealed class Expr
data class Const(val number: Double): Expr()
data class Sum(val e1: Expr, val e2: Expr): Expr()
object NotANumber: Expr()

fun eval(expr: Expr): Double = when(expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}

/**
 * 型变
 */
// 定义一个支持协变的类
class runOut<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}
class runIn<in A>(a: A) {
    fun foo(a: A) {
    }
}