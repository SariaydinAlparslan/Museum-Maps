package com.sariaydinalparslan.museummaps

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun Splash(navController:NavController){
    val scale= remember { Animatable(0f) }
    LaunchedEffect(key1 = true ) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis =500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate("sayfa1")
    }
    Box(modifier = Modifier.fillMaxSize().background(color = Color.White), Alignment.Center) {
        Image(painter = painterResource(id = com.sariaydinalparslan.museummaps.R.drawable.logo), contentDescription = "SplashScreen",
            modifier = Modifier.width(1000.dp).height(1000.dp).scale(scale.value).background(color = Color.Transparent))

    }


}
