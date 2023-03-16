package com.example.foodie2

import Foods
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.foodie2.FoodInfo
import com.example.foodie2.adapter.Adapter
import com.example.foodie2.databinding.ActivityExtendedAllFoodsBinding

class ExtendedAllFoods : AppCompatActivity() {
    private lateinit var binding: ActivityExtendedAllFoodsBinding
    private var list = mutableListOf<Foods>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtendedAllFoodsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tag = intent.getIntExtra("tag", 1)
        if (tag == 1) {
            loadBurgers()
        }
        if (tag == 2) {
            loadDrinks()
        }
        if (tag == 3) {
            loadDesserts()
        }

        val adapter = Adapter(this, list)
        binding.recyclerView.adapter = adapter

        adapter.setOnClickListener(object : Adapter.OnClickListener{
            override fun onItemClick(position: Int, food: Foods) {
                val intentE = Intent(this@ExtendedAllFoods, FoodInfo::class.java)

                intentE.putExtra("food", food)
                startActivity(intentE)
            }
        })
    }

    private fun loadDesserts() {
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/246/593/png-transparent-doughnut-illustration-dunkin-donuts-beer-dr-mumojo-donut-orange-eating-spain-thumbnail.png",
                2.3,
                "Donut",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/394/505/png-transparent-ice-cream-cones-sundae-strawberry-ice-cream-ice-cream-cream-food-baking-thumbnail.png",
                1.3,
                "Ice Cream",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/281/16/png-transparent-cupcake-illustration-cupcake-birthday-cake-chocolate-cake-icing-cup-cake-cream-food-baking-thumbnail.png",
                2.5,
                "CupCake",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/414/300/png-transparent-cinnamon-roll-danish-pastry-pain-au-chocolat-viennoiserie-sticky-bun-cinnamon-baked-goods-food-baking-thumbnail.png",
                2.3,
                "Cinnamon Roll",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/351/8/png-transparent-macaroons-macaron-macaroon-food-astrology-astrological-sign-macarons-miscellaneous-eating-sign-thumbnail.png",
                2.0,
                "Macaroons",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/479/928/png-transparent-chocolate-pudding-churro-chocolate-syrup-dipping-sauce-chocolate-thumbnail.png",
                1.8,
                "Churros",
                0
            )
        )
    }

    private fun loadDrinks() {
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/574/913/png-transparent-coca-cola-coca-cola-bottle-glass-bottles.png",
                1.2,
                "Cola",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/595/617/png-transparent-blue-pepsi-can-pepsi-soft-drink-coca-cola-beer-pepsi-blue-food-electric-blue-thumbnail.png",
                0.9,
                "Pepsi",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/216/501/png-transparent-fizzy-drinks-fanta-orange-soft-drink-carbonated-water-fanta-orange-orange-drink-juice-thumbnail.png",
                0.8,
                "Fanta",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/577/700/png-transparent-sprite-plastic-bottle-soft-drink-sprite-bottle-bottle-of-sprite-plastic-bottle-summer-alcohol-bottle-thumbnail.png",
                .7,
                "Sprite",
                0
            )
        )
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/713/271/png-transparent-clear-tea-cup-with-orange-slice-green-tea-coffee-iced-tea-lemon-tea-tea-teacup-herbal-tea-thumbnail.png",
                .6,
                "Lemon Tea",
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

    }

    private fun loadBurgers() {
        list.add(
            Foods(
                "https://w7.pngwing.com/pngs/567/571/png-transparent-hamburger-cheeseburger-hot-dog-veggie-burger-cartoon-junk-food-food-tomato-cheeseburger.png",
                5.0,
                "Hamburger",
                0
            )
        )
        list.add(
            Foods(
                "https://assets.bonappetit.com/photos/57acae2d1b33404414975121/4:3/w_3235,h_2426,c_limit/ultimate-veggie-burger.jpg",
                3.5,
                "Veggie Burger",
                0
            )
        )
        list.add(
            Foods(
                "https://www.killingthyme.net/wp-content/uploads/2021/11/best-turkey-burger-01.jpg",
                4.8,
                "Turkey Burger",
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
        list.add(
            Foods(
                "https://www.thecookingcollective.com.au/wp-content/uploads/2022/04/a-finished-crispy-chicken-burger-on-a-wooden-board.jpg",
                3.7,
                "Chicken Burger",
                0
            )
        )
        list.add(
            Foods(
                "https://freepngimg.com/save/145509-king-big-burger-download-hq/1606x938",
                6.0,
                "Big Burger",
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
    }


}