package com.example.motivation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var category = MotivationConstants.Filter.INFINITY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleUserName()

        // eventos
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageInfinity.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)
        binding.imageHappyFace.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            addNewPhrase()
        } else if (view.id in listOf(R.id.image_happy_face, R.id.image_infinity, R.id.image_sun)) {
            handleFilter(view.id)
        }
    }

    private fun addNewPhrase() {
        Toast.makeText(this, "clicou", Toast.LENGTH_SHORT).show()
    }

    private fun handleUserName() {
        // pegando o valor do storage
        val userName = SecurityPreferences(this).getStorageString(MotivationConstants.Key.USER_NAME)
        binding.textHello.text = "Olá, $userName!"
    }

    private fun handleFilter(id: Int) {
        val defaultColor = ContextCompat.getColor(this, R.color.purple_800)
        val selectedColor = ContextCompat.getColor(this, R.color.white)

        binding.imageInfinity.setColorFilter(defaultColor)
        binding.imageHappyFace.setColorFilter(defaultColor)
        binding.imageSun.setColorFilter(defaultColor)

        when (id) {
            R.id.image_infinity -> {
                binding.imageInfinity.setColorFilter(selectedColor)
                category = MotivationConstants.Filter.INFINITY
            }
            R.id.image_sun -> {
                binding.imageSun.setColorFilter(selectedColor)
                category = MotivationConstants.Filter.SUN
            }
            R.id.image_happy_face -> {
                binding.imageHappyFace.setColorFilter(selectedColor)
                category = MotivationConstants.Filter.HAPPY
            }
        }
    }
}