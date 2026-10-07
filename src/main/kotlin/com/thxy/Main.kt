package com.thxy

import com.thxy.prop.atom.AtomProp
import com.thxy.prop.isEqv
import com.thxy.prop.isImp
import com.thxy.prop.makeProp
import com.thxy.tuple.Tuple
import com.thxy.tuple.pow

fun main() {
    val a = AtomProp("A")
    val b = AtomProp("B")
    val c = AtomProp("C")
    val d = Tuple("A","B","C")
    val s = setOf("a","b","c")

    val output = makeProp((a or (b imp c) and b iff !c).allAssignments())

    println(isEqv(output,a or (b imp c) and b iff !c))
}