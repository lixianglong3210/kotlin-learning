/**
 * 函数传递
 * 匿名函数，即lambda
 * 匿名函数不需要写return语句
 */
fun main() {

    // 写法1
    val getDiscountWords1: (String, Int) -> String = {goodsName, hour ->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }
    showOnBoard("卫生纸", getDiscountWords1)

    // 写法2
    val getDiscountWords2 = {goodsName:String, hour:Int ->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }
    showOnBoard("卫生纸", getDiscountWords2)

    // 写法3
    showOnBoard("卫生纸", {goodsName: String, hour: Int ->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    })

    // 写法4
    showOnBoard("卫生纸"){goodsName: String, hour: Int ->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
    }
}

/**
 * 可以不加inline
 * inline的目的是采用宏替换的放方式，提高变异性能，
 * 但inline不能用于lambda的递归方式
 */
private inline fun showOnBoard(goodsName: String, getDisCountTime: (String, Int) -> String) {
    val hour = (1..24).shuffled().last()
    println(getDisCountTime(goodsName, hour))
}