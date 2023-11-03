package com.example.wahakul

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private lateinit var masukan_nama2: EditText
    private lateinit var masukan_email2: EditText
    private lateinit var masukan_password2: EditText
    private lateinit var masuk_akun: TextView
    private lateinit var button_daftar: Button
    private lateinit var database: DatabaseReference
    private lateinit var arrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arrow=findViewById(R.id.arrow2)
        masukan_nama2 = findViewById(R.id.masukan_nama2)
        masukan_email2 = findViewById(R.id.masukan_email2)
        masukan_password2 = findViewById(R.id.masukan_password2)
        button_daftar = findViewById(R.id.buton_daftar)
        masuk_akun = findViewById(R.id.masuk_akun) // Ganti dengan id yang sesuai

        database = FirebaseDatabase.getInstance().reference
        arrow.setOnClickListener {
            val register = Intent(applicationContext, menu_utama::class.java)
            startActivity(register)
        }
        button_daftar.setOnClickListener {
            val username = masukan_nama2.text.toString()
            val email = masukan_email2.text.toString()
            val password = masukan_password2.text.toString()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Terdapat data Kosong, mohon di isi terlebih dahulu", Toast.LENGTH_LONG).show()
            } else {
                val userRef = database.child("users").child(username)
                userRef.child("user").setValue(username)
                userRef.child("email").setValue(email)
                userRef.child("password").setValue(password)
                Toast.makeText(applicationContext, "Register Berhasil", Toast.LENGTH_LONG).show()
                val register = Intent(applicationContext, menu_utama::class.java)
                startActivity(register)

            }
        }

        masuk_akun.setOnClickListener {
            val register = Intent(applicationContext, Login::class.java)
            startActivity(register)
        }
    }
}
