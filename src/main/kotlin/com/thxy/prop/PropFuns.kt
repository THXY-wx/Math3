package com.thxy.prop

import com.thxy.prop.nullary.Top


fun andAll(vararg props: Prop): Prop =
    props.sliceArray(1..<props.size).fold(props.firstOrNull() ?: Top()) { a, b ->
        a and b
    }

fun isImp(propSet: Set<Prop>, prop: Prop): Boolean =
    prop.evals(andAll(*propSet.toTypedArray()).trueValues()).all { it.second }