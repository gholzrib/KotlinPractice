package com.example.guntherribak.kotlinpractice.data.set.remote

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.example.guntherribak.kotlinpractice.data.set.SetModel

class SetsPagingRemoteDataSourceFactory : DataSource.Factory<Int, SetModel>() {

    private val mutableLiveData = MutableLiveData<SetsPagingRemoteDataSource>()

    override fun create(): DataSource<Int, SetModel> {
        return SetsPagingRemoteDataSource().also { mutableLiveData.postValue(it) }
    }
}