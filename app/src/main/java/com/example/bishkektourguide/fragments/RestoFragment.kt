package com.example.bishkektourguide.fragments

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
import com.example.bishkektourguide.databinding.FragmentRestoBinding
import com.example.bishkektourguide.delegates.RecyclerLocationClick
import com.example.bishkektourguide.delegates.RecyclerNumberClick
import com.example.bishkektourguide.items.ItemAdapter
import com.example.bishkektourguide.items.Items

class RestoFragment : Fragment(), RecyclerLocationClick, RecyclerNumberClick {
    lateinit var binding: FragmentRestoBinding
    private val adapter by lazy { ItemAdapter(requireContext(), this, this) }
    private val imageList by lazy{
    mutableListOf(R.drawable.frunze, R.drawable.pishpek, R.drawable.most, R.drawable.alatoo,)
}
    private val itemList by lazy {
        mutableListOf(
            Items(getString(R.string.frunze_description),
                getString(R.string.frunze),
                getString(R.string.frunze_number),
                getString(R.string.frunze_location),
                getString(R.string.frunze_map)),
            Items(getString(R.string.pishpek_description),
                getString(R.string.pishpek),
                getString(R.string.pishpek_number),
                getString(R.string.pishpek_location),
                getString(R.string.pishpek_map)),
            Items(getString(R.string.most_description),
                getString(R.string.most),
                getString(R.string.most_number),
                getString(R.string.most_location),
                getString(R.string.most_map)),
            Items(getString(R.string.alatoo_description),
                getString(R.string.alatoo),
                getString(R.string.alatoo_number),
                getString(R.string.alatoo_location),
                getString(R.string.alatoo_map)))
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
