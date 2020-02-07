package com.example.songs

import org.junit.Test

import org.junit.Assert.*

class ChordTest {

    @Test
    fun create_VIIm7_by_numbers() {
        val chord = Chord(7, "m7")
        assertEquals(7, chord.step)
        assertEquals(null, chord.bas_step)
        assertEquals(0, chord.inc_step)
        assertEquals(0, chord.inc_bas_step)
        assertEquals("m7", chord.type)
    }

    @Test
    fun create_G_in_C() {
        val chord = Chord("G", "C")
        assertEquals(5, chord.step)
        assertEquals(null, chord.bas_step)
        assertEquals(0, chord.inc_step)
        assertEquals(0, chord.inc_bas_step)
        assertEquals("", chord.type)
    }

    @Test
    fun create_Fissus2_in_Cism() {
        val chord = Chord("F#sus2", "C#m")
        assertEquals(4, chord.step)
        assertEquals(null, chord.bas_step)
        assertEquals(0, chord.inc_step)
        assertEquals(0, chord.inc_bas_step)
        assertEquals("sus2", chord.type)
    }

    @Test
    fun create_Bbmaj7_in_C() {
        val chord = Chord("Bbmaj7", "C")
        assertEquals(7, chord.step)
        assertEquals(null, chord.bas_step)
        assertEquals(11, chord.inc_step)
        assertEquals(0, chord.inc_bas_step)
        assertEquals("maj7", chord.type)
    }

    @Test
    fun create_Fis2_basCis_in_Gm() {
        val chord = Chord("F#2/C#", "Gm")
        assertEquals(7, chord.step)
        assertEquals(4, chord.bas_step)
        assertEquals(1, chord.inc_step)
        assertEquals(1,chord.inc_bas_step)
        assertEquals("2", chord.type)
    }
}