package com.thxy.tuple


fun <T> emptyTuple() = Tuple(emptyList<T>())

fun <T> Set<T>.pow(n: Int): Set<Tuple<T>> {
    if (n < 0) error("n不能小于0")
    if (n == 0) return setOf(emptyTuple())
    return (1..n).fold(setOf(emptyTuple())) { acc, _ ->
        this.flatMap { e ->
            acc.map { Tuple(e) + it }
        }.toSet()
    }
}