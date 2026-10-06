package com.thxy.prop.nullary

class Bot() : NullaryProp() {
    override val name = "⊥"
    override fun eval(): Boolean = false
}
