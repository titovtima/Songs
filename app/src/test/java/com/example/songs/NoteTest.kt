package com.example.songs

import org.junit.Assert.*
import org.junit.Test

class NoteTest {
    @Test
    fun create_note_C_by_name() {
        val note = Note("C")
        assert(note.name == "C")
        assert(note.natural == 0)
        assert(note.note_id == 0)
    }

    @Test
    fun create_note_Gis_by_name() {
        val note = Note("G#")
        assert(note.name == "G#")
        assert(note.natural == 4)
        assert(note.note_id == 8)
    }

    @Test
    fun create_note_Bb_by_name() {
        val note = Note("Bb")
        assert(note.name == "Bb")
        assert(note.natural == 6)
        assert(note.note_id == 10)
    }

    @Test
    fun create_note_Db_by_id() {
        val note = Note(1, 1)
        assert(note.name == "Db")
        assert(note.natural == 1)
        assert(note.note_id == 1)
    }

    @Test
    fun create_note_His_by_id() {
        val note = Note(12, 6)
        assert(note.name == "H#")
        assert(note.natural == 6)
        assert(note.note_id == 0)
    }

    @Test
    fun create_note_A_by_id() {
        val note = Note(9, 5)
        assert(note.name == "A")
        assert(note.natural == 5)
        assert(note.note_id == 9)
    }

    @Test
    fun create_note_Cb_by_id() {
        val note = Note(11, 0)
        assert(note.name == "Cb")
        assert(note.natural == 0)
        assert(note.note_id == 11)
    }

    @Test
    fun create_note_Cb_by_name() {
        val note = Note("Cb")
        assert(note.name == "Cb")
        assert(note.natural == 0)
        assert(note.note_id == 11)
    }

    @Test
    fun create_note_His_by_name() {
        val note = Note("H#")
        assert(note.name == "H#")
        assert(note.natural == 6)
        assert(note.note_id == 0)
    }
}