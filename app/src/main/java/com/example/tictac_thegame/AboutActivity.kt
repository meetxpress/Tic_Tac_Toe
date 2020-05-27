package com.example.tictac_thegame

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        linkToOpen.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.meetpatel.live/")
            startActivity(openURL)
        }

    }

    override fun onBackPressed() {
        startActivity(Intent(this@AboutActivity, HomeActivity::class.java))
    }
}
