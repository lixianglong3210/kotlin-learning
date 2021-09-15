/**
 * 函数引用
 * 具名函数，需要return语句
 */
fun main() {
    showOnBoard("牙膏", ::getDiscountWords1)
}

private fun getDiscountWords1(goodsName:String, hour:Int): String {
    val currentYear = 2027
    return "${currentYear}年，双11${goodsName}促销倒计时：$hour 小时"
}

private fun showOnBoard(goodsName: String, getDisCountTime: (String, Int) -> String) {
    val hour = (1..24).shuffled().last()
    println(getDisCountTime(goodsName, hour))
}