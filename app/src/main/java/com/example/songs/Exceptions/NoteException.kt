package com.example.songs.Exceptions

import java.lang.Exception

class NoteException(val note_name : String?,
                    val note_id : Int?,
                    val note_natural : Int?) :
    Exception("Note name = $note_name, Note id = $note_id, Note natural = $note_natural") {

    constructor(note_id: Int, note_natural: Int) : this(null, note_id, note_natural)

    constructor(note_name: String) : this(note_name, null, null)

}