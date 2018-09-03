package com.example.guntherribak.kotlinpractice.data.card.remote

import android.util.Log
import com.example.guntherribak.kotlinpractice.data.RetrofitClient
import com.example.guntherribak.kotlinpractice.data.card.CardListModel
import com.example.guntherribak.kotlinpractice.data.card.CardsDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardsRemoteDataSource : CardsDataSource {

    override fun getCards(callback: CardsDataSource.OnCardsLoadedCallback) {
        RetrofitClient.getInstance()
                .create(CardsApiService::class.java)
                .get()
                .enqueue(object : Callback<CardListModel> {
                    override fun onFailure(call: Call<CardListModel>, t: Throwable) {
                        Log.d("EXCEPTION", t.message ?: t.localizedMessage)
                        callback.onDataNotAvailable()
                    }

                    override fun onResponse(call: Call<CardListModel>, response: Response<CardListModel>) {
                        val cardsList = response.body()
                        if (cardsList != null && !cardsList.cards.isEmpty()) {
                            callback.onCardsLoaded(cardsList.cards)
                        } else {
                            callback.onDataNotAvailable()
                        }
                    }
                })
    }

    companion object {
        private var INSTANCE: CardsRemoteDataSource? = null
        fun getInstance(): CardsRemoteDataSource {
            if (INSTANCE == null) {
                INSTANCE = CardsRemoteDataSource()
            }
            return INSTANCE as CardsRemoteDataSource
        }
    }
}
