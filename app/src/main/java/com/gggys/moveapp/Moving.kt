package com.gggys.moveapp

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Move(){

    val duration = 500
    var offx = remember {
        mutableStateOf(40f)
    }
    var offy = remember {
        mutableStateOf(40f)
    }

    var translationX = animateFloatAsState(
        offx.value,
        animationSpec = tween(duration, 0, FastOutLinearInEasing)

    )
    var translationY = animateFloatAsState(
        offy.value,
        animationSpec = tween(duration, 0, FastOutLinearInEasing)
    )
    Box(modifier = Modifier.fillMaxSize()) {

        Map(offx, offy)
        Worker(translationX = offx, translationY = offy)

    }
}