package com.thxy.prop.unary

import com.thxy.prop.AtomProp
import com.thxy.prop.Prop

abstract class UnaryProp(open val prop: Prop) : Prop {
    abstract override val name: String
    abstract override fun eval(vararg envs: Pair<AtomProp, Boolean>): Boolean
    final override fun toString(): String = "$name$prop"
    override fun atomProps(): Set<AtomProp> = prop.atomProps()
}