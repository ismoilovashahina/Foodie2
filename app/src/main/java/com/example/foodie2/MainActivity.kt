package com.example.foodie2

import Category
import Foods
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodie2.R
import com.example.foodie2.databinding.ActivityMainBinding
import com.example.foodie2.adapter.Adapter
import com.example.foodie2.adapter.TypeFoodAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var list = mutableListOf<Foods>()
    private lateinit var types: MutableMap<String, MutableList<Category>>
    private val type = "type"

    private lateinit var adapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadRec()
        loadData()

        val adapterEx = TypeFoodAdapter(this, types, type)
        binding.expandable.setAdapter(adapterEx)
        binding.expandable.setOnChildClickListener { _, _, _, i2, _ ->
            val category = types[type]!![i2]
            if (category.tag == 1) {
                val intent = Intent(this, ExtendedAllFoods::class.java)
                intent.putExtra("tag", 1)
                startActivity(intent)
            }
            if (category.tag == 2) {
                val intent = Intent(this, ExtendedAllFoods::class.java)
                intent.putExtra("tag", 2)
                startActivity(intent)
            }
            if (category.tag == 3) {
                val intent = Intent(this, ExtendedAllFoods::class.java)
                intent.putExtra("tag", 3)
                startActivity(intent)
            }
            true
        }

        adapter = Adapter(this,list)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.search.addTextChangedListener {
            val filter = mutableListOf<Foods>()
            if (it != null) {
                val fav = list
                for (c in fav) {
                    if (c.title.lowercase().contains(it.toString().lowercase())) {
                        filter.add(c)
                    }
                }
                adapter = Adapter(this, filter)
                binding.recyclerView.adapter = adapter
            }
        }


        adapter.setOnClickListener(object : Adapter.OnClickListener{
            override fun onItemClick(position: Int, food: Foods) {
                val intent = Intent(this@MainActivity, FoodInfo::class.java)
                val foodPrice = food.price.toString().toDouble()*food.quantity.toDouble()
                intent.putExtra("food", food)
                intent.putExtra("food_price", foodPrice.toString())
                startActivity(intent)
            }
        })

        binding.cart.setOnClickListener {
            val intent = Intent(this, Orders::class.java)
            startActivity(intent)
        }
    }

    private fun loadData() {
        types = mutableMapOf()

        val choose = mutableListOf<Category>()
        choose.add(Category(R.drawable.burgers, 1, "Burgers"))
        choose.add(Category(R.drawable.drinks, 2, "Drinks"))
        choose.add(Category(R.drawable.desserts, 3, "Desserts"))

        types.put(type, choose)
    }

    private fun loadRec() {
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/246/593/png-transparent-doughnut-illustration-dunkin-donuts-beer-dr-mumojo-donut-orange-eating-spain-thumbnail.png",
                2.3,
                "Donat",
                0
            )
        )
        list.add(
            Foods(
                "https://e7.pngegg.com/pngimages/95/482/png-clipart-mcdonald-s-quarter-pounder-cheeseburger-hamburger-restaurant-mcdonalds.png",
                4.4,
                "Cheese Burger",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/728/915/png-transparent-mineral-water-bottles-mineral-water-bottles-mineral-water-pure-water-thumbnail.png",
                .5,
                "Mineral Water",
                0
            )
        )
        list.add(
            Foods(
                "https://somebodyfeedseb.com/wp-content/uploads/2022/04/2021.03.06-Fish-Burger-2044.jpg",
                5.2,
                "Fish Burger",
                0
            )
        )
    }

}
