package com.example.guntherribak.kotlinpractice.data.card.remote

import com.example.guntherribak.kotlinpractice.data.card.CardListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CardsApiService {

    @GET("cards")
    fun get(): Call<CardListModel>

}