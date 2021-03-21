package com.luanegra.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import java.lang.Math.random

class GameActivity : AppCompatActivity() {
    var btn_1_1: Button? = null
    var btn_1_2: Button? = null
    var btn_1_3: Button? = null
    var btn_2_1: Button? = null
    var btn_2_2: Button? = null
    var btn_2_3: Button? = null
    var btn_3_1: Button? = null
    var btn_3_2: Button? = null
    var btn_3_3: Button? = null
    var gametype: String? = null
    var player1: String? = null
    var player2: String? = null
    var aiPlayer: String? = null
    var whoisPlay: String = "1"
    var m = Array(3) {Array(3) {0} }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        gametype= intent.getStringExtra("Type")
        btn_1_1 = findViewById(R.id.btn_1_1)
        btn_1_2 = findViewById(R.id.btn_1_2)
        btn_1_3 = findViewById(R.id.btn_1_3)
        btn_2_1 = findViewById(R.id.btn_2_1)
        btn_2_2 = findViewById(R.id.btn_2_2)
        btn_2_3 = findViewById(R.id.btn_2_3)
        btn_3_1 = findViewById(R.id.btn_3_1)
        btn_3_2 = findViewById(R.id.btn_3_2)
        btn_3_3 = findViewById(R.id.btn_3_3)

        val btn_novo_Jogo = findViewById<Button>(R.id.btn_novo_Jogo)
        btn_novo_Jogo.setOnClickListener {
            newGame()
        }

