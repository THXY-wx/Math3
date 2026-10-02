package com.thxy.prop.binary

import com.thxy.prop.AtomProp
import com.thxy.prop.Prop

abstract class BinaryProp(open val a: Prop, open val b: Prop) : Prop {
    abstract override val name: String
    abstract override fun eval(vararg envs: Pair<AtomProp, Boolean>): Boolean
    final override fun toString(): String = "($a $name $b)"
    override fun atomProps(): Set<AtomProp> = a.atomProps() + b.atomProps()
}