package com.example.temperatureconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val celsiusInput = findViewById<EditText>(R.id.celsiusInput)
        val celsiusToFahrenheitButton = findViewById<Button>(R.id.celsiusToFahrenheitButton)
        val fahrenheitResult = findViewById<TextView>(R.id.fahrenheitResult)

        val fahrenheitInput = findViewById<EditText>(R.id.fahrenheitInput)
        val fahrenheitToCelsiusButton = findViewById<Button>(R.id.fahrenheitToCelsiusButton)
        val celsiusResult = findViewById<TextView>(R.id.celsiusResult)

        celsiusToFahrenheitButton.setOnClickListener {
            val celsiusTemp = celsiusInput.text.toString().toDoubleOrNull()
            if (celsiusTemp != null) {
                val fahrenheitTemp = celsiusToFahrenheit(celsiusTemp)
                val fahrenheitText = getString(R.string.result_fahrenheit, fahrenheitTemp)
                fahrenheitResult.text = fahrenheitText
            } else {
                fahrenheitResult.text = getString(R.string.invalid_input)
            }
        }

        fahrenheitToCelsiusButton.setOnClickListener {
            val fahrenheitTemp = fahrenheitInput.text.toString().toDoubleOrNull()
            if (fahrenheitTemp != null) {
                val celsiusTemp = fahrenheitToCelsius(fahrenheitTemp)
                val celsiusText = getString(R.string.result_celsius, celsiusTemp)
                celsiusResult.text = celsiusText
            } else {
                celsiusResult.text = getString(R.string.invalid_input)
            }
        }
    }

    private fun celsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    private fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }
}