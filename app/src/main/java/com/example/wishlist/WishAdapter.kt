package com.example.wishlist

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(private val wishes: ArrayList<WishItem>) : RecyclerView.Adapter<WishAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val nameTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            nameTextView = itemView.findViewById(R.id.wish_name)
            priceTextView = itemView.findViewById(R.id.wish_price)
            urlTextView = itemView.findViewById(R.id.wish_url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false) // or wish_item
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Populate data into the item through the holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wish = wishes[position]

        // Set item views based on views and data model
        holder.nameTextView.text = wish.item_name
        holder.priceTextView.text = wish.item_price.toString()
        holder.urlTextView.text = wish.item_url

//        //check if bought
//        val isWishBought = wish.isBought
//        if(!isWishBought){
//            holder.nameTextView.setTypeface(null, Typeface.ITALIC)
//            holder.priceTextView.setTypeface(null, Typeface.ITALIC)
//            holder.urlTextView.setTypeface(null, Typeface.ITALIC)
        }

    override fun getItemCount(): Int {
        return wishes.size
    }
}