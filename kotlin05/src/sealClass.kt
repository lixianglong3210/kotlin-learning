/**
 * 密封类
 * 可以用来定义一个类似于枚举类的ADT
 * 可以有若干个子类，要继承密封类，这些子类必须和他定义在同一个文件里
 */
sealed class LiscenseStatus {
    object UnQualified : LiscenseStatus()
    object Learning : LiscenseStatus()
    class Quqlified(val liscenseId: String): LiscenseStatus()
}

class Driver(var status: LiscenseStatus) {
    fun checkLicense() : String {
        return when(status) {
            is LiscenseStatus.UnQualified -> "没资格"
            is LiscenseStatus.Learning -> "在学"
            is LiscenseStatus.Quqlified -> "有资格，驾驶证编号： ${(this.status as LiscenseStatus.Quqlified).liscenseId}"
        }
    }
}

fun main() {
    val status = LiscenseStatus.Quqlified("233135456433")
    val driver = Driver(status)
    println(driver.checkLicense())
}

