package com.example.guntherribak.kotlinpractice.data.set

interface SetsDataSource {

    interface LoadSetsCallback {
        fun onLoadSuccessful(setsList: List<SetModel>)
        fun onDataNotAvailable()
    }

    fun loadSets(callback: LoadSetsCallback)

}