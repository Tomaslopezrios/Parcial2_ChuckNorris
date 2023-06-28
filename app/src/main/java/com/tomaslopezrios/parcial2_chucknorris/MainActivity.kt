package com.tomaslopezrios.parcial2_chucknorris

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.squareup.picasso.Picasso
import com.tomaslopezrios.parcial2_chucknorris.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()

    }

    private fun initUI() {

        getRandomJoke()
        Picasso.get().load(BeautyProvider.MainLogo).into(binding.ivLogo)



        binding.btnOtherRandomJoke.setOnClickListener {
            getRandomJoke()
        }

        binding.btnGoCategory.setOnClickListener {
            navigateToJokesCategories()
        }

    }

    private fun getRandomJoke() {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<JokesRandomResponse> =
                retrofit.create(ApisService::class.java).getRandom()

            if (myResponse.isSuccessful) {
                Log.i("Tomas", "getRandomJoke: funciona :)")

                val response: JokesRandomResponse? = myResponse.body()

                if (response != null) {
                    Log.i("Tomas", response.toString())
                    runOnUiThread {
                        binding.progressBar.isVisible = false
                        binding.tvRandomJoke.text = response.value
                    }
                }
            } else Log.i("Tomas", "getRandomJoke :No response")
        }
    }

    private fun navigateToJokesCategories() {
        val intent = Intent(this, JokesCategoriesActivity::class.java)
        startActivity(intent)
    }


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}