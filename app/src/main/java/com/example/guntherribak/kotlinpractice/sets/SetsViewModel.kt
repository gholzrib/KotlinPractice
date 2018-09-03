package com.example.guntherribak.kotlinpractice.sets

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.guntherribak.kotlinpractice.data.set.SetModel
import com.example.guntherribak.kotlinpractice.data.set.SetsDataSource
import com.example.guntherribak.kotlinpractice.data.set.SetsRepository

class SetsViewModel(private val repository: SetsRepository) : ViewModel() {

    var liveData : MutableLiveData<List<SetModel>> = MutableLiveData()

    fun load() {
        repository.loadSets(object : SetsDataSource.LoadSetsCallback {
            override fun onLoadSuccessful(setsList: List<SetModel>) {
                liveData.value = setsList
            }

            override fun onDataNotAvailable() {
                liveData.value = mutableListOf()
            }
        })
    }

    companion object {

        var INSTANCE : SetsViewModel? = null

        fun getInstance() : SetsViewModel {
            if (INSTANCE == null) {
                INSTANCE = SetsViewModel(SetsRepository.getInstance())
            }
            return INSTANCE as SetsViewModel
        }

        fun destroy() {
            INSTANCE = null
        }

    }

}