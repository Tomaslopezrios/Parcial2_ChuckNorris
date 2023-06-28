package com.tomaslopezrios.parcial2_chucknorris

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tomaslopezrios.parcial2_chucknorris.databinding.ItemJokeCategoryBinding
import kotlin.math.log

class JokesCategoriesViewHolder(view : View) : RecyclerView.ViewHolder(view){

    private val binding = ItemJokeCategoryBinding.bind(view)

    fun bind( category : String, image : String ,onItemSelect: (String) -> Unit){
        binding.tvCategoryName.text = category.uppercase()
        Picasso.get().load(image).into(binding.ivCategory)
        itemView.setOnClickListener {onItemSelect(category)}
    }
}