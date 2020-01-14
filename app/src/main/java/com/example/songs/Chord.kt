package com.example.songs

import com.example.songs.Exceptions.ChordException
import com.example.songs.Exceptions.NoteException

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

    constructor(name: String, key: Key) {
        var note: Note? = null
        var bas_note: Note? = null
        var type: String?
        var pass = 0
        try {
            val p = Note.makeNote(name)
            note = p.first
            pass += p.second
        } catch (e: NoteException) {
            throw ChordException(name)
        }
        if (name.length > pass) {
            if (name[pass] == '/') {
                pass++
                try {
                    val p = Note.makeNote(name.substring(pass))
                    bas_note = p.first
                    pass += p.second
                } catch (e: NoteException) {
                    throw ChordException(name)
                }
            }
        }
        if (name.length > pass) {
            if (Chord.types.containsValue(name.substring(pass))) {
                this.type = name.substring(pass)
            } else {
                throw ChordException(name)
            }
        } else {
            this.type = ""
        }
        val p_step = key.whatStep(note)
        this.step = p_step.first
        this.inc_step = p_step.second
        if (bas_note != null) {
            val p_bstep = key.whatStep(bas_note)
            this.bas_step = p_bstep.first
            this.inc_bas_step = p_bstep.second
        } else {
            this.bas_step = step
            this.inc_bas_step = inc_step
        }
    }

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
