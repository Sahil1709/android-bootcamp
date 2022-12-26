package com.example.mysampleapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class AgeToMinutes : AppCompatActivity() {

    // define global variables here
    private var dateText: TextView ? = null
    private var ageInMinutesText: TextView ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agetominutes)

        val btnSelectDate = findViewById<Button>(R.id.btn_select_date)
        dateText = findViewById<TextView>(R.id.date)
        ageInMinutesText = findViewById<TextView>(R.id.ageInMinutes)
        val sdf = SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
        val myCal = Calendar.getInstance()
        dateText?.text = sdf.format(myCal.time)

        btnSelectDate.setOnClickListener {
            // we are getting current date because we need to pass a default value to DatePickerDialog
            // syntax => DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth -> ... } , defaultYear, defaultMonth, defaultDay).show()
            val cYear = myCal.get(Calendar.YEAR) // get current year
            val cMonth = myCal.get(Calendar.MONTH) // current month
            val cDay = myCal.get(Calendar.DAY_OF_MONTH) // current day
            val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//                myCal.set(Calendar.YEAR, year)
//                myCal.set(Calendar.MONTH, month)
//                myCal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                dateText.text = sdf.format(myCal.time)
                // OR you can also do without using sdf
                val selectedDate = "$dayOfMonth/${month+1}/$year"
                dateText?.text = selectedDate

                // calculate age
                val birthDate = sdf.parse(selectedDate) // in order to parse string, format of string and declared format should be same
                birthDate?.let {
                    val birthDateInMillis = birthDate.time
                    val birthDateInMin = birthDateInMillis/60000
                    val currentDateInMillis = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDateInMillis?.let{
                        val currentDateInMin = currentDateInMillis.time/60000
                        val ageInMin = currentDateInMin - birthDateInMin
                        ageInMinutesText?.text = ageInMin.toString()
                    }
                }

            }
            val dpd = DatePickerDialog(this, datePicker, cYear, cMonth, cDay)
            dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
            dpd.show()
        }

    }

    // creating a function outside onCreate fun
    fun bdateToBinary(bdate : Long){
        var bdate = bdate
        var binaryNum = arrayOfNulls<Long>(32)
        var i = 0
        while (bdate > 0) {
            binaryNum[i] = bdate % 2
            bdate /= 2
            i++
        }
        for (j in i-1 downTo 0){
            print(binaryNum[j])
        }
    }
}