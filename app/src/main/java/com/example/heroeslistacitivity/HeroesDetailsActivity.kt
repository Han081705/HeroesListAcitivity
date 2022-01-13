package com.example.heroeslistacitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroeslistacitivity.databinding.ActivityHeroesDetailsBinding

class HeroesDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}