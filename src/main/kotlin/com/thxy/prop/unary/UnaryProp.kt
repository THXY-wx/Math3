package com.thxy.prop.unary

import com.thxy.prop.Atom
import com.thxy.prop.Prop

abstract class UnaryProp(open val e: Prop) : Prop {
    abstract override val name: String
    abstract override fun eval(vararg envs: Pair<Atom, Boolean>): Boolean
    final override fun toString(): String = "$name$e"
}