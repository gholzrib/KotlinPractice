package com.example.guntherribak.kotlinpractice.data.card

interface CardsDataSource {

    interface OnCardsLoadedCallback {
        fun onCardsLoaded(cards: List<CardModel>)
        fun onDataNotAvailable()
    }

    fun getCards(callback: OnCardsLoadedCallback)

}