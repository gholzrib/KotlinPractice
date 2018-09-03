package com.example.guntherribak.kotlinpractice.data.card

import com.example.guntherribak.kotlinpractice.data.card.remote.CardsRemoteDataSource

class CardsRepository private constructor(cardsRemoteDataSource: CardsRemoteDataSource) : CardsDataSource {

    private val mCardsRemoteDataSource: CardsRemoteDataSource

    init {
        mCardsRemoteDataSource = checkNotNull(cardsRemoteDataSource)
    }

    override fun getCards(callback: CardsDataSource.OnCardsLoadedCallback) {
        checkNotNull(callback)
        mCardsRemoteDataSource.getCards(callback)
    }

    companion object {

        private var INSTANCE: CardsRepository? = null

        fun getInstance(cardsRemoteDataSource: CardsRemoteDataSource): CardsRepository {
            if (INSTANCE == null) {
                INSTANCE = CardsRepository(cardsRemoteDataSource)
            }
            return INSTANCE as CardsRepository
        }

        fun destroy() {
            INSTANCE = null
        }
    }
}