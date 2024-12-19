package com.example.optionsmenuapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_call -> {
                val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9182461554"))
                startActivity(callIntent)
                return true
            }
            R.id.menu_launch -> {
                val launchIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com"))
                startActivity(launchIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}