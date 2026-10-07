package com.thxy.prop.nullary

class Top : NullaryProp() {
    override val name = "⊤"
    override fun eval() = true
}
