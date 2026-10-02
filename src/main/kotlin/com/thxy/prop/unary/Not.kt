package com.thxy.prop.unary

import com.thxy.prop.AtomProp
import com.thxy.prop.Prop

data class Not(override val prop: Prop): UnaryProp(prop) {
    override val name = "¬"
    override fun eval(vararg envs: Pair<AtomProp, Boolean>): Boolean = !prop.eval(*envs)
}
