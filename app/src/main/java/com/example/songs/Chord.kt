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
    val inc_step: Int
    val inc_bas_step: Int

    constructor(step: Int, type: String, bas_step: Int = step, inc_step: Int = 0, inc_bas_step: Int = 0) {
        this.step = (step - 1) % 7 + 1
        this.type = type
        this.bas_step = bas_step
        this.inc_step = inc_step
        this.inc_bas_step = inc_bas_step
    }

    constructor(step: Int, type: Int, bas_step: Int = step, inc_step: Int = 0, inc_bas_step: Int = 0) :
            this(step, Chord.types[type]!!, bas_step, inc_step, inc_bas_step)

//    constructor(step: Int, type: String) : this(step, type, step)

    fun toString(key: Key): String {
        var out = key.getStep(this.step, this.inc_step).name
        if (this.step != this.bas_step || this.inc_bas_step != this.inc_step) {
            out += "/"
            out += key.getStep(this.bas_step, this.inc_bas_step).name
        }
        out += this.type
        return out
    }
}
