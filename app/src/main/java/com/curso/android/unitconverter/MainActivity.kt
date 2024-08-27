package com.curso.android.unitconverter

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textview)
        val btn: Button = findViewById(R.id.button)
        val editText: EditText = findViewById(R.id.editText)

        btn.setOnClickListener {
            val inputText : String = editText.text
                .toString()
            val kilos = inputText.toDouble()

            textView.text = "" + makeConvertion(kilos)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

fun makeConvertion(kilos: Double): Double {
    // 1 kg = 2.20462 pounds
    return kilos *2.20462
}