package com.example.guntherribak.kotlinpractice.data.set.remote

import com.example.guntherribak.kotlinpractice.data.set.SetListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SetsApiService {

    companion object {
        const val PAGE_SIZE = 10
    }

    @GET("sets")
    fun load(@Query("page") page: Int,
             @Query("pageSize") pageSize: Int = PAGE_SIZE): Call<SetListModel>
}