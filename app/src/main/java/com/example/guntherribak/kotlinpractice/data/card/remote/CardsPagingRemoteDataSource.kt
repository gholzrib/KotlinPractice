package com.example.guntherribak.kotlinpractice.data.card.remote

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.example.guntherribak.kotlinpractice.data.RetrofitClient
import com.example.guntherribak.kotlinpractice.data.card.CardListModel
import com.example.guntherribak.kotlinpractice.data.card.CardModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardsPagingRemoteDataSource : PageKeyedDataSource<Int, CardModel>() {

    companion object {
        val FIRST_PAGE = 1
        val MAX_PAGES = 100 //Since the API doesn't return the total of pages, a MAX_PAGES is set
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, CardModel>) {
        val page = FIRST_PAGE
        getCards(page) { cards ->
            Log.d("PAGING", "loadInitial, page $page")
            val adjacentPage = if (page < MAX_PAGES) page + 1 else null
            callback.onResult(cards, null, adjacentPage)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CardModel>) {
        val page = params.key
        getCards(page) { cards ->
            Log.d("PAGING", "loadAfter, page $page")
            val adjacentPage = if (page < MAX_PAGES) page + 1 else null
            callback.onResult(cards, adjacentPage)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CardModel>) {
        val page = params.key
        getCards(page) { cards ->
            Log.d("PAGING", "loadBefore")
            val adjacentPage = if (page > FIRST_PAGE) page - 1 else null
            callback.onResult(cards, adjacentPage)
        }
    }

    fun getCards(page: Int, success: (List<CardModel>) -> Unit) {
        RetrofitClient.getInstance()
                .create(CardsApiService::class.java)
                .get(page)
                .enqueue(object : Callback<CardListModel> {
                    override fun onFailure(call: Call<CardListModel>, t: Throwable) {
                        Log.d("EXCEPTION", t.message ?: t.localizedMessage)
                    }

                    override fun onResponse(call: Call<CardListModel>, response: Response<CardListModel>) {
                        val cards = response.body()?.cards
                        if (cards != null) {
                            success(cards)
                        }
                    }
                })
    }
}