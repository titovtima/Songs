package com.example.songs

import com.example.songs.Exceptions.NoteException

class Note {
    companion object {
        val natural_notes : Map<Char,Int> = mapOf(
            'C' to 0,
            'D' to 2,
            'E' to 4,
            'F' to 5,
            'G' to 7,
            'A' to 9,
            'H' to 11)


        fun makeName(note_id: Int, short_name: Char) : String {
            if (!natural_notes.containsKey(short_name)) throw NoteException(note_id, short_name)
            if (note_id == 10) {
                return when (short_name) {
                    'A' -> "A#"
                    'H' -> "Bb"
                    else -> throw NoteException(note_id, short_name)
                }
            }
            return when (note_id - natural_notes[short_name]!!) {
                0 -> short_name.toString()
                1 -> short_name.toString() + "#"
                -1 -> short_name.toString() + "b"
                else -> throw NoteException(note_id, short_name)
            }
        }

        fun makeIdAndShortName(name: String) : Pair<Int,Char> {
            if (name.isEmpty()) throw NoteException(name)
            if (name[0] == 'B') {
                if (name.length < 2 || name[1] != 'b') throw NoteException(name)
                else return Pair(10, 'H')
            }
            val short_name : Char = name[0]
            if (!natural_notes.containsKey(short_name)) throw NoteException(name)
            var note_id : Int = natural_notes[short_name]!!
            if (name.length > 1) {
                when (name[1]) {
                    '#' -> note_id++
                    'b' -> note_id--
                }
            }
            return Pair(note_id, short_name)
        }
    }

    val note_id : Int
    val short_name : Char
    val name : String

    constructor(note_id: Int, short_name: Char) {
        this.note_id = note_id
        this.short_name = short_name
        this.name = makeName(note_id, short_name)
    }

    constructor(name: String) {
        this.name = name
        val pair = makeIdAndShortName(name)
        this.note_id = pair.first
        this.short_name = pair.second
    }
}