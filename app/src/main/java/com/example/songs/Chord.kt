package com.example.songs

class Chord {
    companion object {
        val types = mapOf<Int,String>(
            1 to "",
            2 to "m",
            3 to "7",
            4 to "m7",
            5 to "maj7",
            7 to "sus4",
            8 to "sus2",
            9 to "2",
            10 to "4",
            11 to "6",
            12 to "(+5)",
            13 to "dim"
        )
    }

    val step: Int
    val type: String
    val bas_step: Int

    constructor(step: Int, type: String, bas_step: Int) {
        this.step = step
        this.type = type
        this.bas_step = bas_step
    }

    constructor(step: Int, type: String) : this(step, type, step)

//    fun toString(key: Int): String {
//
//    }
}
