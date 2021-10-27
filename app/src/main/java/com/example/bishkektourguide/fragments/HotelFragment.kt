package com.example.bishkektourguide.fragments

import com.example.bishkektourguide.items.ItemAdapter
import com.example.bishkektourguide.items.Items
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bishkektourguide.R
import com.example.bishkektourguide.databinding.FragmentHotelBinding
import com.example.bishkektourguide.delegates.RecyclerLocationClick
import com.example.bishkektourguide.delegates.RecyclerNumberClick

class HotelFragment : Fragment(), RecyclerLocationClick, RecyclerNumberClick {
    lateinit var binding: FragmentHotelBinding
    private val adapter by lazy { ItemAdapter(requireContext(), this, this) }
    private val imageList by lazy{
        mutableListOf(R.drawable.hyatt, R.drawable.jannat, R.drawable.novotel, R.drawable.rixon)
    }
    private val itemList by lazy {
        mutableListOf(
            Items(getString(R.string.hyatt_description),
                getString(R.string.hyatt),
                getString(R.string.hyatt_number),
                getString(R.string.hyatt_location),
                getString(R.string.hyatt_map)),
            Items(getString(R.string.jannat_description),
                getString(R.string.jannat),
                getString(R.string.jannat_number),
                getString(R.string.jannat_location),
                getString(R.string.jannat_map)),
            Items(getString(R.string.novotel_description),
                getString(R.string.novotel),
                getString(R.string.novotel_number),
                getString(R.string.novotel_location),
                getString(R.string.novotel_map)),
            Items(getString(R.string.rixon_description),
                getString(R.string.rixon),
                getString(R.string.rixon_number),
                getString(R.string.rixon_location),
                getString(R.string.rixon_map)))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hotel, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.apply {
            rcView.adapter = adapter
            rcView.layoutManager = LinearLayoutManager(requireContext())
        }
        adapter.setList(itemList)
        adapter.setImageList(imageList)
    }

    override fun recyclerLocationClicked(item: Items) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.location))
        startActivity(intent)
    }

    override fun recyclerNumberClicked(item: Items) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${item.phone_number}"))
        startActivity(intent)
    }
}
