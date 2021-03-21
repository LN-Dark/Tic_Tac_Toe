package com.luanegra.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_single_player = findViewById<Button>(R.id.btn_single_player)
        val btn_multy_player = findViewById<Button>(R.id.btn_multy_player)
        btn_single_player.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("Type", "0")
            startActivity(intent)
            finish()
        }
        btn_multy_player.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            intent.putExtra("Type", "1")
            startActivity(intent)
            finish()
        }
    }
}