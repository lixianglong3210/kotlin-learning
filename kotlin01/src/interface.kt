/**
 * 接口
 */
fun main(args: Array<String>) {
    val d = D()
    d.foo()
    d.bar()
}

interface A {
    fun foo() { print('A') }
    fun bar()
}

interface B {
    fun foo () { print('B') }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() {
        print("bar")
    }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}