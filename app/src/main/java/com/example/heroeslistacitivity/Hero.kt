package com.example.heroeslistacitivity

//val if the data is probably never going to be changed, var if it is

data class Hero(
    val name : String,
    val description : String,
    val superpower : String,
    val ranking : Int,
    val image : String
)
