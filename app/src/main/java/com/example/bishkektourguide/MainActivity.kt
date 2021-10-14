package com.example.bishkektourguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBinderMapper
import androidx.databinding.DataBindingUtil
import com.example.bishkektourguide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}