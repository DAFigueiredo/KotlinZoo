package com.example.kotlinzoo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinzoo.R
import com.example.kotlinzoo.business.enumerations.FamilyType
import com.example.kotlinzoo.business.enumerations.FoodType
import com.example.kotlinzoo.business.enumerations.SexType
import com.example.kotlinzoo.business.model.Animal
import com.example.kotlinzoo.business.model.Zoo
import com.example.kotlinzoo.ui.adapter.AnimalRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_animal_list.*
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
    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z')

    private var animalNameList = mutableListOf<String>(
        "Aardvark", "Albatross", "Alligator", "Alpaca", "Ant", "Anteater", "Antelope", "Ape", "Armadillo", "Donkey", "Baboon", "Badger", "Barracuda", "Bat", "Bear", "Beaver", "Bee", "Bison", "Boar", "Buffalo", "Butterfly", "Camel", "Capybara", "Caribou", "Cassowary", "Cat", "Caterpillar", "Cattle", "Chamois", "Cheetah", "Chicken", "Chimpanzee", "Chinchilla", "Chough", "Clam", "Cobra", "Cockroach", "Cod",
        "Cormorant", "Coyote", "Crab", "Crane", "Crocodile", "Crow", "Curlew", "Deer", "Dinosaur", "Dog", "Dogfish", "Dolphin", "Dotterel", "Dove", "Dragonfly", "Duck", "Dugong", "Dunlin", "Eagle", "Echidna", "Eel", "Eland", "Elephant", "Elk", "Emu", "Falcon", "Ferret", "Finch", "Fish", "Flamingo", "Fly", "Fox", "Frog", "Gaur", "Gazelle", "Gerbil", "Giraffe", "Gnat", "Gnu", "Goat", "Goldfinch",
        "Goldfish", "Goose", "Gorilla", "Goshawk", "Grasshopper", "Grouse", "Guanaco", "Gull", "Hamster", "Hare", "Hawk", "Hedgehog", "Heron", "Herring", "Hippopotamus", "Hornet", "Horse", "Human", "Hummingbird", "Hyena", "Ibex", "Ibis", "Jackal", "Jaguar", "Jay", "Jellyfish", "Kangaroo", "Kingfisher", "Koala", "Kookabura", "Kouprey", "Kudu", "Lapwing", "Lark", "Lemur", "Leopard", "Lion",
        "Llama", "Lobster", "Locust", "Loris", "Louse", "Lyrebird", "Magpie", "Mallard", "Manatee", "Mandrill", "Mantis", "Marten", "Meerkat", "Mink", "Mole", "Mongoose", "Monkey", "Moose", "Mosquito", "Mouse", "Mule", "Narwhal", "Newt", "Nightingale", "Octopus", "Okapi", "Opossum", "Oryx", "Ostrich", "Otter", "Owl", "Oyster", "Panther", "Parrot", "Partridge", "Peafowl", "Pelican",
        "Penguin", "Pheasant", "Pig", "Pigeon", "Pony", "Porcupine", "Porpoise", "Quail", "Quelea", "Quetzal", "Rabbit", "Raccoon", "Rail", "Ram", "Rat", "Raven", "Red deer", "Red panda", "Reindeer", "Rhinoceros", "Rook", "Salamander", "Salmon", "Sand Dollar", "Sandpiper", "Sardine", "Scorpion", "Seahorse", "Seal", "Shark", "Sheep", "Shrew", "Skunk", "Snail", "Snake", "Sparrow", "Spider",
        "Spoonbill", "Squid", "Squirrel", "Starling", "Stingray", "Stinkbug", "Stork", "Swallow", "Swan", "Tapir", "Tarsier", "Termite", "Tiger", "Toad", "Trout", "Turkey", "Turtle", "Viper", "Vulture", "Wallaby", "Walrus", "Wasp", "Weasel", "Whale", "Wildcat", "Wolf", "Wolverine", "Wombat", "Woodcock", "Woodpecker", "Worm", "Wren", "Yak", "Zebra"
    )

    private var zoo: Zoo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)
        setupZoo()
        setupView()
        setupRecyclerView(recyclerView_animal_list)
    }

    private fun setupView() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title

        fab.setOnClickListener { view ->

            val name = randomString(5)
            val sexType = SexType.values().toList().shuffled().first()
            val species = animalNameList.shuffled().first()
            val familyType = FamilyType.values().toList().shuffled().first()
            val foodType = FoodType.values().toList().shuffled().first()
            val animal: Animal = Animal(name, sexType, species, familyType, foodType)
            zoo?.animalList?.add(animal)

            recyclerView_animal_list.adapter?.notifyDataSetChanged()
        }

        if (animal_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }
    }

    private fun setupZoo() {
        val gorilla1: Animal = Animal("Harambe", SexType.Male, "Silverback Gorilla", FamilyType.Mammal, FoodType.Omnivore)
        gorilla1.imageURL = "https://lorempixel.com/400/200/animals/"

        val orangutan1: Animal = Animal("Elfriede", SexType.Female, "Orangutan", FamilyType.Mammal, FoodType.Omnivore)
        orangutan1.imageURL = "https://lorempixel.com/400/200/animals/"

        val lion1: Animal = Animal("Simba", SexType.Male, "Lion", FamilyType.Mammal, FoodType.Carnivore)
        lion1.imageURL = "https://lorempixel.com/400/200/animals/"

        val lion2: Animal = Animal("Nala", SexType.Female, "Lion", FamilyType.Mammal, FoodType.Carnivore)
        lion2.imageURL = "https://lorempixel.com/400/200/animals/"

        val eagle1: Animal = Animal("Thorondor", SexType.Unknown, "Harpy Eagle", FamilyType.Bird, FoodType.Carnivore)
        eagle1.imageURL = "https://lorempixel.com/400/200/animals/"

        val lizard1: Animal = Animal("Smaug", SexType.Unknown, "Komodo Dragon", FamilyType.Reptile, FoodType.Carnivore)
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
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        zoo?.animalList?.let { animalList: MutableList<Animal> ->

            recyclerView.adapter = AnimalRecyclerViewAdapter(this, animalList, twoPane)
        }
    }

    private fun randomString(stringLength: Int): String {

        return (1..stringLength).map { _ -> kotlin.random.Random.nextInt(0, charPool.size) }.map(charPool::get).joinToString("")
    }
}