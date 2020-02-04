package com.example.songs

import org.junit.Assert.*
import org.junit.Test

class NoteTest {
    @Test
    fun create_note_C_by_name() {
        val note = Note("C")
        assert(note.name == "C")
        assert(note.natural == Note.natural_notes.getFir('C'))
        assert(note.note_id == Note.natural_notes_id['C'])
    }

    @Test
    fun create_note_Gis_by_name() {
        val note = Note("G#")
        assert(note.name == "G#")
        assert(note.natural == Note.natural_notes.getFir('G'))
        assert(note.note_id == Note.natural_notes_id['G']!! + 1)
    }

    @Test
    fun create_note_Bb_by_name() {
        val note = Note("Bb")
        assert(note.name == "Bb")
        assert(note.natural == Note.natural_notes.getFir('H'))
        assert(note.note_id == Note.natural_notes_id['H']!! - 1)
    }

    @Test
    fun create_note_Db_by_id() {
        val note = Note(Note.natural_notes_id['D']!! - 1, Note.natural_notes.getFir('D')!!)
        assert(note.name == "Db")
        assert(note.natural == Note.natural_notes.getFir('D'))
        assert(note.note_id == Note.natural_notes_id['D']!! - 1)
    }

    @Test
    fun create_note_His_by_id() {
        val note = Note(Note.natural_notes_id['H']!! + 1, Note.natural_notes.getFir('H')!!)
        assert(note.name == "H#")
        assert(note.natural == Note.natural_notes.getFir('H'))
        assert(note.note_id == (Note.natural_notes_id['H']!! + 1) % 12)
    }

    @Test
    fun create_note_A_by_id() {
        val note = Note(Note.natural_notes_id['A']!!, Note.natural_notes.getFir('A')!!)
        assert(note.name == "A")
        assert(note.natural == Note.natural_notes.getFir('A'))
        assert(note.note_id == Note.natural_notes_id['A']!!)
    }
}