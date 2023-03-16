package com.example.foodie2

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodie2.databinding.ActivityGetStartedBinding
import java.util.*

class GetStarted : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartedBinding
    private lateinit var getSharedPreferences: SharedPreferences
    private lateinit var getSharedPreferences2: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSharedPreferences = getSharedPreferences("state", MODE_PRIVATE)
        val state = getSharedPreferences.getBoolean("State", false)
        getSharedPreferences2 = getSharedPreferences("lang", MODE_PRIVATE)
        val lang = getSharedPreferences2.getString("lang", "En")


        var languageToLoad: String? = null

        if (lang == "En") {
            languageToLoad = "en"
        } else if (lang == "Ru") {
            languageToLoad = "ru"
        } else if (lang == "Uz") {
            languageToLoad = "uz"
        }

        if (languageToLoad != null) {
            val locale = Locale(languageToLoad)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(
                config,
                baseContext.resources.displayMetrics
            )
        }

        binding.textView.text ="Foodiee"
        binding.getStartedBtn.text = "Get Started"

        binding.getStartedBtn.setOnClickListener {
            if (!state) {
                val intent = Intent(this, Offerta::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, EnterPin::class.java)
                startActivity(intent)
                finish()
            }
        }


    }
}