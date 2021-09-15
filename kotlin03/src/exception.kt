fun main() {
    var number: Int? = null

    try {
        checkOperation(number)
        number!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }
}

fun checkOperation(number: Int?) {
    checkNotNull(number, {"操作不当"})
}