package com.example.wahakul

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class Login : AppCompatActivity() {
    private lateinit var button_masuk: Button
    private lateinit var buat_akun: TextView
    private lateinit var masukan_password: EditText
    private lateinit var masukan_email: EditText
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        database = FirebaseDatabase.getInstance().getReference("users")
        button_masuk = findViewById(R.id.button_masuk)
        masukan_email = findViewById(R.id.masukan_email)
        masukan_password = findViewById(R.id.masukan_password)
        buat_akun = findViewById(R.id.buat_akun)

        button_masuk.setOnClickListener {
            val email = masukan_email.text.toString()
            val password = masukan_password.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Email atau password salah cuy", Toast.LENGTH_SHORT).show()
            } else {
                database.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.child(email).exists()) {
                            if (snapshot.child(email).child("password").getValue(String::class.java) == password) {
                                Toast.makeText(applicationContext, "Login berhasil", Toast.LENGTH_SHORT).show()
                                val register = Intent(applicationContext, menu_utama::class.java)
                                startActivity(register)
                            } else {
                                Toast.makeText(applicationContext, "Password salah", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(applicationContext, "Data belum terdaftar", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle onCancelled event if needed
                    }
                })
            }
        }

        buat_akun.setOnClickListener {
            val register = Intent(applicationContext, MainActivity::class.java)
            startActivity(register)
        }
    }
}
