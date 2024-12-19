package com.example.jsondemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(private val employeeList: List<Employee>) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.textName.text = employee.name
        holder.textEmail.text = employee.email
        holder.textPhone.text = employee.phone
        holder.textDesignation.text = employee.designation
    }

    override fun getItemCount() = employeeList.size

    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textName)
        val textEmail: TextView = itemView.findViewById(R.id.textEmail)
        val textPhone: TextView = itemView.findViewById(R.id.textPhone)
        val textDesignation: TextView = itemView.findViewById(R.id.textDesignation)
    }
}
