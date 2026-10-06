package com.thxy.prop.atom

import com.thxy.prop.Prop

data class AtomProp(override val name: String) : Prop {
    override fun eval(vararg envs: Pair<AtomProp, Boolean>): Boolean =
        envs.firstOrNull{ it.first == this }?.second ?: error("${this}未赋值")

    override fun toString(): String = name
    override fun atomProps(): Set<AtomProp> = setOf(this)

}
