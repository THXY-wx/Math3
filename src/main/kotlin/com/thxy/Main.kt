package com.thxy

import com.thxy.prop.*

fun main() {
    val a = Atom("A")
    val b = !a xor a
    println(b.eval(a to true))
}