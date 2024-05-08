package com.example.modul1aplikasidadu

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var lastDiceRoll: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice(); rollDice2() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage1: ImageView = findViewById(R.id.imageView)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource)
        diceImage1.contentDescription = diceRoll.toString()
        lastDiceRoll = diceRoll
    }

    private fun rollDice2() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage2: ImageView = findViewById(R.id.dice_image_2)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(drawableResource)
        diceImage2.contentDescription = diceRoll.toString()
        if (lastDiceRoll != null && diceRoll == lastDiceRoll) {
            Toast.makeText(this, "Selamat anda dapat dadu double!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()
        }
        lastDiceRoll = diceRoll
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}