package com.example.guntherribak.kotlinpractice.cards

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.guntherribak.kotlinpractice.data.card.CardModel
import com.example.guntherribak.kotlinpractice.data.card.CardsDataSource
import com.example.guntherribak.kotlinpractice.data.card.CardsRepository
import com.example.guntherribak.kotlinpractice.data.card.remote.CardsRemoteDataSource

class CardsViewModel(private val repository: CardsRepository) : ViewModel() {

    var liveData: MutableLiveData<List<CardModel>> = MutableLiveData()

    fun loadCards() {
        repository.getCards(object : CardsDataSource.OnCardsLoadedCallback {
            override fun onCardsLoaded(cards: List<CardModel>) {
                liveData.value = cards
            }

            override fun onDataNotAvailable() {
                liveData.value = mutableListOf()
            }
        })
    }

    companion object {

        private var INSTANCE: CardsViewModel? = null

        fun getInstance(): CardsViewModel {
            if (INSTANCE == null) {
                INSTANCE = CardsViewModel(CardsRepository.getInstance(CardsRemoteDataSource.getInstance()))
            }
            return INSTANCE as CardsViewModel
        }

        fun destroy() {
            INSTANCE = null
        }
    }
}