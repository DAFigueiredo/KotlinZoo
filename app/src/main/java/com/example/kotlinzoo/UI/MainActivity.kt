package com.example.kotlinzoo.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinzoo.R
import com.example.kotlinzoo.business.enumerations.FamilyType
import com.example.kotlinzoo.business.enumerations.FoodType
import com.example.kotlinzoo.business.enumerations.SexType
import com.example.kotlinzoo.business.model.Animal
import com.example.kotlinzoo.business.model.Zoo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        var zoo1: Zoo = Zoo("Parkland")

        zoo1.animalList.add(gorilla1)
        zoo1.animalList.add(orangutan1)
        zoo1.animalList.add(lion1)
        zoo1.animalList.add(lion2)
        zoo1.animalList.add(eagle1)
        zoo1.animalList.add(lizard1)

    }

    override fun onResume() {
        super.onResume()



    }
}