package com.example.bishkektourguide

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bishkektourguide.fragments.MallFragment
import com.example.bishkektourguide.fragments.HotelFragment
import com.example.bishkektourguide.fragments.RestoFragment

class PageAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                RestoFragment()
            }
            1 -> {
                HotelFragment()
            }
            2 -> {
                MallFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}