package com.example.songs

import org.junit.Assert.*
import org.junit.Test

class KeyTest {
    @Test
    fun create_Fis_by_typeId() {
        val key = Key(Note("F#"), 1)
        assertEquals(Note("F#"), key.note)
        assertEquals(Key.types[1], key.type)
    }

    @Test
    fun create_Hm_by_typeId() {
        val key = Key(Note("H"), 2)
        assertEquals(Note("H"), key.note)
        assertEquals(Key.types[2], key.type)
    }

    @Test
    fun create_Cb_by_note() {
        val key = Key(Note("Cb"))
        assertEquals(Note("Cb"), key.note)
        assertEquals(Key.types[1], key.type)
    }

    @Test
    fun create_Cism_by_name() {
        val key = Key("C#m")
        assertEquals(Note("C#"), key.note)
        assertEquals(Key.types[2], key.type)
    }

    @Test
    fun create_G_by_name() {
        val key = Key("G")
        assertEquals(Note("G"), key.note)
        assertEquals(Key.types[1], key.type)
    }

    @Test
    fun create_Dm_by_name() {
        val key = Key("Dm")
        assertEquals(Note("D"), key.note)
        assertEquals(Key.types[2], key.type)
    }

    @Test
    fun create_Bb_by_name() {
        val key = Key("Bb")
        assertEquals(Note("Bb"), key.note)
        assertEquals(Key.types[1], key.type)
    }
}