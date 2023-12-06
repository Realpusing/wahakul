package com.example.wahakul

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class menu_utama : AppCompatActivity() {
    private lateinit var pesan: ImageView
    private lateinit var fav: ImageView
    private lateinit var acount: ImageView
    private lateinit var home:ImageView
    private lateinit var makanan:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_utama)
        makanan=findViewById(R.id.makanan)
        home=findViewById(R.id.home)
        pesan = findViewById(R.id.dompet)
        fav = findViewById(R.id.suka)
        acount = findViewById(R.id.profil)

        makanan.setOnClickListener{
            val register = Intent(applicationContext, masukpesan::class.java)
            startActivity(register)
        }
        home.setOnClickListener{
            val register = Intent(applicationContext, menu_utama::class.java)
            startActivity(register)
        }
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
