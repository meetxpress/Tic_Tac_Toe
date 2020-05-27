package com.example.tictac_thegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import net.simplifiedcoding.tictactoe.Board
import net.simplifiedcoding.tictactoe.Cell

class MainActivity : AppCompatActivity() {
    private val boardCells = Array(3) { arrayOfNulls<ImageView>(3) }

    var board = Board()
    var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Sign Assignment")
        builder.setMessage("The Circle or Zero is your sign. The First turn will be yours.")

        builder.setPositiveButton("Start Game") { _, _ -> }
        builder.show()

        loadBoard()

        button_restart.setOnClickListener {
            board = Board()
            text_view_result.text = ""
            mapBoardToUi()
        }
    }

    private fun mapBoardToUi() {
        for (i in board.board.indices) {
            for (j in board.board.indices) {
                when (board.board[i][j]) {
                    Board.PLAYER -> {
                        boardCells[i][j]?.setImageResource(R.drawable.circle)
                        boardCells[i][j]?.isEnabled = false
                    }
                    Board.COMPUTER -> {
                        boardCells[i][j]?.setImageResource(R.drawable.cross)
                        boardCells[i][j]?.isEnabled = false
                    }
                    else -> {
                        boardCells[i][j]?.setImageResource(0)
                        boardCells[i][j]?.isEnabled = true
                    }
                }
            }
        }
    }

    private fun loadBoard() {
        for (i in boardCells.indices) {
            for (j in boardCells.indices) {
                boardCells[i][j] = ImageView(this@MainActivity)
                boardCells[i][j]?.layoutParams = GridLayout.LayoutParams().apply {
                    rowSpec = GridLayout.spec(i)
                    columnSpec = GridLayout.spec(j)
                    width = 200
                    height = 200
                    bottomMargin = 5
                    topMargin = 5
                    leftMargin = 5
                    rightMargin = 5
                }
                boardCells[i][j]?.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimary))
                boardCells[i][j]?.setOnClickListener(CellClickListener(i, j))
                layout_board.addView(boardCells[i][j])
            }
        }
    }

    inner class CellClickListener(
        private val i: Int,
        private val j: Int
    ) : View.OnClickListener {

    override fun onClick(p0: View?) {

            if (!board.isGameOver) {
                val cell = Cell(i, j)
                board.placeMove(cell, Board.PLAYER)
                board.minimax(0, Board.COMPUTER)
                board.computersMove?.let {
                    board.placeMove(it, Board.COMPUTER)
                }
                mapBoardToUi()
            }

            when {
                board.hasComputerWon() -> text_view_result.text = "Computer Won"
                board.hasPlayerWon() -> text_view_result.text = "Player Won"
                board.isGameOver -> text_view_result.text = "Game Tied"
            }
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Quitting Game")
        builder.setMessage("Are you sure you want to Quit? You will loose you steps you have taken.")

        builder.setPositiveButton("Quit") { _, _ ->
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
        }
        builder.setNegativeButton("Cancel") {_, _ ->}
        builder.show()
    }

}
