package br.com.cwi.rocar.presentation.extension

import java.util.*

fun RandomNumberGenerator(): Int {
    fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) + start

    return (1..1000000000).random()
}