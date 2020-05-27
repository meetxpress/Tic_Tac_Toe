package com.example.tictac_thegame

import android.content.Intent
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

        btnExit.setOnClickListener {
            finishAffinity()
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
