package com.example.guntherribak.kotlinpractice.data.card.remote

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.example.guntherribak.kotlinpractice.data.card.CardModel

class CardsPagingRemoteDataSourceFactory : DataSource.Factory<Int, CardModel>() {

    private val mutableLiveData = MutableLiveData<CardsPagingRemoteDataSource>()

    override fun create(): DataSource<Int, CardModel> {
        return CardsPagingRemoteDataSource().also {
            mutableLiveData.postValue(it)
        }
    }
}