package com.example.alertdialog

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var alertDialogButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alertDialogButton = findViewById(R.id.alertDialogButton)


        alertDialogButton.setOnClickListener {

            val alertDialogFragment = AlertDialogFragment()
            alertDialogFragment.show(supportFragmentManager, "alertDialog")
        }
    }
}
