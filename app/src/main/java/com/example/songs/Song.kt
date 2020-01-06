package com.example.songs

class Song {
    private var text : String = ""
    private var name : String
    private var second_name : String? = null

    constructor(name: String){
        this.name = name
    }

    fun getName() = name
    fun getSecondName() = second_name
    fun getText() = text

    fun changeName(name: String) {
        this.name = name
    }

    fun setSecondName(second_name: String) {
        this.second_name = second_name
    }

    fun changeText(text: String) {
        this.text = text
    }


}