package com.example.cp_4282

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.TextView
import android.widget.Button
import android.view.View
import android.widget.EditText

class MainActivity : ComponentActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.assignment_2)
        val button1: Button = findViewById(R.id.button)
        button1.setOnClickListener(this)

    }
    // This on click does all the work in the program.
    // All the attributes that are altered are called here to be changed when the button is clicked
    // This program runs a loop to get all the dice rolls and adds them together for the players total
    // It then goes through all the win conditions and displays them in the final text view
    override fun onClick(v: View?) {
        val dice = Dice()
        val player1Name: EditText = findViewById(R.id.player1Name)
        val player2Name: EditText = findViewById(R.id.player2Name)
        val player1Named = player1Name.text.toString()
        val player2Named = player2Name.text.toString()
        val dice1: TextView = findViewById(R.id.diceValue)
        val player1: TextView = findViewById(R.id.player1Total)
        val player2: TextView = findViewById(R.id.player2Total)
        val win: TextView = findViewById(R.id.win)
        do{
            val p1Dice = dice.player1Dice()
            val p2Dice = dice.player2Dice()
            dice1.text
            dice.player1 += p1Dice
            dice.player1DiceList.add(p1Dice)
            dice.player2 += p2Dice
            dice.player2DiceList.add(p2Dice)
        } while ((dice.player1 < 96) && (dice.player2 < 96))
        player1.text = ("${player1Named}'s dice ${dice.player1DiceList} Totaling ${dice.player1}")
        player2.text = ("${player2Named}'s dice ${dice.player2DiceList} Totaling ${dice.player2}")
        if ((dice.player1 >= 96) && (dice.player2 >= 96)){
            win.text = ("Its a Tie!")
        } else if (dice.player1 >= 96) {
            win.text = ("${player1Named} wins!")
        } else if (dice.player2 >= 96) {
            win.text = ("${player2Named} wins!")
        }
    }

// This class handles all the dice operations and all the players dice
class Dice {
    val dice = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
    var player1: Int = 0
    var player1DiceList = mutableListOf<Int>()
    var player2: Int = 0
    var player2DiceList = mutableListOf<Int>()

    fun player1Dice(): Int {
        val p1DiceRole = dice.random()
        return p1DiceRole
    }

    fun player2Dice(): Int {
        val p2DiceRole = dice.random()
        return p2DiceRole
    }
}
}