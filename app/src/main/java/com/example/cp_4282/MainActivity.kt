package com.example.cp_4282

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.view.View
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.cp_4282.ui.theme.CP_4282Theme

class MainActivity : ComponentActivity(), View.OnClickListener {
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.assignment_2)
        val button1: Button = findViewById(R.id.button)
        button1.setOnClickListener(this)

    }

    fun player1Dice(dice: List<Int>): Int {
        val diceRole = dice.random()
        return diceRole
    }

    fun player2Dice(dice: List<Int>): Int {
        val diceRole = dice.random()
        return diceRole
    }

    override fun onClick(v: View?) {
        val textviewc: TextView = findViewById(R.id.textView4)
        val dice = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
        var player1: Int = 0
        var player1Dice = mutableListOf<Int>()
        var player2: Int = 0
        var player2Dice = mutableListOf<Int>()
        println("What is player 1's name?")
        val player1Name = readln()
        println("What is player 2's name?")
        val player2name = readln()

        do {
            val p1Dice = player1Dice(dice)
            val p2Dice = player2Dice(dice)
            player1 += p1Dice
            player1Dice.add(p1Dice)
            player2 += p2Dice
            player2Dice.add(p2Dice)
        } while ((player1 < 96) && (player2 < 96))
        println("$player1Name's dice $player1Dice Totaling $player1")
        println("$player2name's dice $player2Dice Totaling $player2")
        if ((player1 >= 96) && (player2 >= 96)){
            println("Its a Tie!")
        } else if (player1 >= 96) {
            println("$player1Name wins!")
        } else if (player2 >= 96) {
            println("$player2name wins!")
        }
    }
}

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            CP_4282Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CP_4282Theme {
//        Greeting("Android")
//    }
//}