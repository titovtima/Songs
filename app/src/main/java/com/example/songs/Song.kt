package com.example.songs

import com.example.songs.Exceptions.ChordException

class Song {
    private var name : String
    private var text : String? = null
    private var second_name : String? = null
    private var chords : String? = null
    private var key: Key? = null
    private var mainKey: Key? = null

    constructor(name: String){
        this.name = name
    }

    fun getName() = name
    fun getSecondName() = second_name
    fun getText() = text
    fun getChords() = chords
    fun getKey() = key
    fun getMainKey() = mainKey

    fun setName(name: String) {
        this.name = name
    }

    fun setSecondName(second_name: String) {
        this.second_name = second_name
    }

    fun setText(text: String) {
        this.text = text
    }

    fun setChords(chords: String, key: Key) {
        this.chords = chords
        this.key = key
    }

    fun setMainKey(mainKey: Key?) {
        this.mainKey = mainKey
    }

    fun transpose(new_key: Key) {
        val text_chords = chords
        val key = this.key
        if (text_chords != null && key != null) {
            val arr_chords = text_chords.split(" \n").toTypedArray()
            for (i in 0..arr_chords.size) {
                try {
                    val chord = Chord(arr_chords[i], key)
                    arr_chords[i] = chord.toString(new_key)
                } catch (e: ChordException) { }
            }
            this.chords = ""
            for (str_ch in arr_chords) {
                this.chords += str_ch
            }
            this.key = new_key
        }
    }
}