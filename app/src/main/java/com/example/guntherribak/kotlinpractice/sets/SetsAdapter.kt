package com.example.guntherribak.kotlinpractice.sets

import com.example.guntherribak.kotlinpractice.R
import com.example.guntherribak.kotlinpractice.data.set.SetModel
import com.example.guntherribak.kotlinpractice.framework.BaseAdapter

class SetsAdapter(setsList : MutableList<SetModel> = mutableListOf()) : BaseAdapter<SetModel>(setsList) {

    override fun getItemViewType(position: Int): Int {
        return R.layout.adapter_set
    }
}