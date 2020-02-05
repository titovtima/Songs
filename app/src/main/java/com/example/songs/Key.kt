package com.example.songs

import java.security.KeyException

class Key {
    companion object {
        val types = mapOf(
            1 to mapOf(1 to 0, 2 to 2, 3 to 4, 4 to 5, 5 to 7, 6 to 9, 7 to 11),  //major
            2 to mapOf(1 to 0, 2 to 2, 3 to 3, 4 to 5, 5 to 7, 6 to 8, 7 to 10)   //minor
        )
    }

    val note: Note
    val type: Map<Int,Int>

    constructor(note: Note, type: Int = 1) {
        this.note = note
        this.type = Key.types[type]!!
    }

    constructor(name: String) {
        val (note, pass) = Note.makeNote(name)
        this.note = note

        if (name.length > pass) {
            if (name[pass] == 'm' && name.length == pass + 1) {
                this.type = Key.types[2]!!
            } else {
                throw KeyException(name)
            }
        } else {
            this.type = Key.types[1]!!
        }
    }

    fun getStep(step: Int, inc_step: Int = 0): Note {
        var st = step
        if (st > 7)
            st = (st - 1) % 7 + 1
        return Note(this.note.note_id + this.type[st]!! + inc_step, this.note.natural + st)
    }

    data class ResWhatStep(val step: Int, val inc_step: Int)
    fun whatStep(note: Note): ResWhatStep {
        val step = (note.natural - this.note.natural + 7) % 7 + 1
        val inc_step = (note.note_id - this.note.note_id - this.type[step]!! + 12) % 12
        return ResWhatStep(step, inc_step)
    }
}