package com.example.kotlinzoo.business.model

import android.graphics.Bitmap
import com.example.kotlinzoo.business.enumerations.FamilyType
import com.example.kotlinzoo.business.enumerations.FoodType
import com.example.kotlinzoo.business.enumerations.SexType
import java.net.URL
import java.util.*

class Animal {

    var name: String = "To be named"
    var sex: SexType = SexType.Unknown
    val species: String
    var familyType: FamilyType = FamilyType.Other
    var foodType: FoodType = FoodType.Other
    private val birthDate: Date = Date()
    var imageURL: String? = null
    var image: Bitmap? = null

    constructor(name: String, sex: SexType, species: String, familyType: FamilyType, foodType: FoodType) {
        this.name = name
        this.sex = sex
        this.species = species
        this.familyType = familyType
        this.foodType = foodType
    }

    fun getAge(): Int {
        val age = Date().year - birthDate.year

        return age
    }

    fun getDescription(): String {
        return "the $name, is from $sex, and is a $foodType"
    }
}