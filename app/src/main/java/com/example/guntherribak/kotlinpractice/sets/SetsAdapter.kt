package com.example.guntherribak.kotlinpractice.sets

import android.support.v7.util.DiffUtil
import com.example.guntherribak.kotlinpractice.R
import com.example.guntherribak.kotlinpractice.data.set.SetModel
import com.example.guntherribak.kotlinpractice.framework.BaseAdapter

class SetsAdapter : BaseAdapter<SetModel>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SetModel>() {
            override fun areItemsTheSame(p0: SetModel, p1: SetModel): Boolean {
                return p0.code == p1.code
            }

            override fun areContentsTheSame(p0: SetModel, p1: SetModel): Boolean {
                return p0 == p1
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.adapter_set
    }
}