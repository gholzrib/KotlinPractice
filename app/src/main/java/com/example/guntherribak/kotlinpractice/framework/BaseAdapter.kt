package com.example.guntherribak.kotlinpractice.framework

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>)
    : PagedListAdapter<T, BaseHolder<T>>(diffCallback) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseHolder<T> {
        val inflater = LayoutInflater.from(p0.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, getItemViewType(p1), p0, false)
        return BaseHolder(binding)
    }

    override fun onBindViewHolder(p0: BaseHolder<T>, p1: Int) = p0.bind(getItem(p1)!!)
}