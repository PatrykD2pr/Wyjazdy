package com.example.wyjazdy

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.temporal.ChronoField
import java.util.Calendar
import java.util.Date
import kotlin.time.Duration.Companion.days

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var current = LocalDateTime.now()
        var dzien = current.get(ChronoField.DAY_OF_MONTH)
        var miesiac = current.get(ChronoField.MONTH_OF_YEAR)
        var year = current.get(ChronoField.YEAR)
        var data = dzien.toString() + " " + miesiac.toString() + " " + year.toString()
        
        var wyjazd = findViewById<CalendarView>(R.id.wyjazd)
        var powrot = findViewById<CalendarView>(R.id.powrot)

        var dzien_w = dzien
        var mies_w = miesiac
        var rok_w = year
        var data_w = data

        var dzien_p = dzien
        var mies_p = miesiac
        var rok_p = year
        var data_p = data

        wyjazd.setOnDateChangeListener { wyjazd, i, i2, i3 ->
            rok_w = i
            mies_w = (i2 + 1)
            dzien_w = i3
            data_w = dzien_w.toString() + " " + mies_w.toString() + " " + rok_w.toString()
        }

        powrot.setOnDateChangeListener { powrot, i, i2, i3 ->
            rok_p = (i + 1)
            mies_p = i2
            dzien_p = i3
            data_p = dzien_p.toString() + " " + mies_p.toString() + " " + rok_p.toString()
        }

        var pay = findViewById<Button>(R.id.confirm)

        pay.setOnClickListener {

            if (dzien_w < dzien && mies_w == miesiac && rok_w == year)
            {
                var toast = Toast.makeText(applicationContext,"Nie można wprowadzić daty wyjazdu wcześniejszej niż teraz",Toast.LENGTH_SHORT)
                toast.show()
            }
            if (rok_w > rok_p + 2)
            {
                var toast = Toast.makeText(applicationContext,"Termin wyjazdu ograniczony do 2 lat",Toast.LENGTH_SHORT)
                toast.show()
            }

            var len_d = dzien_p - dzien_w
            if (mies_p > mies_w)
            {
                var il = mies_p - mies_w
                len_d += 30 * il
            }
            if (rok_p > rok_w) // Nie dziala
            {
                var ilo = rok_p - rok_w
                len_d += 360 * ilo
            }

            var len:String = "Dni: " + len_d.toString()

            findViewById<TextView>(R.id.textView).text = len
        }
    }
}