package com.example.songs

class Chord {
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
