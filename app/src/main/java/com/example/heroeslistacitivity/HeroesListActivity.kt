package com.example.heroeslistacitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroeslistacitivity.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroesListBinding
    lateinit var adapter: HeroAdapter

    companion object{
        val TAG = "HeroesListActivity"
    }


    lateinit var convertList : List<Hero>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Make a Hero.kt data class
        // TODO: Load the heroes.json into a List<Hero> using Gson
        // TODO: Make a item_hero.xml layout file in the layout folder
        // TODO: this is the template for what each item in the list will look like
        // TODO: make the root element a constraint layout, make some textviews for the ranking, name, and desc
        // TODO: Make a HeroAdapter.kt class modeled after the CustomAdapter from the documentation

        // reading the json from the raw folder
        // remember to add gson dependency in project library when using gson to convert json

        val inputStream = resources.openRawResource(R.raw.heroes)
        //step 2: use a buffered reader on the inputsream ro read the text into a string
        val jsonText = inputStream.bufferedReader().use {
            // the last line of the use function is returned
            it.readText()
        }
        Log.d(TAG, "onCreate: $jsonText")

        // use gson to convert the jsonText into a List<Question>
        // check the section called "Parsing between a Collection, list, or Array
        // log the list of questions and see if your Question objects all appear correct

        val qType = object : TypeToken<List<Hero>>() {}.type
        convertList = Gson().fromJson<List<Hero>>(jsonText, qType)
        Log.d(TAG, "onCreate: $convertList")

        // create our adapter and fill the recycler view
        adapter = HeroAdapter(convertList)
        binding.recyclerViewHeroesList.adapter = adapter
        binding.recyclerViewHeroesList.layoutManager = LinearLayoutManager(this)

    }
}

