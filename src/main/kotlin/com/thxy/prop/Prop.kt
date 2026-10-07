package com.thxy.prop

import com.thxy.prop.atom.AtomProp
import com.thxy.prop.binary.And
import com.thxy.prop.binary.Iff
import com.thxy.prop.binary.Imp
import com.thxy.prop.binary.Nand
import com.thxy.prop.binary.Nor
import com.thxy.prop.binary.Or
import com.thxy.prop.binary.Xor
import com.thxy.prop.unary.Not

interface Prop {
    val name: String

    override fun toString(): String
    fun eval(vararg envs: Pair<AtomProp, Boolean>): Boolean
    fun eval(envList: List<Pair<AtomProp, Boolean>>) = eval(*envList.toTypedArray())
    fun eval(envMap: Map<AtomProp, Boolean>) = eval(envMap.toList())


    fun atomProps(): Set<AtomProp>

    operator fun not() = Not(this)
    infix fun and(other: Prop) = And(this, other)
    infix fun or(other: Prop) = Or(this, other)
    infix fun imp(other: Prop) = Imp(this, other)
    infix fun iff(other: Prop) = Iff(this, other)
    infix fun nand(other: Prop) = Nand(this, other)
    infix fun nor(other: Prop) = Nor(this, other)
    infix fun xor(other: Prop) = Xor(this, other)

    fun allAssignments() = sequence {
        val vars = atomProps().toList()
        val n = vars.size
        for (i in 0..<(1 shl vars.size)) {
            vars.indices.map {
                vars[it] to ((i shr (n - it - 1) and 1) == 1)
            }.let {
                yield(it.toMap() to eval(it))
            }
        }
    }

    fun isAlwaysTrue() = allAssignments().all { it.second }
    fun isAlwaysFalse() = allAssignments().all { !it.second }
    fun isCanBeTrue() = allAssignments().any { it.second }
    fun trueValues() =
        this@Prop.allAssignments().filter { it.second }.map { it.first }

    fun evals(envSequence: Sequence<Map<AtomProp, Boolean>>) =
        sequence {
            envSequence.forEach {
                yield(it to this@Prop.eval(it))
            }
        }

}