package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var wishes: ArrayList<WishItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val wishesRv = findViewById<RecyclerView>(R.id.wishesRv)

        //click the button
        findViewById<Button>(R.id.button).setOnClickListener {

            val wishName = findViewById<EditText>(R.id.name).text.toString()
            val wishPrice = findViewById<EditText>(R.id.price).text.toString().toDouble()
            val wishUrl = findViewById<EditText>(R.id.url).text.toString()

            //val newWishes = WishFetcher.getWishes()
            val newWishes = WishItem(wishName, wishPrice, wishUrl, true)
            // Add new wishes to existing list
            wishes.add(newWishes)

            val adapter = WishAdapter(wishes)
            wishesRv.adapter = adapter
            wishesRv.layoutManager = LinearLayoutManager(this)

            // Clear input fields
            findViewById<EditText>(R.id.name).setText("")
            findViewById<EditText>(R.id.price).setText("")
            findViewById<EditText>(R.id.url).setText("")
        }
    }
}
