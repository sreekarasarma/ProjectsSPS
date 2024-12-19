package com.example.weekendassignmentglider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = productList[position]
        holder.bind(currentProduct)
    }

    override fun getItemCount(): Int = productList.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName = itemView.findViewById<TextView>(R.id.productName)
        private val productType = itemView.findViewById<TextView>(R.id.productType)
        private val productCost = itemView.findViewById<TextView>(R.id.productCost)
        private val productImage = itemView.findViewById<ImageView>(R.id.productImage)

        fun bind(product: Product) {
            productName.text = product.name
            productType.text = product.type
            productCost.text = product.cost

        }
    }
}
