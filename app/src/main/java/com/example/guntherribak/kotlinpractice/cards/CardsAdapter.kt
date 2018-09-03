package com.example.guntherribak.kotlinpractice.cards

import android.support.v7.util.DiffUtil
import com.example.guntherribak.kotlinpractice.R
import com.example.guntherribak.kotlinpractice.data.card.CardModel
import com.example.guntherribak.kotlinpractice.framework.BaseAdapter

class CardsAdapter : BaseAdapter<CardModel>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CardModel>() {
            override fun areItemsTheSame(p0: CardModel, p1: CardModel): Boolean {
                return p0.id == p1.id
            }

            override fun areContentsTheSame(p0: CardModel, p1: CardModel): Boolean {
                return p0 == p1
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.adapter_cards
    }
}