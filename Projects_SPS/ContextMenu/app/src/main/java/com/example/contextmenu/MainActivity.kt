package com.example.contextmenu

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var contextButton: Button
    private lateinit var mainLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contextButton = findViewById(R.id.contextButton)
        mainLayout = findViewById(R.id.mainLayout)

        registerForContextMenu(contextButton)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)

        // Enable icons in the context menu
        try {
            val field = Menu::class.java.getDeclaredField("setOptionalIconsVisible")
            field.isAccessible = true
            field.setBoolean(menu, true)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_text -> {
                contextButton.setTypeface(contextButton.typeface, Typeface.BOLD)
                true
            }
            R.id.option_color -> {
                contextButton.setBackgroundColor(Color.YELLOW)
                true
            }
            R.id.option_background -> {
                mainLayout.setBackgroundResource(R.drawable.ic_background)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
