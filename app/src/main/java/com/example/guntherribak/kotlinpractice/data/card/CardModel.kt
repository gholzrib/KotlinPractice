package com.example.guntherribak.kotlinpractice.data.card

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Explanation about it field can be found at https://docs.magicthegathering.io/#api_v1cards_list
 */
data class CardModel(val id: String, val name: String,
                     val names: List<String>,
                     val manaCost: String,
                     val cmc: Double,
                     val colors: List<String>,
                     val colorIdentity: List<String>,
                     val type: String,
                     val supertypes: List<String>,
                     val types: List<String>,
                     val subtypes: List<String>,
                     val rarity: String,
                     val set: String,
                     val text: String,
                     val artist: String,
                     val number: String,
                     val power: String,
                     val toughness: String,
                     val imageUrl: String) {

    companion object {

        @JvmStatic
        @BindingAdapter("joinText")
        fun joinText(view: TextView, list: List<String>?) {
            view.text = list?.joinToString() ?: "-"
        }

        @JvmStatic
        @BindingAdapter("loadImageURL")
        fun loadImageURL(view: ImageView, url: String) {
            /*Picasso.get()
                    .load(url)
                    .placeholder(R.color.colorAccent)
                    .error(R.color.colorPrimaryDark)
                    .into(view)*/
        }
    }
}