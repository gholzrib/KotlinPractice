package com.example.guntherribak.kotlinpractice.data.set.remote

import android.util.Log
import com.example.guntherribak.kotlinpractice.data.RetrofitClient
import com.example.guntherribak.kotlinpractice.data.set.SetListModel
import com.example.guntherribak.kotlinpractice.data.set.SetsDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SetsRemoteDataSource : SetsDataSource {

    override fun loadSets(callback : SetsDataSource.LoadSetsCallback) {
        RetrofitClient.getInstance()
                .create(SetsApiService::class.java)
                .load()
                .enqueue(object : Callback<SetListModel> {
                    override fun onFailure(call: Call<SetListModel>, t: Throwable) {
                        callback.onDataNotAvailable()
                        Log.d("SET LOAD FAILURE", t.message ?: t.localizedMessage)
                    }

                    override fun onResponse(call: Call<SetListModel>, response: Response<SetListModel>) {
                        if (response.isSuccessful) {
                            val setListModel = response.body()
                            if (setListModel != null && !setListModel.sets.isEmpty()) {
                                callback.onLoadSuccessful(setListModel.sets)
                            }
                        } else {
                            callback.onDataNotAvailable()
                        }
                    }
                })
    }

    companion object {

        private var INSTANCE : SetsRemoteDataSource? = null

        fun getInstance() : SetsRemoteDataSource {
            if (INSTANCE == null) {
                INSTANCE = SetsRemoteDataSource()
            }
            return INSTANCE as SetsRemoteDataSource
        }

        fun destroy() {
            INSTANCE = null
        }

    }
}