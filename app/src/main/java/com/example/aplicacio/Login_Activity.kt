package com.example.aplicacio
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Login_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemClock.sleep(400);
        setTheme(R.style.Theme_Aplicacio);
        setContentView(R.layout.activity_login)

        val sharedPreference =  getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        val sharedEditor = sharedPreference.edit();


        val btnSignIn:Button = findViewById(R.id.btnSignIn)
        val txtUsername:EditText = findViewById(R.id.txtUsername)
        val txtPassword:EditText = findViewById(R.id.txtPassword)
        val txtRecordListener: TextView = findViewById(R.id.txtSignUp)

        if(sharedPreference.getBoolean("login", false)==true){
            val intent = Intent(this, Activity_Main::class.java).apply {
                txtRecordListener.setText("Login correcto")
            }
            startActivity(intent)
        }

        btnSignIn.setOnClickListener {
            if (txtUsername.text.toString() == "admin" && txtPassword.text.toString() == "admin"
            ) {
                sharedEditor.putBoolean("login", true);
                sharedEditor.commit()
                val intent = Intent(this, Activity_Main::class.java).apply {
                    txtRecordListener.setText("Login correcto")
                }
                startActivity(intent)
            } else {
                txtRecordListener.setText("Login incorrecto")
            }
        }
    }
}

