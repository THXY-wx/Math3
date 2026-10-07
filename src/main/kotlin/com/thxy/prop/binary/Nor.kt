package com.thxy.prop.binary

import com.thxy.prop.atom.AtomProp
import com.thxy.prop.Prop

data class Nor(override val a: Prop, override val b: Prop): BinaryProp(a,b) {
    override val name = "⊽"
    override fun eval(vararg envs: Pair<AtomProp, Boolean>) =
        !(a.eval(*envs) || b.eval(*envs))
}