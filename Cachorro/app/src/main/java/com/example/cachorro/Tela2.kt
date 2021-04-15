package com.example.cachorro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
    }

    fun Voltar(view: View) {

        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)

    }
}