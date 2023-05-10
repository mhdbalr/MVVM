package com.example.ch6top1.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch6top1.databinding.ActivityMainBinding
import com.example.ch6top1.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataUser()
    }
    @SuppressLint("SuspiciousIndentation")
    fun getDataUser() {
        val viewModelNewas = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModelNewas.getData()
        viewModelNewas.liveDataUser.observe(this, Observer {
            if(it != null)
                binding.rvHome.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvHome.adapter = UserAdapter(it)

        })
    }
}