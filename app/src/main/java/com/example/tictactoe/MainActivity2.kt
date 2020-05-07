package com.example.tictactoe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil
import kotlin.math.min
import kotlin.random.Random



class MainActivity2 : AppCompatActivity() {

    var board:ArrayList<Cell> = ArrayList()
    var avaiable = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        board.add( Cell(0, 0))
        board.add( Cell(0, 1))
        board.add( Cell(0, 2))
        board.add( Cell(1, 0))
        board.add( Cell(1, 1))
        board.add( Cell(1, 2))
        board.add( Cell(2, 0))
        board.add( Cell(2, 1))
        board.add( Cell(2, 2))







        bt1.setOnClickListener {
Log.d("Porra", "${board[0].content} - ${board[1].col} ")
        }

    }

    fun btClick(view: View) {

    }
    fun restartGame(view: View) {}
}

enum class Seed {
    EMPTY, CROSS, NOUGHT
}

enum class GameState {
    PLAYING, DRAW, CROSS_WON, NOUGHT_WON
}

class Cell(val row: Int, val col: Int) {
    var content: Seed = Seed.EMPTY
    fun clear() {
        content = Seed.EMPTY
    }
}