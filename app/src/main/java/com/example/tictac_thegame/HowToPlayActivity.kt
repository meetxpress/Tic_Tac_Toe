package com.example.tictac_thegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_how_to_play.*

class HowToPlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_play)

        btnTryNow.setOnClickListener{
            startActivity(Intent(this@HowToPlayActivity, HomeActivity::class.java))
        }
    }
}
