package com.thxy.prop

import com.thxy.prop.atom.AtomProp
import com.thxy.prop.nullary.Top


fun andAll(vararg props: Prop) =
    props.sliceArray(1..<props.size).fold(props.firstOrNull() ?: Top()) { a, b ->
        a and b
    }

fun andAll(propList: List<Prop>) = andAll(*propList.toTypedArray())

fun orAll(vararg props: Prop) =
    props.sliceArray(1..<props.size).fold(props.firstOrNull() ?: Top()) { a, b ->
        a or b
    }

fun orAll(propList: List<Prop>) = orAll(*propList.toTypedArray())


fun isImp(propSet: Set<Prop>, prop: Prop) =
    (andAll(*propSet.toTypedArray()) imp prop).isAlwaysTrue()

fun isImp(a: Prop, b: Prop) = isImp(setOf(a), b)
fun isImp(a: Set<Prop>, b: Set<Prop>) = isImp(a, andAll(*b.toTypedArray()))

fun isEqv(a: Set<Prop>, b: Set<Prop>) = isImp(a, b) && isImp(b, a)
fun isEqv(a: Prop, b: Prop) = isImp(a, b) && isImp(b, a)

fun makeProp(value: Sequence<Pair<Map<AtomProp, Boolean>, Boolean>>) =
    value.filter { it.second }.map {
        it.first.map { (key, value) ->
            if (value) key
            else !key
        }.let { props -> andAll(props) }
    }.let { orAll(it.toList()) }

fun makeProp(value: Map<Map<AtomProp, Boolean>, Boolean>) =
    sequence {
        value.forEach { (m, b) ->
            yield(m to b)
        }
    }.let { makeProp(it) }

