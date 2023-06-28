package com.tomaslopezrios.parcial2_chucknorris

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomaslopezrios.parcial2_chucknorris.JokesSelectedDetailActivity.Companion.EXTRA_category
import com.tomaslopezrios.parcial2_chucknorris.databinding.ActivityJokesCategoriesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokesCategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJokesCategoriesBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: JokesCategoriesAdapter



            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokesCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {

        getJokeCategories()

        adapter = JokesCategoriesAdapter { navigateToDetail(it) }
        binding.rvCategoriesJokes.setHasFixedSize(true)
        binding.rvCategoriesJokes.layoutManager = LinearLayoutManager(this)
        binding.rvCategoriesJokes.adapter = adapter

    }


    private fun getJokeCategories() {
        binding.progressBar.isVisible = true

        CoroutineScope(Dispatchers.IO).launch {

            val myResponse = retrofit.create(ApisService::class.java).getCategories()
            val response = myResponse.body()

            if (myResponse.isSuccessful) {
                Log.i("Tomas", "getJokeCategories: funciona :)")

                if (response != null) {
                    Log.i("Tomas", response.toString())
                    runOnUiThread {
                        adapter.updateList(response)
                        binding.progressBar.isVisible = false
                    }
                }

            } else Log.i("Tomas", "getJokeCategories: No response")

        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToDetail(category: String) {
        val intent = Intent(this, JokesSelectedDetailActivity::class.java)
        Log.i("Tomas", "Categorias seleccionada $category")
        intent.putExtra(EXTRA_category, category)
        startActivity(intent)
    }
}