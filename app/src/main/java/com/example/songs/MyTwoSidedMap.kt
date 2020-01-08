package com.example.songs

class MyTwoSidedMap<F, S>() : HashMap<F, S>() {
    val backMap = HashMap<S, F>()

    override fun put(key: F, value: S): S? {
        backMap[value] = key
        return super.put(key, value)
    }

    fun getSec(key: F) = this[key]
    fun getFir(key: S) = this.backMap[key]

    constructor(map: Map<F, S>) : this(){
        for (e in map.entries) {
            this[e.key] = e.value
            this.backMap[e.value] = e.key
        }
    }
}