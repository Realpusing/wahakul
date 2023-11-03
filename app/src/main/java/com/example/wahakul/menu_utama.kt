package com.example.wahakul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class menu_utama : AppCompatActivity() {
    private lateinit var pesan: ImageView
    private lateinit var fav: ImageView
    private lateinit var acount: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_utama)

        pesan = findViewById(R.id.pesanan)
        fav = findViewById(R.id.fav)
        acount = findViewById(R.id.accont)

        pesan.setOnClickListener{
            val register = Intent(applicationContext, menupesanan::class.java)
            startActivity(register)
        }
        fav.setOnClickListener{
            val register = Intent(applicationContext, menufavorit::class.java)
            startActivity(register)
        }
        acount.setOnClickListener{
            val register = Intent(applicationContext, akun::class.java)
            startActivity(register)
        }
    }
}
