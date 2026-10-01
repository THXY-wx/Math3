package com.thxy.prop.binary

import com.thxy.prop.Atom
import com.thxy.prop.Prop

data class Or(override val a: Prop, override val b: Prop) : BinaryProp(a, b) {
    override val name = "∨"
    override fun eval(vararg envs: Pair<Atom, Boolean>): Boolean = a.eval(*envs) || b.eval(*envs)
}
