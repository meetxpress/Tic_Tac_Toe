package com.example.tictac_thegame

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnStart.setOnClickListener {
            startActivity(Intent(this@HomeActivity, MainActivity::class.java))
        }

        btnAbout.setOnClickListener {
            startActivity(Intent(this@HomeActivity, AboutActivity::class.java))
        }

        btnHowToPlay.setOnClickListener {
            startActivity(Intent(this@HomeActivity, HowToPlayActivity::class.java))
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }

        socialOne.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/meetxpress/")
            startActivity(openURL)
        }

        socialTwo.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.github.com/meetxpress/")
            startActivity(openURL)
        }

        socialThree.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.meetpatel.live/")
            startActivity(openURL)
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this@HomeActivity)
        builder.setTitle("Exit")
        builder.setMessage("Are you sure you want to Exit?")

        builder.setPositiveButton("Exit") { _, _ ->
            finishAffinity()
        }
        builder.setNegativeButton("Cancel") {_, _ ->}
        builder.show()

    }
}
