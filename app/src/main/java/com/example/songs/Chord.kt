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
    val bas_step: Int?
    val inc_step: Int
    val inc_bas_step: Int

    constructor(step: Int, type: String, bas_step: Int? = null, inc_step: Int = 0, inc_bas_step: Int = 0) {
        this.step = (step + 6) % 7 + 1
        this.type = type
        this.bas_step = bas_step
        this.inc_step = inc_step
        this.inc_bas_step = inc_bas_step
    }

    constructor(step: Int, type: Int, bas_step: Int? = null, inc_step: Int = 0, inc_bas_step: Int = 0) :
            this(step, Chord.types[type]!!, bas_step, inc_step, inc_bas_step)

//    constructor(step: Int, type: String) : this(step, type, step)

    data class ResFindNotesInName(val note: Note, val bas_note: Note?, val pass: Int)
    fun findNotesInName(name: String) : ResFindNotesInName{
        try {
            var (note, pass) = Note.makeNote(name)
            var bas_note: Note? = null

            if (name.length > pass) {
                if (name[pass] == '/') {
                    pass++
                    val res = Note.makeNote(name.substring(pass))
                    bas_note = res.note
                    pass += res.pass
                }
            }

            return ResFindNotesInName(note, bas_note, pass)
        } catch (e: NoteException) {
            throw ChordException(name)
        }
    }

    constructor(name: String, key: Key) {
        val (note, bas_note, pass) = findNotesInName(name)

        if (name.length > pass) {
            if (Chord.types.containsValue(name.substring(pass))) {
                this.type = name.substring(pass)
            } else {
                throw ChordException(name)
            }
        } else {
            this.type = ""
        }

        val res = key.whatStep(note)
        this.step = res.step
        this.inc_step = res.inc_step
        if (bas_note != null) {
            val bas_res = key.whatStep(bas_note)
            this.bas_step = bas_res.step
            this.inc_bas_step = bas_res.inc_step
        } else {
            this.bas_step = null
            this.inc_bas_step = 0
        }
    }

    constructor(name: String, nameOfKey: String) : this(name, Key(nameOfKey)) {
    }

    fun toString(key: Key): String {
        var out = key.getStep(this.step, this.inc_step).name
        if (this.bas_step != null) {
            out += "/"
            out += key.getStep(this.bas_step, this.inc_bas_step).name
        }
        out += this.type
        return out
    }
}
