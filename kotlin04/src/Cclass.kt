import kotlin.math.absoluteValue

fun main() {
    // handleBase()
    // handleInit()
    // handleOrder()
    // handleLateinit()
    handleLazy()
}

/**
 * base
 */
fun handleBase() {
    var p = Baseclass()
    println(p.name)
    p.name = " rose "
    println(p.name)
}
class Baseclass {
    var name:String = "jack"
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }
}

/**
 * init
 */
fun handleInit() {
    Player(isNormal = false, _name = "")
}
class Player(
    _name: String,
    var age: Int = 20,
    var isNormal: Boolean
) {
    var name = _name
        get() = field.capitalize()
        set(value) {
            field = value.trim()
        }

    constructor(name: String) : this(name, age = 10, isNormal = false)

    init {
        require(age>0) {"age must be positive"}
        require(name.isNotBlank()) {"player must have a name."}
    }
}


/**
 * 初始化顺序
 * 1.主构造函数里声明属性
 * 2.类级别的属性赋值
 * 3.init初始化快里的属性赋值和函数调用
 * 4.次构造函数里的属性赋值和函数调用
 */
class Student(
    _name: String,
    val age: Int
) {
    var name = _name
    var score = 10
    private val hobby = "music"
    val subject:String

    init {
        println("initializing student ...")
        subject = "math"
    }

    constructor(name: String):this(name, age=10) {
        score = 20
    }
}
fun handleOrder() {
    Student("Jack")
}

/**
 * 延迟初始化
 */
fun handleLateinit() {
    var p = Player3()
    p.ready()
    p.battle()
}
class Player3{
    lateinit var equipment:String
    fun ready() {
        equipment = "shark"
    }
    fun battle() {
        if (::equipment.isInitialized) println(equipment)
    }
}

/**
 * 惰性初始化
 */
class Player4(
    _name:String
) {
    var name = _name

    val config by lazy { loading() }

    private fun loading(): String {
        println("loading")
        return "xxx"
    }
}
fun handleLazy() {
    var p = Player4("Jack")
    Thread.sleep(3000)
    println(p.config)
}