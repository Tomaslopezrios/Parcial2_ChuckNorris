package com.tomaslopezrios.parcial2_chucknorris

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.squareup.picasso.Picasso
import com.tomaslopezrios.parcial2_chucknorris.databinding.ActivityJokesSelectedDetailBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.random.Random.Default.nextInt

class JokesSelectedDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_category = "category"
    }

    private lateinit var binding: ActivityJokesSelectedDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokesSelectedDetailBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra(EXTRA_category).orEmpty()
        getRandomByCategory(category)
    }

    private fun getRandomByCategory(category: String) {

        binding.progressBar.isVisible = true

        CoroutineScope(Dispatchers.IO).launch {
            val joke = getRetrofit().create(ApisService::class.java)
                .getRandomByCategory("random?category=$category")

            Log.i("Tomas", joke.body().toString())

            if (joke.isSuccessful) {
                Log.i("Tomas", "Joke Random By Category : funciona :)")

                if (joke.body() != null) {
                    Log.i("Tomas", joke.body().toString())
                    runOnUiThread {
                        createUI(joke.body()!!, category)
                        binding.progressBar.isVisible = false
                    }
                }
            } else Log.i("Tomas", "Joke Random By Category : No response")
        }
    }

    private fun createUI(joke: JokesRandomResponseByCategory, category: String) {

        binding.tvCategoryName.text = category.uppercase()
        binding.tvJokeValue.text = joke.value
        Picasso.get().load(
            BeautyProvider.ChuckNorrisImages[nextInt(
                0, BeautyProvider.ChuckNorrisImages.size
            )].urlPhoto
        ).into(binding.ivChuckNorris)

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}