package com.thxy.prop.nullary

import com.thxy.prop.AtomProp
import com.thxy.prop.Prop

abstract class NullaryProp : Prop {
    abstract override val name: String
    abstract fun eval(): Boolean
    override fun eval(vararg envs: Pair<AtomProp, Boolean>): Boolean = eval()
    final override fun toString(): String = name
    override fun atomProps(): Set<AtomProp> = emptySet()
}