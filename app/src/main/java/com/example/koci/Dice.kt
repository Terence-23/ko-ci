package com.example.koci

import kotlin.random.Random

class Dice constructor(val walls: Int, val count: Int){

    fun roll(): List<Int>{
        return List(count) { Random.nextInt(1, walls+1)}
    }

}