package com.thxy.usefulfuns

import kotlin.math.pow

infix fun Int.pow(other: Int): Int = this.toDouble().pow(other).toInt()