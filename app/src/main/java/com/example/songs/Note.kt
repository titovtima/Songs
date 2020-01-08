package com.example.songs

import com.example.songs.Exceptions.NoteException

class Note {
    companion object {
        val natural_notes_id : Map<Char,Int> = mapOf(
            'C' to 0,
            'D' to 2,
            'E' to 4,
            'F' to 5,
            'G' to 7,
            'A' to 9,
            'H' to 11)

        val natural_notes = MyTwoSidedMap<Int,Char>(mapOf(
            0 to 'C',
            1 to 'D',
            2 to 'E',
            3 to 'F',
            4 to 'G',
            5 to 'A',
            6 to 'H'
        ))


        fun makeName(note_id: Int, natural: Int) : String {
            if (!natural_notes.containsKey(natural)) throw NoteException(note_id, natural)
            val short_name = natural_notes[natural]!!
            if (!natural_notes_id.containsKey(short_name)) throw NoteException(note_id, natural)
            if (note_id == 10) {
                return when (short_name) {
                    'A' -> "A#"
                    'H' -> "Bb"
                    else -> throw NoteException(note_id, natural)
                }
            }
            return when (note_id - natural_notes_id[short_name]!!) {
                0 -> short_name.toString()
                1 -> short_name.toString() + "#"
                -1 -> short_name.toString() + "b"
                else -> throw NoteException(note_id, natural)
            }
        }

        fun makeIdAndShortName(name: String) : Pair<Int,Int> {
            if (name.isEmpty()) throw NoteException(name)
            if (name[0] == 'B') {
                if (name.length < 2 || name[1] != 'b') throw NoteException(name)
                else return Pair(10, natural_notes.getFir('H')!!)
            }
            val short_name : Char = name[0]
            if (!natural_notes_id.containsKey(short_name)) throw NoteException(name)
            var note_id : Int = natural_notes_id[short_name]!!
            if (name.length > 1) {
                when (name[1]) {
                    '#' -> note_id++
                    'b' -> note_id--
                }
            }
            return Pair(note_id, natural_notes.getFir(short_name)!!)
        }
    }

    val note_id : Int
    val natural : Int
    val name : String

    constructor(note_id: Int, natural: Int) {
        this.note_id = note_id
        this.natural = natural
        this.name = makeName(note_id, natural)
    }

    constructor(name: String) {
        this.name = name
        val pair = makeIdAndShortName(name)
        this.note_id = pair.first
        this.natural = pair.second
    }
}