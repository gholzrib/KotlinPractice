package com.example.guntherribak.kotlinpractice.sets

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.guntherribak.kotlinpractice.data.set.SetModel
import com.example.guntherribak.kotlinpractice.data.set.remote.SetsApiService
import com.example.guntherribak.kotlinpractice.data.set.remote.SetsPagingRemoteDataSourceFactory

class SetsViewModel : ViewModel() {

    var liveData: MediatorLiveData<PagedList<SetModel>> = MediatorLiveData()

    fun fetchSets() {
        liveData.addSource(createSetsPagedList()) {
            liveData.value = it
        }
    }

    fun createSetsPagedList() = LivePagedListBuilder<Int, SetModel>(
            SetsPagingRemoteDataSourceFactory(),
            PagedList.Config.Builder()
                    .setPageSize(SetsApiService.PAGE_SIZE)
                    .setEnablePlaceholders(false)
                    .build()
    ).build()

    companion object {

        var INSTANCE: SetsViewModel? = null

        fun getInstance(): SetsViewModel {
            if (INSTANCE == null) {
                INSTANCE = SetsViewModel()
            }
            return INSTANCE!!
        }

        fun destroy() {
            INSTANCE = null
        }

    }

}