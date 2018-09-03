package com.example.guntherribak.kotlinpractice.framework

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseAdapter<T>(private var list: MutableList<T>) : RecyclerView.Adapter<BaseHolder<T>>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseHolder<T> {
        val inflater = LayoutInflater.from(p0.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, getItemViewType(p1), p0, false)
        return BaseHolder(binding)
    }

    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(p0: BaseHolder<T>, p1: Int) = p0.bind(list[p1])

    fun updateList(newList: List<T>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

}