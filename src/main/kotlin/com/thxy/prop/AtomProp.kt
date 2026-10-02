package com.thxy.prop

data class AtomProp(override val name: String) : Prop {
    override fun eval(vararg envs: Pair<AtomProp, Boolean>): Boolean =
        envs.toMap()[this] ?: error("${this}未赋值")

    override fun toString(): String = name
    override fun atomProps(): Set<AtomProp> = setOf(this)

}
