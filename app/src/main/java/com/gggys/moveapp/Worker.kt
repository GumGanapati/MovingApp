package com.gggys.moveapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Worker(translationX: MutableState<Float>,translationY: MutableState<Float>){
Image(painter = painterResource(id = R.drawable.ic_baseline_directions_bike_24),
    contentDescription = null,
    modifier = Modifier.size(60.dp)
        .graphicsLayer(
            translationX = translationX.value,
            translationY = translationY.value,
        ))
}