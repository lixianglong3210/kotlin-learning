fun main (args: Array<String>) {
    val color:Color = Color.BLUE

    println(Color.values())
    println(Color.valueOf("RED"))
    println(color.name)
    println(color.ordinal)

    printAllValue<RGB>()
}

enum class Color {
    RED,BLACK,BLUE,GREEN,WHITE
}

enum class RGB { RED, GREEN, BULE }
inline fun <reified T : Enum<T>> printAllValue() {
    print(enumValues<T>().joinToString { it.name })
}