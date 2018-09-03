package com.example.guntherribak.kotlinpractice.data.card.remote

import com.example.guntherribak.kotlinpractice.data.card.CardListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CardsApiService {

    companion object {
        const val PAGE_SIZE = 10
    }

    @GET("cards")
    fun get(@Query("page") page: Int,
            @Query("pageSize") pageSize: Int = PAGE_SIZE): Call<CardListModel>

}