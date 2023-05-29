package com.gggys.moveapp

import com.gggys.moveapp.buisnes.offsetXGeneration
import com.gggys.moveapp.buisnes.offsetYGeneration

data class DataItem(
    val fieldNumber: Int,
    val offX: Float,
    val offY: Float
)

fun listgenerator(w: Int, h: Int, size: Int):MutableList<DataItem>{
    var fieldList = mutableListOf<DataItem>()

    for (i in 1..32){
        fieldList.add(DataItem(i, offsetXGeneration(i, w, size), offsetYGeneration(i, h, size)))
    }

    return fieldList
}

