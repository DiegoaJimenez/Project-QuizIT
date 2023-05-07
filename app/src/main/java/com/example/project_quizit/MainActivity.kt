package com.example.project_quizit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_quizit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.linkRegister.setOnClickListener { openRegister() }

        binding.btnIniciarSesion.setOnClickListener { openHome() }
    }


    fun openRegister(){
        val registerIntent = Intent(this,registroUsuairoActivity::class.java)
        //teamInfoIntent.putExtra("TEAM_DATA",team)
        startActivity(registerIntent)
    }

    fun openHome(){
        val homeIntent = Intent(this,homeActivity::class.java)
        //teamInfoIntent.putExtra("TEAM_DATA",team)
        startActivity(homeIntent)
    }
}

