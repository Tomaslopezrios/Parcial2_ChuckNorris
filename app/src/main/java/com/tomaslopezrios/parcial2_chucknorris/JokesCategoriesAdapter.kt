package com.tomaslopezrios.parcial2_chucknorris

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random.Default.nextInt

class JokesCategoriesAdapter(
    var categoriesList: List<String> = emptyList(),
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<JokesCategoriesViewHolder>() {

    fun updateList(list: List<String>) {
        this.categoriesList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesCategoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return JokesCategoriesViewHolder(
            layoutInflater.inflate(
                R.layout.item_joke_category,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: JokesCategoriesViewHolder, position: Int) {

        holder.bind(
            categoriesList[position],
            BeautyProvider.ChuckNorrisImages[nextInt(0,BeautyProvider.ChuckNorrisImages.size)].urlPhoto,
            onItemSelected
        )
    }

    override fun getItemCount() = categoriesList.size

}

