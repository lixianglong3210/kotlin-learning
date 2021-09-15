fun main() {
    Player2.Equipment("AK47").show()
}

/**
 * 嵌套类，一个雷只针对另一个类起作用
 */
class Player2() {
    class Equipment(var name: String) {
        fun show() {
            println("equipment $name")
        }
    }
    fun battle() {
        Equipment("shark").show()
    }
}