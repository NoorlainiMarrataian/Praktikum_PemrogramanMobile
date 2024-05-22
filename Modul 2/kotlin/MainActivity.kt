package com.example.modul2kalkulatortip

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceCostInput: EditText = findViewById(R.id.serviceCostInput)
        val tipOptions: RadioGroup = findViewById(R.id.tipOptions)
        val roundUpSwitch: Switch = findViewById(R.id.roundUpSwitch)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val tipResult: TextView = findViewById(R.id.tipResult)

        calculateButton.setOnClickListener {
            calculateTip(serviceCostInput, tipOptions, roundUpSwitch, tipResult)
        }
    }

    private fun calculateTip(serviceCostInput: EditText, tipOptions: RadioGroup, roundUpSwitch: Switch, tipResult: TextView) {
        val costString = serviceCostInput.text.toString()
        val cost = costString.toDoubleOrNull()
        if (cost == null) {
            tipResult.text = ""
            return
        }

        val tipPercentage = when (tipOptions.checkedRadioButtonId) {
            R.id.tipOption15 -> 0.15
            R.id.tipOption18 -> 0.18
            R.id.tipOption20 -> 0.20
            else -> 0.0
        }

        var tip = cost * tipPercentage
        if (roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}