package com.example.songs

class Key {
    companion object {
        val types = mapOf(
            1 to mapOf(1 to 0, 2 to 2, 3 to 4, 4 to 5, 5 to 7, 6 to 9, 7 to 11),  //major
            2 to mapOf(1 to 0, 2 to 2, 3 to 3, 4 to 5, 5 to 7, 6 to 8, 7 to 10)   //minor
        )
    }

    val note: Note
    val type: Map<Int,Int>

    constructor(note: Note, type: Int) {
        this.note = note
        this.type = Key.types[type]!!
    }

    fun getStep(step: Int): Note {
        var st = step
        if (st > 7)
            st = st % 7 + 1
        return Note(this.note.note_id + this.type[st]!!, this.note.natural + st)
    }
}