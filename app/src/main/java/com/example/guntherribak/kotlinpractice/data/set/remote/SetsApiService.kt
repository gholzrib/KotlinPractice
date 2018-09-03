package com.example.guntherribak.kotlinpractice.data.set.remote

import com.example.guntherribak.kotlinpractice.data.set.SetListModel
import retrofit2.Call
import retrofit2.http.GET

interface SetsApiService {
    @GET("sets")
    fun load() : Call<SetListModel>
}