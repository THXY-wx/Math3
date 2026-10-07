package com.thxy.tuple

data class Tuple<T>(val valueList: List<T>) {
    constructor(vararg values: T) : this(values.toList())

    override fun toString() = valueList.joinToString(",", "(", ")")

    operator fun plus(other: Tuple<T>) = Tuple(valueList + other.valueList)

    operator fun plus(t: T) = Tuple(valueList + t)


}