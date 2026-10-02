package com.thxy.prop

import com.thxy.prop.binary.*
import com.thxy.prop.unary.Not

interface Prop {
    val name: String
    override fun toString(): String
    fun eval(vararg envs: Pair<AtomProp, Boolean>): Boolean
    fun eval(envList: List<Pair<AtomProp, Boolean>>): Boolean = eval(*envList.toTypedArray())
    fun eval(envMap: Map<AtomProp, Boolean>): Boolean = eval(envMap.toList())


    fun atomProps(): Set<AtomProp>

    operator fun not(): Prop = Not(this)
    infix fun and(other: Prop): Prop = And(this, other)
    infix fun or(other: Prop): Prop = Or(this, other)
    infix fun imp(other: Prop): Prop = Imp(this, other)
    infix fun iff(other: Prop): Prop = Iff(this, other)
    infix fun nand(other: Prop): Prop = Nand(this, other)
    infix fun nor(other: Prop): Prop = Nor(this, other)
    infix fun xor(other: Prop): Prop = Xor(this, other)

    fun allAssignments(): Sequence<Pair<Map<AtomProp, Boolean>, Boolean>> = sequence {
        val vars = atomProps().toList()
        val n = vars.size
        for (i in 0..<(1 shl vars.size)) {
            vars.indices.map {
                vars[it] to ((i shl (n - it - 1) and 1) == 1)
            }.also {
                yield(it.toMap() to eval(it))
            }
        }
    }

    fun isTrue(): Boolean = !allAssignments().any { !it.second }
    fun isFalse(): Boolean = !allAssignments().any { it.second }
}