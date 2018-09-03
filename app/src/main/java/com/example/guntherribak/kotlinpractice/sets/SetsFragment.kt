package com.example.guntherribak.kotlinpractice.sets

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guntherribak.kotlinpractice.R
import com.example.guntherribak.kotlinpractice.data.set.SetModel
import com.example.guntherribak.kotlinpractice.framework.BaseFragment
import kotlinx.android.synthetic.main.fragment_sets.*

class SetsFragment : BaseFragment<SetsViewModel>() {

    private lateinit var adapter: SetsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        viewModel.liveData.observe(this, Observer<List<SetModel>> { t -> adapter.updateList(t ?: mutableListOf()) })
        viewModel.load()
    }

    override fun createViewModel(): SetsViewModel {
        return SetsViewModel.getInstance()
    }

    override fun getType(): Class<SetsViewModel> = SetsViewModel::class.java

    fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = SetsAdapter()
        recyclerView.adapter = adapter
    }
}