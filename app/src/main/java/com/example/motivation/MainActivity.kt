package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNewPhrase.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            addNewPhrase()
        }
    }

    private fun addNewPhrase() {
        Toast.makeText(this, "clicou", Toast.LENGTH_SHORT).show()
    }
}