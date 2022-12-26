package com.example.mysampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


// Create a class MainActivity which inherits from AppCompatActivity
class MainActivity : AppCompatActivity() {
    // whenever a new activity is created, it will call the function onCreate
    // override the default function onCreate
    override fun onCreate(savedInstanceState: Bundle?) { // fun is the shortform of function
        // super means calling the onCreate function of parent
        super.onCreate(savedInstanceState)
        // connect this file with Res -> layout -> activity_main file (R stands for res folder)
        setContentView(R.layout.activity_main)

        // actual coding starts from here
        val ageToMinutesBtn = findViewById<Button>(R.id.ageToMinutes)
        val counterBtn = findViewById<Button>(R.id.counterBtn)
        val calcBtn = findViewById<Button>(R.id.calcBtn)

        // GO to another activity
        counterBtn.setOnClickListener(){
            val intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)
        }

        val EXTRA_MESSAGE = "com.example.mysampleapp.MESSAGE"
        ageToMinutesBtn.setOnClickListener() {
            val intent = Intent(this, AgeToMinutes::class.java).apply {
                putExtra(EXTRA_MESSAGE, "anything you wanna say")
            }
            startActivity(intent)
        }

        calcBtn.setOnClickListener {
            val intent = Intent(this, Calculator::class.java)
            startActivity(intent)
        }
    }
}