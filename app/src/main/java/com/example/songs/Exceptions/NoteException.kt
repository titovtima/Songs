package com.example.songs.Exceptions

import java.lang.Exception

class NoteException(val note_name : String?,
                    val note_id : Int?,
                    val note_short_name : Char?) : Exception() {

    constructor(note_id: Int, note_short_name: Char) : this(null, note_id, note_short_name)

    constructor(note_name: String) : this(note_name, null, null)
}