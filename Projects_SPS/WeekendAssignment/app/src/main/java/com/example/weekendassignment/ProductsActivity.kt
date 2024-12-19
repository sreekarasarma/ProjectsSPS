package com.example.weekendassignment

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private val productList = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        recyclerView = findViewById(R.id.productRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(productList)
        recyclerView.adapter = productAdapter

        val addProductButton: FloatingActionButton = findViewById(R.id.addProductButton)
        addProductButton.setOnClickListener { showAddProductDialog() }
    }

    private fun showAddProductDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_product, null)

        val nameInput: EditText = dialogView.findViewById(R.id.nameInput)
        val typeInput: EditText = dialogView.findViewById(R.id.typeInput)
        val costInput: EditText = dialogView.findViewById(R.id.costInput)
        val addButton: Button = dialogView.findViewById(R.id.addButton)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val type = typeInput.text.toString()
            val cost = costInput.text.toString()

            if (name.isNotEmpty() && type.isNotEmpty() && cost.isNotEmpty()) {
                val product = Product(name, type, cost)
                productList.add(product)
                productAdapter.notifyDataSetChanged()
                Toast.makeText(this, "Product Added!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            } else {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()
    }
}
