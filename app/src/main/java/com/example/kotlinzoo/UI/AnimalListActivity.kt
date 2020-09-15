package com.example.kotlinzoo.UI

import android.os.Bundle
import androidx.core.widget.NestedScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.kotlinzoo.R
import com.example.kotlinzoo.business.enumerations.FamilyType
import com.example.kotlinzoo.business.enumerations.FoodType
import com.example.kotlinzoo.business.enumerations.SexType
import com.example.kotlinzoo.business.model.Animal
import com.example.kotlinzoo.business.model.Zoo
import kotlinx.android.synthetic.main.animal_list.*

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [AnimalDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class AnimalListActivity : AppCompatActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    var zoo: Zoo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        var gorilla1: Animal = Animal("Harambe", SexType.Male, "Silverback Gorilla", FamilyType.Mammal, FoodType.Omnivore)
        gorilla1.imageURL = "https://lorempixel.com/400/200/animals/"
        var orangutan1: Animal = Animal("Elfriede", SexType.Female, "Orangutan", FamilyType.Mammal, FoodType.Omnivore)
        orangutan1.imageURL = "https://lorempixel.com/400/200/animals/"
        var lion1: Animal = Animal("Simba", SexType.Male, "Lion", FamilyType.Mammal, FoodType.Carnivore)
        lion1.imageURL = "https://lorempixel.com/400/200/animals/"
        var lion2: Animal = Animal("Nala", SexType.Female, "Lion", FamilyType.Mammal, FoodType.Carnivore)
        lion2.imageURL = "https://lorempixel.com/400/200/animals/"
        var eagle1: Animal = Animal("Thorondor", SexType.Unknown, "Harpy Eagle", FamilyType.Bird, FoodType.Carnivore)
        eagle1.imageURL = "https://lorempixel.com/400/200/animals/"
        var lizard1: Animal = Animal("Smaug", SexType.Unknown, "Komodo Dragon", FamilyType.Reptile, FoodType.Carnivore)
        lizard1.imageURL = "https://lorempixel.com/400/200/animals/"

        zoo = Zoo("Parkland")

        zoo?.let {

            it.animalList.add(gorilla1)
            it.animalList.add(orangutan1)
            it.animalList.add(lion1)
            it.animalList.add(lion2)
            it.animalList.add(eagle1)
            it.animalList.add(lizard1)

        }
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            var lizard2: Animal = Animal("Lagarto", SexType.Male, "Osga", FamilyType.Reptile, FoodType.Other)
            zoo?.animalList?.add(lizard2)

            recyclerView_animal_list.adapter?.notifyDataSetChanged()

        }

        if (findViewById<NestedScrollView>(R.id.animal_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        setupRecyclerView(recyclerView_animal_list)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        zoo?.animalList?.let { animalList: MutableList<Animal> ->

            recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, animalList, twoPane)
        }
    }

    class SimpleItemRecyclerViewAdapter(
        private val parentActivity: AnimalListActivity,
        private val values: MutableList<Animal>,
        private val twoPane: Boolean
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
//                val item = v.tag as DummyContent.DummyItem
//                if (twoPane) {
//                    val fragment = AnimalDetailFragment().apply {
//                        arguments = Bundle().apply {
//                            putString(AnimalDetailFragment.ARG_ITEM_ID, item.id)
//                        }
//                    }
//                    parentActivity.supportFragmentManager
//                        .beginTransaction()
//                        .replace(R.id.animal_detail_container, fragment)
//                        .commit()
//                } else {
//                    val intent = Intent(v.context, AnimalDetailActivity::class.java).apply {
//                        putExtra(AnimalDetailFragment.ARG_ITEM_ID, item.id)
//                    }
//                    v.context.startActivity(intent)
//                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.animal_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val animal = values[position]
            holder.idView.text = animal.name
            holder.contentView.text = animal.getDescription()

            with(holder.itemView) {
                tag = animal
                setOnClickListener(onClickListener)
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idView: TextView = view.findViewById(R.id.id_text)
            val contentView: TextView = view.findViewById(R.id.content)
        }
    }
}