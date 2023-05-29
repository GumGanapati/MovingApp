package com.gggys.moveapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gggys.moveapp.ui.theme.Green21

@Composable
fun Field(number:Int, offX: Float, offY: Float,
          translationX: MutableState<Float>, translationY: MutableState<Float>){

    Box(modifier = Modifier
        .size(60.dp, 75.dp)
        .clip(RoundedCornerShape(12.dp))
        .background(Green21.copy(0.5f))
        .border(1.dp, Green21, RoundedCornerShape(12.dp))
        .clickable {
            translationX.value = offX
            translationY.value = offY
        }
        .padding(8.dp),
    contentAlignment = Alignment.Center) {
        Text(text = "$offX  $offY", fontSize = 16.sp)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Map(translationX: MutableState<Float>,
        translationY: MutableState<Float>){

     val bicycle = 60
    var sizeY by remember {
        mutableStateOf(IntSize.Zero)
    }

    LazyVerticalGrid(cells = GridCells.Fixed(4),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {

                sizeY = it.size

            }
            .background(Color.Black),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp)){

        val myList = listgenerator(sizeY.width, sizeY.height, bicycle)
        for (i in myList){
            item { Field(number = i.fieldNumber, offX = i.offX, offY = i.offY,
                translationX,translationY) }
        }
    }
}

