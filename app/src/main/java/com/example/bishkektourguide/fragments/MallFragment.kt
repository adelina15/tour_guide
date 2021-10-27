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
import com.example.bishkektourguide.databinding.FragmentMallBinding
import com.example.bishkektourguide.delegates.RecyclerLocationClick
import com.example.bishkektourguide.delegates.RecyclerNumberClick

class MallFragment : Fragment(), RecyclerLocationClick, RecyclerNumberClick {
    lateinit var binding: FragmentMallBinding
    private val adapter by lazy { ItemAdapter(requireContext(), this, this) }
    private val imageList by lazy{
        mutableListOf(R.drawable.asia_mall, R.drawable.bishkek_park, R.drawable.dordoi_plaza, R.drawable.tommi_mall)
    }
    private val itemList by lazy {
        mutableListOf(
            Items(getString(R.string.asia_mall_description),
                getString(R.string.asia_mall),
                getString(R.string.asia_mall_number),
                getString(R.string.asia_mall_location),
                getString(R.string.asia_mall_map)),
            Items(getString(R.string.bishkek_park_description),
                getString(R.string.bishkek_park),
                getString(R.string.bishkek_park_number),
                getString(R.string.bishkek_park_location),
                getString(R.string.bishkek_park_map)),
            Items(getString(R.string.dordoi_plaza_description),
                getString(R.string.dordoi_plaza),
                getString(R.string.dordoi_plaza_number),
                getString(R.string.dordoi_plaza_location),
                getString(R.string.dordoi_plaza_map)),
            Items(getString(R.string.tommi_mall_description),
                getString(R.string.tommi_mall),
                getString(R.string.tommi_mall_number),
                getString(R.string.tommi_mall_location),
                getString(R.string.tommi_mall_map)))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mall, container, false)
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
