package com.thxy.prop.unary

import com.thxy.prop.atom.AtomProp
import com.thxy.prop.Prop

data class Not(override val prop: Prop): UnaryProp(prop) {
    override val name = "¬"
    override fun eval(vararg envs: Pair<AtomProp, Boolean>) = !prop.eval(*envs)
}
