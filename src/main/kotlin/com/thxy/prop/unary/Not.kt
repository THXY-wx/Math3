package com.thxy.prop.unary

import com.thxy.prop.Atom
import com.thxy.prop.Prop

data class Not(override val e: Prop): UnaryProp(e) {
    override val name = "¬"
    override fun eval(vararg envs: Pair<Atom, Boolean>): Boolean = !e.eval(*envs)
}
