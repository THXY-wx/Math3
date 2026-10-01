package com.thxy.prop

data class Atom(override val name: String) : Prop {
    override fun eval(vararg envs: Pair<Atom, Boolean>): Boolean =
        envs.toMap()[this] ?: error("${this}未赋值")

    override fun toString(): String = name

}
