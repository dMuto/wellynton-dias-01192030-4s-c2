package com.example.cachorro

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.TextView

class Tela2 : AppCompatActivity() {

    lateinit var dados:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        dados = getSharedPreferences("Dados", MODE_PRIVATE)

        val raca1 = dados.getString("raca1", null)
        val raca2 = dados.getString("raca2", null)

        val valor1 = dados.getFloat("valor1", 0.0F)
        val valor2 = dados.getFloat("valor2", 0.0F)

        var valorTotal = valor1 + valor2

        var mensagem1 = if(raca1 != null) getString(R.string.cachorro1, raca1) else getString(R.string.nao_Encontrado)
        var mensagem2 = if(raca2 != null) getString(R.string.cachorro2, raca2) else getString(R.string.nao_Encontrado)
        var valor = if(valorTotal != null) getString(R.string.preco_Compra, valorTotal) else getString(R.string.nao_Encontrado)

        findViewById<TextView>(R.id.tx_Erro).text = mensagem1
        findViewById<TextView>(R.id.tx_Erro2).text = mensagem2
        findViewById<TextView>(R.id.tx_soma).text = valor

    }

    fun Voltar(view: View) {

        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)

    }
}