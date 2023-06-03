package com.example.motivation.screens

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityStartScreenBinding

class StartScreen : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityStartScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        verifyUserName()
    }

    private fun verifyUserName() {
        val userName = SecurityPreferences(this).getStorageString(MotivationConstants.Key.USER_NAME)

        if (userName != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = binding.editName.text.toString()

        if (name == "") {
            return Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT)
                .show()
        }

        // setando os valores no storage
        SecurityPreferences(this).addStorageString(MotivationConstants.Key.USER_NAME, name)

        startActivity(Intent(this, MainActivity::class.java))
        finish() // destroi a tela atual, tornando impossivel voltar para ela depois de navegar
    }
}