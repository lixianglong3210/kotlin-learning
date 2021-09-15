package com.json.kotlin.extension

/**
 * 自定义扩展文件
 */
fun <T> Iterable<T>.randomTake(): T = this.shuffled().first()