package com.example.foodie2

import Foods
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodie2.databinding.ActivityFinishBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Finish : AppCompatActivity() {

    private lateinit var binding: ActivityFinishBinding
    private lateinit var getPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    private var listOrder = mutableListOf<Foods>()
    private var total = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val type = object : TypeToken<List<Foods>>() {}.type
        val gson = Gson()

        getPreferences = getSharedPreferences("ordered", MODE_PRIVATE)
        edit = getPreferences.edit()
        val str = getPreferences.getString("order", "")

        if (str == "") {
            listOrder = mutableListOf()
        } else {
            listOrder = gson.fromJson(str, type)
        }

        for (i in listOrder) {
            total += i.price
        }
        binding.totalSum.text = "$$total"
        binding.back.setOnClickListener {
            finish()
        }

        listOrder.clear()
        total = 0.0
        val s = gson.toJson(listOrder)
        edit.putString("order", s).apply()

    }
}