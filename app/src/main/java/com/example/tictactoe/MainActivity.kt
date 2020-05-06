package com.example.tictactoe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var activePlayer = Random.nextInt(0, 2)+1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var autoPlayer: Boolean =true
    val board = ArrayList<Int>()
    var winner = -1
    var dificult = "easy"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "O jogador que começa é o :$activePlayer", Toast.LENGTH_SHORT)
            .show()
        if(activePlayer==2){autoPlay(dificult)}
    }

    fun btClick(view: View) {

        val btSelected = view as Button

        var cellId = 0
        when (btSelected.id) {
            R.id.bt1 -> cellId = 1
            R.id.bt2 -> cellId = 2
            R.id.bt3 -> cellId = 3
            R.id.bt4 -> cellId = 4
            R.id.bt5 -> cellId = 5
            R.id.bt6 -> cellId = 6
            R.id.bt7 -> cellId = 7
            R.id.bt8 -> cellId = 8
            R.id.bt9 -> cellId = 9
        }
        //Log.d("btClick", btSelected.id.toString())

        playGame(cellId,btSelected)
        Log.d("btClick: List Player 1", player1.toString())
        Log.d("btClick: List Player 2", player2.toString())
        Log.d("btClick: List Board", board.toString())
    }

    fun playGame(cellId: Int, btSelected: Button) {
        if(activePlayer ==1){
            btSelected.text = "x"
            btSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            board.add(cellId)
            activePlayer = 2
            if(autoPlayer){autoPlay(dificult)}

        }else{
            btSelected.text = "0"
            btSelected.setBackgroundResource(R.color.green)
            activePlayer = 1
            player2.add(cellId)
            board.add(cellId)
        }

        btSelected.isEnabled = false

        checkWinner()
    }

    private fun checkWinner(){
        this.winner = -1
        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){winner = 1}
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){winner = 2}
        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){winner = 1}
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){winner = 2}
        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){winner = 1}
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){winner = 2}
        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){winner = 1}
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){winner = 2}
        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){winner = 1}
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){winner = 2}
        //col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){winner = 1}
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){winner = 2}

        //tra 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){winner = 1}
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){winner = 2}
        //tra 2
        if(player1.contains(7) && player1.contains(5) && player1.contains(3)){winner = 1}
        if(player2.contains(7) && player2.contains(5) && player2.contains(3)){winner = 2}

        if (winner == 1){Toast.makeText(this, "Jogador $winner é o vencedor", Toast.LENGTH_LONG).show()}
        if (winner == 2){Toast.makeText(this, "Jogador $winner é o vencedor", Toast.LENGTH_LONG).show()}

    }
    fun autoPlay(diff:String): Int {

        var emptyCells = ArrayList<Int>()
        var bestScore = -100000
        var cellId = 0

        if(board.size == 9){
            Toast.makeText(this, "Empatou é treta!", Toast.LENGTH_LONG).show()
            return 0
        }

        //check what index is empty
        for (cellId in 1..9){
            if (!(player1.contains(cellId)|| player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }


        // diff - easy -> Random empty spot
        if(diff== "easy"){
            val r = Random
            val randIndex = r.nextInt(emptyCells.size)
            cellId = emptyCells[randIndex]
        }

        // diff - hard -> Killing AI
        if(diff=="hard"){



        }


        var btSelected:Button?
        btSelected = when(cellId){
            1 -> bt1
            2 -> bt2
            3 -> bt3
            4 -> bt4
            5 -> bt5
            6 -> bt6
            7 -> bt7
            8 -> bt8
            9 -> bt9
            else -> bt1
        }
        playGame(cellId, btSelected)
        return 0
    }


    private fun minimax(board:ArrayList<Int>, depth:Int, isMaximizing:Boolean): Int {

        return 1
    }

    fun restartGame(view: View) {
        activePlayer =1
        player1.clear()
        player2.clear()
        board.clear()

        for (cellId in 1..9){
            var btSelected:Button?
            btSelected = when(cellId){
                1 -> bt1
                2 -> bt2
                3 -> bt3
                4 -> bt4
                5 -> bt5
                6 -> bt6
                7 -> bt7
                8 -> bt8
                9 -> bt9
                else -> bt1
            }
            btSelected.text =""
            btSelected.setBackgroundResource(R.color.emptyColor)
            btSelected.isEnabled = true
        }
    }
}
