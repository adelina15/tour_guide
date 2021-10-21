package com.example.bishkektourguide.resto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bishkektourguide.R
import com.example.bishkektourguide.databinding.FragmentRestoBinding

class RestoFragment : Fragment() {
    lateinit var binding: FragmentRestoBinding
    private val adapter = ItemAdapter()
    private val itemIdList = listOf(
        R.drawable.frunze,
        R.drawable.versal,
        R.drawable.most,
        R.drawable.alatoo
    )
    private val itemNameList = listOf("Frunze", "Versal", "The Most", "Ala Too")
    private val itemNumberList = listOf("+996 551 66-44-66", "+996 555‒55‒55‒08", "+996 772‒00‒05‒13", "+996 701‒54‒33‒33")
    private val itemLocationNameList = listOf("Абдумомунова, 220а", "", "", "")
    private val itemLocationList = listOf("42.8789642, 74.6058589", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_resto, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.apply {
            rcView.adapter = adapter
            rcView.layoutManager = LinearLayoutManager(activity)

            val rest = Items(itemIdList[0], itemNameList[0], itemNumberList[0], itemLocationNameList[0], itemLocationList[0])
            adapter.addItems(rest)
            val rest1 = Items(itemIdList[1], itemNameList[1], itemNumberList[1], itemLocationNameList[1], itemLocationList[1])
            adapter.addItems(rest1)
            val rest2 = Items(itemIdList[2], itemNameList[2], itemNumberList[2], itemLocationNameList[2], itemLocationList[2])
            adapter.addItems(rest2)
            val rest3 = Items(itemIdList[3], itemNameList[3], itemNumberList[3], itemLocationNameList[3], itemLocationList[3])
            adapter.addItems(rest3)
        }
    }

}
