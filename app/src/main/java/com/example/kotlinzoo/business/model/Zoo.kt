package com.example.kotlinzoo.business.model

open class Zoo {

    val zooName: String
    var animalList: MutableList<Animal> = mutableListOf<Animal>()

    constructor(name: String) {
        this.zooName = name
    }

}