package com.sariaydinalparslan.museummaps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Sayfa2(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.primary)){
        WelcomeBackground()
        Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceEvenly, Alignment.CenterHorizontally) {
            Card1(navController)
            Spacer(modifier = Modifier.padding(15.dp))
            Card2(navController)
            Spacer(modifier = Modifier.padding(15.dp))
            Card3(navController)
            Spacer(modifier = Modifier.padding(15.dp))
            Card4(navController)
        }
    }
}
@Composable
fun Card4(navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(55.dp),
        elevation = 15.dp
    ) {
        Box(modifier = Modifier
            .size(150.dp, 150.dp)
            .clickable { navController.navigate("mapscreen4") }) {
            Image(
                painter = painterResource(id =R.drawable.america1), contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(text = "AMERICA", style = TextStyle(color = Color.Black, fontSize = 20.sp))
            }
        }

    }
}

@Composable
fun Card3(navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(55.dp),
        elevation = 15.dp
    ) {
        Box(modifier = Modifier
            .size(150.dp, 150.dp)
            .clickable { navController.navigate("mapscreen3") }) {
            Image(
                painter = painterResource(id = R.drawable.asia3), contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(text = "ASIA", style = TextStyle(color = Color.Black, fontSize = 20.sp))
            }
        }

    }
}


@Composable
fun Card2(navController: NavController) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { navController.navigate("mapscreen2") }, shape = RoundedCornerShape(55.dp), elevation = 15.dp) {
        Box(modifier = Modifier
            .size(150.dp, 150.dp)
        ) {
            Image(
                painter = painterResource(id =  R.drawable.africa1), contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(text = "AFRICA", style = TextStyle(color = Color.Black, fontSize = 20.sp))
            }
        }

    }
}

@Composable
fun Card1(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(25.dp)
    ) {

    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(55.dp),
        elevation = 15.dp
    ) {
        Box(modifier = Modifier
            .size(150.dp, 150.dp)
            .clickable {
                navController.navigate("mapscreen")
            }) {
            Image(
                painter = painterResource(id = com.sariaydinalparslan.museummaps.R.drawable.europe4), contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Text(text = "EUROPE", style = TextStyle(color = Color.Black, fontSize = 20.sp))
            }
        }

    }
}

@Composable
private fun WelcomeBackground() {
    Image(
        painterResource(id =  com.sariaydinalparslan.museummaps.R.drawable.zircon), contentDescription = "background",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()

    )
}



