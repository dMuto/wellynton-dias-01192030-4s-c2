package com.example.cachorro

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.cachorro.consumir.Cachorro
import com.example.cachorro.consumir.ConsumirApiCachorro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Comprar(view: View) {

        val api = ConsumirApiCachorro.criar()

        val edId1:EditText = findViewById(R.id.identificador1)

        val edId2:EditText = findViewById(R.id.identificador2)

        val id1 = edId1.text.toString().toInt()
        val id2 = edId2.text.toString().toInt()

        if(id1 == 0 || id1 == null ){
            Toast.makeText(baseContext, "Por favor, digite um numero valido nos dois campos", Toast.LENGTH_SHORT).show()
        }

        if ( id2 == 0 || id2 == null){
            Toast.makeText(baseContext, "Por favor, digite um numero valido nos dois campos", Toast.LENGTH_SHORT).show()
        }

        api.getCachorro1(id1).enqueue(object : Callback<Cachorro>{
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code() == 200) {
                    val c1 = response.body()
                    


                    val intent = Intent(applicationContext, Tela2::class.java)
                    startActivity(intent)

                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {

                val intent = Intent(applicationContext, Tela3::class.java)
                startActivity(intent)

                Toast.makeText(baseContext, "Erro: encontrar cachorro com o primeiro id, ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        api.getCachorro2(id2).enqueue(object : Callback<Cachorro>{
            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code() == 200) {

                    val intent = Intent(applicationContext, Tela2::class.java)
                    startActivity(intent)

                }
            }

            override fun onFailure(call: Call<Cachorro>, t: Throwable) {

                val intent = Intent(applicationContext, Tela3::class.java)
                startActivity(intent)

                Toast.makeText(baseContext, "Erro: encontrar cachorro com o Segundo id, ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }
}