package com.example.mysampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        // connect the textView from UI to a value called visitCountControl
        val visitCountControl = findViewById<TextView>(R.id.visitCount)
        val increaseBtn = findViewById<Button>(R.id.increaseBy1)
        val decreaseBtn = findViewById<Button>(R.id.decreaseBy1)
        val countValue = findViewById<EditText>(R.id.countValue)
        val increaseByValue = findViewById<Button>(R.id.increaseByValue)

        visitCountControl.text = "0"
        var countOfVisitors = 0
        increaseBtn.setOnClickListener(){
            // first method by declaring a new variable called countOfVisitors
            countOfVisitors += 1
            visitCountControl.text = countOfVisitors.toString()
        }
        decreaseBtn.setOnClickListener(){
            // another method of changing value without declaring the variable visitCountControl
            visitCountControl.text = (Integer.parseInt(visitCountControl.text as String) - 1).toString()
        }
        increaseByValue.setOnClickListener(){
            visitCountControl.text = ( Integer.parseInt(countValue.text.toString()) + Integer.parseInt(visitCountControl.text.toString()) ).toString()
            countOfVisitors = Integer.parseInt(visitCountControl.text as String)
        }
    }
}