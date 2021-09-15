/**
 * out
 */
interface Production<out T> {
    fun product() : T
}

/**
 * in
 */
interface Consumer<in T> {
    fun consume(item: T)
}

/**
 * in & out
 */
interface ProductionAndConsumer<T> {
    fun product(): T
    fun consume(item: T)
}