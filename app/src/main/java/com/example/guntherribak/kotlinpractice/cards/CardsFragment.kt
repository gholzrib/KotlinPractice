package com.example.guntherribak.kotlinpractice.cards


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guntherribak.kotlinpractice.databinding.FragmentCardsBinding
import com.example.guntherribak.kotlinpractice.framework.BaseFragment
import kotlinx.android.synthetic.main.fragment_cards.*

class CardsFragment : BaseFragment<CardsViewModel>() {

    private lateinit var adapter: CardsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentCardsBinding = FragmentCardsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun createViewModel(): CardsViewModel {
        return CardsViewModel.getInstance()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        viewModel.liveData.observe(
                viewLifecycleOwner,
                Observer(adapter::submitList))
        viewModel.fetchCards()
    }

    override fun getType(): Class<CardsViewModel> {
        return CardsViewModel::class.java
    }

    fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = CardsAdapter()
        recyclerView.adapter = adapter
    }
}