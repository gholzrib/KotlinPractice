package com.example.guntherribak.kotlinpractice.cards

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.guntherribak.kotlinpractice.data.card.CardModel
import com.example.guntherribak.kotlinpractice.data.card.remote.CardsApiService
import com.example.guntherribak.kotlinpractice.data.card.remote.CardsPagingRemoteDataSourceFactory

class CardsViewModel : ViewModel() {

    var liveData: MediatorLiveData<PagedList<CardModel>> = MediatorLiveData()

    fun createCardsPagedList() = LivePagedListBuilder<Int, CardModel>(
            CardsPagingRemoteDataSourceFactory(),
            PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(CardsApiService.PAGE_SIZE)
                    .build()
    ).build()

    fun fetchCards() {
        liveData.addSource(createCardsPagedList()) {
            liveData.value = it
        }
    }

    companion object {

        private var INSTANCE: CardsViewModel? = null

        fun getInstance(): CardsViewModel {
            if (INSTANCE == null) {
                INSTANCE = CardsViewModel()
            }
            return INSTANCE!!
        }

        fun destroy() {
            INSTANCE = null
        }
    }
}