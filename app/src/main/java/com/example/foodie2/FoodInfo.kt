package com.example.foodie2

import Foods
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.foodie2.R
import com.example.foodie2.databinding.ActivityFoodInfoBinding

class FoodInfo : AppCompatActivity() {
    private lateinit var binding: ActivityFoodInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foods = intent.getSerializableExtra("food") as Foods

        binding.img.load(foods.img){
            placeholder(R.drawable.ic_launcher_background)
        }
        binding.name.text = foods.title
        binding.price.text = intent.getStringExtra("food_price")

        binding.addToCart.setOnClickListener {
            val intent = Intent(this, Orders::class.java)
            intent.putExtra("food", foods)
            startActivity(intent)
        }

        binding.back.setOnClickListener {
            finish()
        }

    }
}