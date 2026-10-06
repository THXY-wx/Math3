package com.thxy.prop

import com.thxy.prop.nullary.Top


fun andAll(vararg props: Prop): Prop =
    props.sliceArray(1..<props.size).fold(props.firstOrNull() ?: Top()) { a, b ->
        a and b
    }

fun isImp(propSet: Set<Prop>, prop: Prop): Boolean =
    (andAll(*propSet.toTypedArray()) imp prop).isAlwaysTrue()

fun isImp(a: Prop, b: Prop): Boolean = isImp(setOf(a), b)
fun isImp(a: Set<Prop>, b: Set<Prop>): Boolean = isImp(a, andAll(*b.toTypedArray()))

fun isEqv(a: Set<Prop>, b: Set<Prop>): Boolean = isImp(a, b) && isImp(b, a)
fun isEqv(a: Prop, b: Prop): Boolean = isImp(a, b) && isImp(b, a)