fun main () {
    var str:String? = "lxl"
    // str = ""
    str = str?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "is null"
        }
    }
    println(str)

    /**
     * 空合并操作符
     */
    var str1:String? = "aaa"
    str1 = null
    println(str1 ?: "bbb")

    var str2:String? = "aaa"
    str2 = null
    println(str2?.let { it.capitalize() } ?: "ccc")

    
}
