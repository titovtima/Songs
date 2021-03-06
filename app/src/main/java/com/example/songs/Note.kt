package com.example.songs

import com.example.songs.Exceptions.NoteException
import java.lang.Exception

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
            val short_name = natural_notes[natural] ?: throw NoteException(note_id, natural)
            if (!natural_notes_id.containsKey(short_name)) throw NoteException(note_id, natural)
            if (note_id == 10) {
                return when (short_name) {
                    'A' -> "A#"
                    'H' -> "Bb"
                    else -> throw NoteException(note_id, natural)
                }
            }
            return when ((note_id + 12 - natural_notes_id.getValue(short_name)) % 12) {
                0 -> short_name.toString()
                1 -> short_name.toString() + "#"
                11 -> short_name.toString() + "b"
                else -> throw NoteException(note_id, natural)
            }
        }

        data class ResMakeIdAndShortName(val note_id: Int, val natural: Int)
        fun makeIdAndShortName(name: String) : ResMakeIdAndShortName {
            if (name.isEmpty()) throw NoteException(name)
            if (name[0] == 'B') {
                if (name.length < 2 || name[1] != 'b') throw NoteException(name)
                else return ResMakeIdAndShortName(10, natural_notes.getFir('H'))
            }
            val short_name : Char = name[0]
            if (!natural_notes_id.containsKey(short_name)) throw NoteException(name)
            var note_id : Int = natural_notes_id.getValue(short_name)
            if (name.length > 1) {
                when (name[1]) {
                    '#' -> note_id++
                    'b' -> note_id--
                    else -> throw NoteException(name)
                }
            }
            note_id = (note_id + 12) % 12
            return ResMakeIdAndShortName(note_id, natural_notes.getFir(short_name))
        }

        data class ResMakeNoteOfName(val note: Note, val pass: Int)
        fun makeNote(name: String): ResMakeNoteOfName {
            if (name.length == 0) throw NoteException(name)
            var note: Note?
//            var pass: Int
            if (name.length > 1) {
                try {
                    note = Note(name.substring(0, 2))
                    return ResMakeNoteOfName(note, 2)
                } catch (e: NoteException) {}
            }
            if (name.length > 0) {
                try {
                    note = Note(name.substring(0, 1))
                    return ResMakeNoteOfName(note, 1)
                } catch (e: NoteException) {}
            }
            throw NoteException(name)
//            try {
//                note = Note(name.substring(0,1))
//                pass = 1
//            } catch (e1: NoteException) {
//                if (name.length == 1) throw NoteException(name)
//                try {
//                    note = Note(name.substring(0, 2))
//                    pass = 2
//                } catch (e2: NoteException) {
//                    throw NoteException(name)
//                }
//            }
//            return ResMakeNoteOfName(note!!, pass)
        }
    }

    val note_id : Int
    val natural : Int
    val name : String

    constructor(note_id: Int, natural: Int) {
        this.note_id = note_id % 12
        this.natural = natural % 7
        this.name = makeName(this.note_id, this.natural)
    }

    constructor(name: String) {
        this.name = name
        val res = makeIdAndShortName(name)
        this.note_id = res.note_id
        this.natural = res.natural
    }

    override fun equals(other: Any?): Boolean {
        try {
            return this.note_id == (other as Note).note_id
                    && this.natural == (other as Note).natural
        } catch (e: Exception) {
            return super.equals(other)
        }
    }
}