package com.example.bishkektourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.bishkektourguide.databinding.FragmentListBinding
import com.google.android.material.tabs.TabLayoutMediator


class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        val adapter = PageAdapter(this)
        val viewPager = binding.viewPager2
        val tabLayout = binding.tabLayout

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            when(position){
                0 -> {
                    tab.text = "Restaurants"
                }
                1 -> {
                    tab.text = "Parks"
                }
                2 -> {
                    tab.text = "Malls"
                }
            }
        }.attach()

        // Inflate the layout for this fragment
        return binding.root
    }

}