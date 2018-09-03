package com.example.guntherribak.kotlinpractice.data.set

import com.example.guntherribak.kotlinpractice.data.set.remote.SetsRemoteDataSource

class SetsRepository(private val remoteDataSource: SetsRemoteDataSource) {

    fun loadSets(callback : SetsDataSource.LoadSetsCallback) {
        checkNotNull(callback)
        remoteDataSource.loadSets(callback)
    }

    companion object {

        var INSTANCE : SetsRepository? = null

        fun getInstance() : SetsRepository {
            if (INSTANCE == null) {
                INSTANCE = SetsRepository(SetsRemoteDataSource.getInstance())
            }
            return INSTANCE!!
        }

        fun destroy() {
            INSTANCE = null
        }

    }

}