        defineCursor()
    }

    private fun newGame(){
        val intent = Intent(this@GameActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun defineCursor(){
        val randomr = random().toInt()
        if(randomr/2 == 0){
            player1 = "X"
            player2 = "O"
            aiPlayer = "O"
        }
        if(randomr/2 == 1){
            player1 = "O"
            player2 = "X"
            aiPlayer = "X"
        }
        if (gametype.equals("0")){
            if (whoIsFirst() == 1){
                single_Player("1")
            }else{
                single_Player("2")
            }
        }else{
            multy_Player()
        }
    }

    private fun whoIsFirst(): Int{
        val randomr = random().toInt()
        var firstis = 0
        if(randomr/2 == 0){
            firstis = 1
        }
        if(randomr/2 == 1){
            firstis = 2
        }
        return firstis
    }

    private fun single_Player(whoisFirst: String){
        if (whoisFirst == "2"){
            ai_play()
        }else{
            multy_Player()
        }
    }

    private fun multy_Player(){
        btn_1_1!!.setOnClickListener {
            if (btn_1_1!!.text.isNullOrEmpty()){
                if (whoisPlay.equals("1")){
                    btn_1_1!!.text = player1
                    m[0][0] = 1
                    whoisPlay = "2"
                }else{
                    btn_1_1!!.text = player2
                    m[0][0] = 2
                    whoisPlay = "1"
                }
            }
            check_game()
        }

        btn_1_2!!.setOnClickListener {
            if (btn_1_2!!.text.isNullOrEmpty()){
                if (whoisPlay.equals("1")){
                    btn_1_2!!.text = player1
                    m[0][1] = 1
                    whoisPlay = "2"
                }else{
                    btn_1_2!!.text = player2
                    m[0][1] = 2
                    whoisPlay = "1"
                }
            }
            check_game()
        }

        btn_1_3!!.setOnClickListener {
            if (btn_1_3!!.text.isNullOrEmpty()){
                if (whoisPlay.equals("1")){
                    btn_1_3!!.text = player1
                    m[0][2] = 1
                    whoisPlay = "2"
                }else{
                    btn_1_3!!.text = player2
                    m[0][2] = 2
                    whoisPlay = "1"
                }
            }
            check_game()
        }

        btn_2_1!!.setOnClickListener {
            if (btn_2_1!!.text.isNullOrEmpty()){
                if (whoisPlay.equals("1")){
                    btn_2_1!!.text = player1
                    m[1][0] = 1
                    whoisPlay = "2"
                }else{
                    btn_2_1!!.text = player2
                    m[1][0] = 2
                    whoisPlay = "1"
                }
            }
            check_game()
        }

        btn_2_2!!.setOnClickListener {
            if (btn_2_2!!.text.isNullOrEmpty()){
                if (whoisPlay.equals("1")){
                    btn_2_2!!.text = player1
                    m[1][1] = 1
                    whoisPlay = "2"
                }else{
                    btn_2_2!!.text = player2
                    m[1][1] = 2
                    whoisPlay = "1"
                }
            }
            check_game()
        }

        btn_2_3!!.setOnClickListener {
            if (btn_2_3!!.text.isNullOrEmpty()){
                if (whoisPlay.equals("1")){
                    btn_2_3!!.text = player1
                    m[1][2] = 1
                    whoisPlay = "2"
                }else{
                    btn_2_3!!.text = player2
                    m[1][2] = 2
                    whoisPlay = "1"
                }
            }
            check_game()
        }

        btn_3_1!!.setOnClickListener {
            if (btn_3_1!!.text.isNullOrEmpty()){
                if (whoisPlay.equals("1")){
                    btn_3_1!!.text = player1
                    m[2][0] = 1
                    whoisPlay = "2"
                }else{
                    btn_3_1!!.text = player2
                    m[2][0] = 2
                    whoisPlay = "1"
                }
            }
            check_game()
        }

        btn_3_2!!.setOnClickListener {
            if (btn_3_2!!.text.isNullOrEmpty()){
                if (whoisPlay.equals("1")){
                    btn_3_2!!.text = player1
                    m[2][1] = 1
                    whoisPlay = "2"
                }else{
                    btn_3_2!!.text = player2
                    m[2][1] = 2
                    whoisPlay = "1"
                }
            }
            check_game()
        }

        btn_3_3!!.setOnClickListener {
            if (btn_3_3!!.text.isNullOrEmpty()){
                if (whoisPlay.equals("1")){
                    btn_3_3!!.text = player1
                    m[2][2] = 1
                    whoisPlay = "2"
                }else{
                    btn_3_3!!.text = player2
                    m[2][2] = 2
                    whoisPlay = "1"
                }
            }
            check_game()
        }
    }

    private fun check_game(){
        var haveWinner = false
        if(m[0][0].equals(1) && m[0][1].equals(1) && m[0][2].equals(1)){
            show_Winner(player1!!)
            haveWinner = true
        }else if(m[0][0].equals(2) && m[0][1].equals(2) && m[0][2].equals(2)){
            show_Winner(player2!!)
            haveWinner = true
        }

        if(m[0][0].equals(1) && m[1][1].equals(1) && m[2][2].equals(1)){
            show_Winner(player1!!)
            haveWinner = true
        }else if(m[0][0].equals(2) && m[1][1].equals(2) && m[2][2].equals(2)){
            show_Winner(player2!!)
            haveWinner = true
        }

        if(m[0][0].equals(1) && m[1][0].equals(1) && m[2][0].equals(1)){
            show_Winner(player1!!)
            haveWinner = true
        }else if(m[0][0].equals(2) && m[1][0].equals(2) && m[2][0].equals(2)){
            show_Winner(player2!!)
            haveWinner = true
        }

        if(m[0][1].equals(1) && m[1][1].equals(1) && m[2][1].equals(1)){
            show_Winner(player1!!)
            haveWinner = true
        }else if(m[0][1].equals(2) && m[1][1].equals(2) && m[2][1].equals(2)){
            show_Winner(player2!!)
            haveWinner = true
        }

        if(m[0][2].equals(1) && m[1][2].equals(1) && m[2][2].equals(1)){
            show_Winner(player1!!)
            haveWinner = true
        }else if(m[0][2].equals(2) && m[1][2].equals(2) && m[2][2].equals(2)){
            show_Winner(player2!!)
            haveWinner = true
        }

        if(m[2][0].equals(1) && m[1][1].equals(1) && m[0][2].equals(1)){
            show_Winner(player1!!)
            haveWinner = true
        }else if(m[2][0].equals(2) && m[1][1].equals(2) && m[0][2].equals(2)){
            show_Winner(player2!!)
            haveWinner = true
        }

        if(m[1][0].equals(1) && m[1][1].equals(1) && m[1][2].equals(1)){
            show_Winner(player1!!)
            haveWinner = true
        }else if(m[1][0].equals(2) && m[1][1].equals(2) && m[1][2].equals(2)){
            show_Winner(player2!!)
            haveWinner = true
        }

        if(m[2][0].equals(1) && m[2][1].equals(1) && m[2][2].equals(1)){
            show_Winner(player1!!)
            haveWinner = true
        }else if(m[2][0].equals(2) && m[2][1].equals(2) && m[2][2].equals(2)){
            show_Winner(player2!!)
            haveWinner = true
        }

        if (!haveWinner && gametype.equals("0") && whoisPlay == "2"){
            ai_play()
        }

    }

    private fun show_Winner(winner: String){
        val options = arrayOf<CharSequence>(
            "NEW GAME",
            "I DONT BELIEVE!"
        )
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("WINNER -> $winner")
        builder.setItems(options) { dialog, which ->
            if (which == 0) {
                newGame()
            } else if (which == 1) {
                dialog.dismiss()
            }
        }
        builder.show()
    }


    private fun ai_play(){
        var aiHavePlayed = false
        if (aiPlayer.equals("X")){
            if (m[0][0].equals(1) && m[0][1].equals(1)){
                if(btn_1_3!!.text.isNullOrEmpty()){
                    m[0][2] = 1
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(1) && m[0][1].equals(1)){
                if(btn_1_1!!.text.isNullOrEmpty()){
                    m[0][0] = 1
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(1) && m[0][2].equals(1)){
                if(btn_1_2!!.text.isNullOrEmpty()){
                    m[0][1] = 1
                    btn_1_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][0].equals(1) && m[1][1].equals(1)){
                if(btn_2_3!!.text.isNullOrEmpty()){
                    m[1][2] = 1
                    btn_2_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][2].equals(1) && m[1][1].equals(1)){
                if(btn_2_1!!.text.isNullOrEmpty()){
                    m[1][0] = 1
                    btn_2_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][0].equals(1) && m[1][2].equals(1)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 1
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][0].equals(1) && m[2][1].equals(1)){
                if(btn_2_3!!.text.isNullOrEmpty()){
                    m[2][2] = 1
                    btn_2_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][2].equals(1) && m[2][1].equals(1)){
                if(btn_3_1!!.text.isNullOrEmpty()){
                    m[2][0] = 1
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][0].equals(1) && m[2][2].equals(1)){
                if(btn_3_2!!.text.isNullOrEmpty()){
                    m[2][1] = 1
                    btn_3_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(1) && m[1][1].equals(1)){
                if(btn_3_3!!.text.isNullOrEmpty()){
                    m[2][2] = 1
                    btn_3_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][1].equals(1) && m[2][2].equals(1)){
                if(btn_1_1!!.text.isNullOrEmpty()){
                    m[0][0] = 1
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(1) && m[2][2].equals(1)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 1
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(1) && m[1][1].equals(1)){
                if(btn_3_1!!.text.isNullOrEmpty()){
                    m[2][0] = 1
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][1].equals(1) && m[2][0].equals(1)){
                if(btn_1_3!!.text.isNullOrEmpty()){
                    m[0][2] = 1
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(1) && m[2][0].equals(1)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 1
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(2) && m[0][1].equals(2)){
                if(btn_1_3!!.text.isNullOrEmpty()){
                    m[0][2] = 1
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(2) && m[0][1].equals(2)){
                if(btn_1_1!!.text.isNullOrEmpty()){
                    m[0][0] = 1
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(2) && m[0][2].equals(2)){
                if(btn_1_2!!.text.isNullOrEmpty()){
                    m[0][1] = 1
                    btn_1_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][0].equals(2) && m[1][1].equals(2)){
                if(btn_2_3!!.text.isNullOrEmpty()){
                    m[1][2] = 1
                    btn_2_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][2].equals(2) && m[1][1].equals(2)){
                if(btn_2_1!!.text.isNullOrEmpty()){
                    m[1][0] = 1
                    btn_2_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][0].equals(2) && m[1][2].equals(2)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 1
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][0].equals(2) && m[2][1].equals(2)){
                if(btn_3_3!!.text.isNullOrEmpty()){
                    m[2][2] = 1
                    btn_3_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][2].equals(2) && m[2][1].equals(2)){
                if(btn_3_1!!.text.isNullOrEmpty()){
                    m[2][0] = 1
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][0].equals(2) && m[2][2].equals(2)){
                if(btn_3_2!!.text.isNullOrEmpty()){
                    m[2][1] = 1
                    btn_3_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(2) && m[1][1].equals(2)){
                if(btn_3_3!!.text.isNullOrEmpty()){
                    m[2][2] = 1
                    btn_3_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][1].equals(2) && m[2][2].equals(2)){
                if(btn_1_1!!.text.isNullOrEmpty()){
                    m[0][0] = 1
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(2) && m[2][2].equals(2)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 1
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(2) && m[1][1].equals(2)){
                if(btn_3_1!!.text.isNullOrEmpty()){
                    m[2][0] = 1
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][1].equals(2) && m[2][0].equals(2)){
                if(btn_1_3!!.text.isNullOrEmpty()){
                    m[0][2] = 1
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(2) && m[2][0].equals(2)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 1
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "2"
                    aiHavePlayed = true
                    check_game()
                }
            }
        } else{
            if (m[0][0].equals(2) && m[0][1].equals(2)){
                if(btn_1_3!!.text.isNullOrEmpty()){
                    m[0][2] = 2
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(2) && m[0][1].equals(2)){
                if(btn_1_1!!.text.isNullOrEmpty()){
                    m[0][0] = 2
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(2) && m[0][2].equals(2)){
                if(btn_1_2!!.text.isNullOrEmpty()){
                    m[0][1] = 2
                    btn_1_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][0].equals(2) && m[1][1].equals(2)){
                if(btn_2_3!!.text.isNullOrEmpty()){
                    m[1][2] = 2
                    btn_2_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][2].equals(2) && m[1][1].equals(2)){
                if(btn_2_1!!.text.isNullOrEmpty()){
                    m[1][0] = 2
                    btn_2_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][0].equals(2) && m[1][2].equals(2)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 2
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][0].equals(2) && m[2][1].equals(2)){
                if(btn_3_3!!.text.isNullOrEmpty()){
                    m[2][2] = 2
                    btn_3_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][2].equals(2) && m[2][1].equals(2)){
                if(btn_3_1!!.text.isNullOrEmpty()){
                    m[2][0] = 2
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][0].equals(2) && m[2][2].equals(2)){
                if(btn_3_2!!.text.isNullOrEmpty()){
                    m[2][1] = 2
                    btn_3_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(2) && m[1][1].equals(2)){
                if(btn_3_3!!.text.isNullOrEmpty()){
                    m[2][2] = 2
                    btn_3_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][1].equals(2) && m[2][2].equals(2)){
                if(btn_1_1!!.text.isNullOrEmpty()){
                    m[0][0] = 2
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(2) && m[2][2].equals(2)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 2
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(2) && m[1][1].equals(2)){
                if(btn_3_1!!.text.isNullOrEmpty()){
                    m[2][0] = 2
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][1].equals(2) && m[2][0].equals(2)){
                if(btn_1_3!!.text.isNullOrEmpty()){
                    m[0][2] = 2
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(2) && m[2][0].equals(2)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 2
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(1) && m[0][1].equals(1)){
                if(btn_1_3!!.text.isNullOrEmpty()){
                    m[0][2] = 2
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(1) && m[0][1].equals(1)){
                if(btn_1_1!!.text.isNullOrEmpty()){
                    m[0][0] = 2
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(1) && m[0][2].equals(1)){
                if(btn_1_2!!.text.isNullOrEmpty()){
                    m[0][1] = 2
                    btn_1_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][0].equals(1) && m[1][1].equals(1)){
                if(btn_2_3!!.text.isNullOrEmpty()){
                    m[1][2] = 2
                    btn_2_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][2].equals(1) && m[1][1].equals(1)){
                if(btn_2_1!!.text.isNullOrEmpty()){
                    m[1][0] = 2
                    btn_2_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][0].equals(1) && m[1][2].equals(1)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 2
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][0].equals(1) && m[2][1].equals(1)){
                if(btn_3_3!!.text.isNullOrEmpty()){
                    m[2][2] = 2
                    btn_3_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][2].equals(1) && m[2][1].equals(1)){
                if(btn_3_1!!.text.isNullOrEmpty()){
                    m[2][0] = 2
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[2][0].equals(1) && m[2][2].equals(1)){
                if(btn_3_2!!.text.isNullOrEmpty()){
                    m[2][1] = 2
                    btn_3_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(1) && m[1][1].equals(1)){
                if(btn_3_3!!.text.isNullOrEmpty()){
                    m[2][2] = 2
                    btn_3_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][1].equals(1) && m[2][2].equals(1)){
                if(btn_1_1!!.text.isNullOrEmpty()){
                    m[0][0] = 2
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][0].equals(1) && m[2][2].equals(1)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 2
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(1) && m[1][1].equals(1)){
                if(btn_3_1!!.text.isNullOrEmpty()){
                    m[2][0] = 2
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[1][1].equals(1) && m[2][0].equals(1)){
                if(btn_1_3!!.text.isNullOrEmpty()){
                    m[0][2] = 2
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }else if (m[0][2].equals(1) && m[2][0].equals(1)){
                if(btn_2_2!!.text.isNullOrEmpty()){
                    m[1][1] = 2
                    btn_2_2!!.text = aiPlayer
                    whoisPlay = "1"
                    aiHavePlayed = true
                    check_game()
                }
            }
        }
        if (!aiHavePlayed){
            if (btn_1_1!!.text.isNullOrEmpty()){
                if (aiPlayer.equals("X")){
                    m[0][0] = 1
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "2"
                    check_game()
                }else{
                    m[0][0] = 2
                    btn_1_1!!.text = aiPlayer
                    whoisPlay = "1"
                    check_game()
                }
            }else if (btn_1_3!!.text.isNullOrEmpty()){
                if (aiPlayer.equals("X")){
                    m[0][2] = 1
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "2"
                    check_game()
                }else{
                    m[0][2] = 2
                    btn_1_3!!.text = aiPlayer
                    whoisPlay = "1"
                    check_game()
                }
            }else if (btn_3_3!!.text.isNullOrEmpty()){
                if (aiPlayer.equals("X")){
                    m[2][2] = 1
                    btn_3_3!!.text = aiPlayer
                    whoisPlay = "2"
                    check_game()
                }else{
                    m[2][2] = 2
                    btn_3_3!!.text = aiPlayer
                    whoisPlay = "1"
                    check_game()
                }
            }else if (btn_3_1!!.text.isNullOrEmpty()){
                if (aiPlayer.equals("X")){
                    m[2][0] = 1
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "2"
                    check_game()
                }else{
                    m[2][0] = 2
                    btn_3_1!!.text = aiPlayer
                    whoisPlay = "1"
                    check_game()
                }
            }else{
                if (btn_1_2!!.text.isNullOrEmpty()){
                    if (aiPlayer.equals("X")){
                        m[0][1] = 1
                        btn_1_2!!.text = aiPlayer
                        whoisPlay = "2"
                        check_game()
                    }else{
                        m[0][1] = 2
                        btn_1_2!!.text = aiPlayer
                        whoisPlay = "1"
                        check_game()
                    }
                }else if (btn_2_2!!.text.isNullOrEmpty()){
                    if (aiPlayer.equals("X")){
                        m[1][1] = 1
                        btn_2_2!!.text = aiPlayer
                        whoisPlay = "2"
                        check_game()
                    }else{
                        m[1][1] = 2
                        btn_2_2!!.text = aiPlayer
                        whoisPlay = "1"
                        check_game()
                    }
                }else if (btn_3_2!!.text.isNullOrEmpty()){
                    if (aiPlayer.equals("X")){
                        m[2][1] = 1
                        btn_3_2!!.text = aiPlayer
                        whoisPlay = "2"
                        check_game()
                    }else{
                        m[2][1] = 2
                        btn_3_2!!.text = aiPlayer
                        whoisPlay = "1"
                        check_game()
                    }
                }else if (btn_2_1!!.text.isNullOrEmpty()){
                    if (aiPlayer.equals("X")){
                        m[1][0] = 1
                        btn_2_1!!.text = aiPlayer
                        whoisPlay = "2"
                        check_game()
                    }else{
                        m[1][0] = 2
                        btn_2_1!!.text = aiPlayer
                        whoisPlay = "1"
                        check_game()
                    }
                } else if (btn_2_3!!.text.isNullOrEmpty()){
                    if (aiPlayer.equals("X")){
                        m[1][2] = 1
                        btn_2_3!!.text = aiPlayer
                        whoisPlay = "2"
                        check_game()
                    }else{
                        m[1][2] = 2
                        btn_2_3!!.text = aiPlayer
                        whoisPlay = "1"
                        check_game()
                    }
                }
            }
        }
    }
}
