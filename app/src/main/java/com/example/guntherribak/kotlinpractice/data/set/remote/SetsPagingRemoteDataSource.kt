package com.example.guntherribak.kotlinpractice.data.set.remote

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.example.guntherribak.kotlinpractice.data.RetrofitClient
import com.example.guntherribak.kotlinpractice.data.set.SetListModel
import com.example.guntherribak.kotlinpractice.data.set.SetModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SetsPagingRemoteDataSource : PageKeyedDataSource<Int, SetModel>() {

    companion object {
        const val FIRST_PAGE = 1
        const val MAX_PAGES = 100
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, SetModel>) {
        val page = FIRST_PAGE
        loadSets(page) { sets ->
            Log.d("PAGING", "loadInitial, page $page")
            val adjacentPage = if (page < MAX_PAGES) page + 1 else null
            callback.onResult(sets, null, adjacentPage)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, SetModel>) {
        val page = params.key
        loadSets(page) { sets ->
            Log.d("PAGING", "loadAfter, page $page")
            val adjacentPage = if (page < MAX_PAGES) page + 1 else null
            callback.onResult(sets, adjacentPage)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, SetModel>) {
        val page = params.key
        loadSets(page) { sets ->
            Log.d("PAGING", "loadBefore, page $page")
            val adjacentPage = if (page > FIRST_PAGE) page - 1 else null
            callback.onResult(sets, adjacentPage)
        }
    }

    fun loadSets(page: Int, success: (List<SetModel>) -> Unit) {
        RetrofitClient.getInstance()
                .create(SetsApiService::class.java)
                .load(page)
                .enqueue(object : Callback<SetListModel> {
                    override fun onFailure(call: Call<SetListModel>, t: Throwable) {
                        Log.d("SET LOAD FAILURE", t.message ?: t.localizedMessage)
                    }

                    override fun onResponse(call: Call<SetListModel>, response: Response<SetListModel>) {
                        if (response.isSuccessful) {
                            val setListModel = response.body()
                            if (setListModel != null && !setListModel.sets.isEmpty()) {
                                success(setListModel.sets)
                            }
                        }
                    }
                })
    }
}