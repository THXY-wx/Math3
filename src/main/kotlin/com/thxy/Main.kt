package com.thxy

import com.thxy.prop.atom.AtomProp
import com.thxy.prop.isImp

fun main() {
    val a = AtomProp("A")
    val b = AtomProp("B")
    val c = AtomProp("C")

    val output = isImp(setOf(a or (b imp c), b iff !c), a or !b)

    println(output)
}