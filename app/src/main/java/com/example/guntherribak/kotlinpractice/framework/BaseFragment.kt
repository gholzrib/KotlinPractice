package com.example.guntherribak.kotlinpractice.framework

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragment<T : ViewModel> : Fragment() {

    protected lateinit var viewModel: T

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return createViewModel() as T
            }
        }).get(getType())
    }

    abstract fun createViewModel(): T

    abstract fun getType(): Class<T>
}