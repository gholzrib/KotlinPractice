package com.example.guntherribak.kotlinpractice.framework

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.example.guntherribak.kotlinpractice.BR

class BaseHolder<T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }

}