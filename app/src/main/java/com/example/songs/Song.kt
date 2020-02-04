package com.example.songs

class Song {
    private var name : String
    private var text : String? = ""
    private var second_name : String? = null
    private var chords : String? = ""

    constructor(name: String){
        this.name = name
    }

    fun getName() = name
    fun getSecondName() = second_name
    fun getText() = text
    fun getChords() = chords

    fun setName(name: String) {
        this.name = name
    }

    fun setSecondName(second_name: String) {
        this.second_name = second_name
    }

    fun setText(text: String) {
        this.text = text
    }

    fun setChords(chords: String) {
        this.chords = chords
    }
}