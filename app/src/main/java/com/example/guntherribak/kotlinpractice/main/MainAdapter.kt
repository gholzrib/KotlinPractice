package com.example.guntherribak.kotlinpractice.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.guntherribak.kotlinpractice.cards.CardsFragment
import com.example.guntherribak.kotlinpractice.sets.SetsFragment

class MainAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment {
        return when (p0) {
            0 -> CardsFragment()
            else -> SetsFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Cards"
            else -> "Sets"
        }
    }
}