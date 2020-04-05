package com.example.songs

import org.junit.Test

class AllTests {
    private val noteTest = NoteTest()
    private val keyTest = KeyTest()
    private val chordTest = ChordTest()

    @Test
    fun runAllTests() {
        noteTest.runAllTests()
        keyTest.runAllTests()
        chordTest.runAllTests()
    }
}