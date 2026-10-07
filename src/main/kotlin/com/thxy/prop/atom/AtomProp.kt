package com.thxy.prop.atom

import com.thxy.prop.Prop

data class AtomProp(override val name: String) : Prop {
    override fun eval(vararg envs: Pair<AtomProp, Boolean>) =
        envs.firstOrNull{ it.first == this }?.second ?: error("${this}未赋值")

    override fun toString() = name
    override fun atomProps() = setOf(this)

}
