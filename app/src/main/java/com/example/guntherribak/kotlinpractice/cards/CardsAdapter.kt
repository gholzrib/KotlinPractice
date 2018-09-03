package com.example.guntherribak.kotlinpractice.cards

import com.example.guntherribak.kotlinpractice.R
import com.example.guntherribak.kotlinpractice.data.card.CardModel
import com.example.guntherribak.kotlinpractice.framework.BaseAdapter

class CardsAdapter(cardsList: MutableList<CardModel>) : BaseAdapter<CardModel>(cardsList) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.adapter_cards
    }
}