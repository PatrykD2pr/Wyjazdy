package com.example.wyjazdy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Nie potrzebne (do tego projektu) zmienne
        var imie = findViewById<TextView>(R.id.imie)
        var nazwisko = findViewById<TextView>(R.id.nazwisko)
        var wiek = findViewById<TextView>(R.id.wiek)

        // Potrzebne zmienne
        var wyjazd = findViewById<CalendarView>(R.id.wyjazd)
        var powrot = findViewById<CalendarView>(R.id.powrot)
        var from = findViewById<TextView>(R.id.skad)
        var where = findViewById<TextView>(R.id.dokad)
        var pay = findViewById<Button>(R.id.confirm)

    }
}