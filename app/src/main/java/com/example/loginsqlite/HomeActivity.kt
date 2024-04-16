package com.example.loginsqlite

import FruitsAdapter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginsqlite.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    val fruits: MutableList<String> = mutableListOf("Banana", "Apple", "Orange", "Mango", "Grapes","Strawberry","Mandarin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterList()
    }

    fun addFruit(view: View) {
        val fruitName=binding.addFruitEditText.text.toString().trim()
        if(fruitName.isNotEmpty()){
            fruits.add(fruitName)
            adapterList()
            binding.addFruitEditText.text.clear()
        }
    }

    fun adapterList(){
        binding.fruitsRecycleView.layoutManager= LinearLayoutManager(this)
        binding.fruitsRecycleView.adapter=FruitsAdapter(fruits)
    }
}