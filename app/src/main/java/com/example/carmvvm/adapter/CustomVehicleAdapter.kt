package com.example.carmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carmvvm.R
import com.example.myapplication.model.VehicleTypeX

class CustomVehicleAdapter(private var list: List<VehicleTypeX>?) :
    RecyclerView.Adapter<CustomVehicleAdapter.ViewHolder>() {

    private var expanded = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vehicleName = list?.get(position)
        holder.textView.text = vehicleName?.text
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
//        return if (expanded) list?.size!! else 3
    }

    fun updateVehicleList(expandbutton: Button) {
        expandbutton.setOnClickListener{

        }
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.carname)
    }
}