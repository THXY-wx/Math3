package com.thxy

import com.thxy.prop.*

fun main() {
    val a = AtomProp("A")
    val b = !a xor a
    println(b.allAssignments().toList())
}