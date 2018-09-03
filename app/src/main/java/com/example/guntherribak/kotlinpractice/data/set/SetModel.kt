package com.example.guntherribak.kotlinpractice.data.set

import android.databinding.BindingAdapter
import android.widget.TextView

data class SetModel(val code: String,
                    val name: String,
                    val type: String,
                    val releaseDate: String) {
    companion object {

        @JvmStatic
        @BindingAdapter("code", "name")
        fun codeAndName(view: TextView, code: String, name: String) {
            val codeAndName = "($code) $name"
            view.text = codeAndName
        }

    }
}