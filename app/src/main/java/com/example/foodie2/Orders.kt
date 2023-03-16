package com.example.foodie2

import Foods
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodie2.adapter.Adapter
import com.example.foodie2.databinding.ActivityOrdersBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Orders : AppCompatActivity() {
    private lateinit var binding: ActivityOrdersBinding
    private var listOrder = mutableListOf<Foods>()
    private var oldList = mutableListOf<Foods>()
    private var total = 0.0
    private lateinit var getPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersBinding.inflate(layoutInflater)
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
        if (intent.getSerializableExtra("food") != null) {
            val foods = intent.getSerializableExtra("food") as Foods
            oldList.add(foods)
        }

        listOrder.addAll(oldList)


        var adapter = Adapter(this, listOrder)
        binding.recyclerView.adapter = adapter

        for (i in listOrder) {
            total += i.price*i.quantity.toDouble()
        }
        binding.overallPrice.text = total.toString()

        binding.goFinish.isEnabled = false
        if (total > 0) {
            binding.goFinish.isEnabled = true
            binding.goFinish.setOnClickListener {
                val intent = Intent(this, Finish::class.java)
                startActivity(intent)
                finish()
            }
        }
        binding.back.setOnClickListener {
            finish()
        }
        binding.clearAllTv.setOnClickListener {
            listOrder.clear()
            total = 0.0
            binding.overallPrice.text = total.toString()
            adapter = Adapter(this, listOrder)
            binding.recyclerView.adapter = adapter
            val s = gson.toJson(listOrder)
            edit.putString("order", s).apply()
        }
        val s = gson.toJson(listOrder)
        edit.putString("order", s).apply()
    }
}

