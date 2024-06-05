package com.example.carmvvm.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carmvvm.R
import com.example.carmvvm.Resource
import com.example.carmvvm.adapter.CustomVehicleAdapter
import com.example.carmvvm.viewmodel.vehicleviewmodel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "Asset Telematics"
    private lateinit var adapter: CustomVehicleAdapter
    private val vehicleviewmodel: vehicleviewmodel by viewModels()
//    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(binding.root)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val btNext = findViewById<Button>(R.id.btNext)

        recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerview.setLayoutManager(
            GridLayoutManager(this, 3)
        )
        adapter = CustomVehicleAdapter(arrayListOf())
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        vehicleviewmodel.vehiclelists.observe(
            this
        ) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { _ ->
                        adapter = CustomVehicleAdapter(it.data.vehicleType)
                        recyclerview.adapter = adapter
                        adapter.updateVehicleList(btNext)
                    } ?: run {
                        Log.i(TAG, it.message ?: ("No Data Found"))
                    }
                }
                Resource.Status.ERROR -> Log.i(TAG, it.message ?: ("error message"))

                Resource.Status.LOADING -> {
                    Log.i(TAG, it.message ?: ("loading..."))
                }
            }
        }
    }
}