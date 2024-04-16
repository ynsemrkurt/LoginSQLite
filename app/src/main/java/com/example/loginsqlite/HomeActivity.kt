package com.example.loginsqlite

import FruitsAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginsqlite.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fruits= listOf("Banana", "Apple", "Orange", "Mango", "Grapes","Strawberry","Mandarin")
        binding.fruitsRecycleView.layoutManager= LinearLayoutManager(this)
        binding.fruitsRecycleView.adapter=FruitsAdapter(fruits)
    }
}