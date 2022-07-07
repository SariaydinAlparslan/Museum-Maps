package com.sariaydinalparslan.museummaps

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sariaydinalparslan.museummaps.ui.theme.MuseumMapsTheme
import com.sariaydinalparslan.museummaps.ui.theme.museumTypee
import com.sariaydinalparslan.museummaps.ui.theme.oswald
import com.sariaydinalparslan.museummaps.ui.theme.parisType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuseumMapsTheme() {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    SayfaGeçişleri()
                }
            }
        }
    }
}

@Composable
fun SayfaGeçişleri() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "splash"){
        composable("splash"){
            Splash(navController = navController)
        }
        composable("sayfa1"){
            Sayfa1(navController = navController)
        }
        composable("sayfa2"){
            Sayfa2(navController = navController)
        }
        composable("mapscreen"){
            MapScreen(navController = navController)
        }
        composable("mapscreen2"){
            MapScreen2(navController = navController)
        }
        composable("mapscreen3"){
            MapScreen3(navController = navController)
        }
        composable("mapscreen4"){
            MapScreen4(navController = navController)
        }

    }
}
@Composable
fun Sayfa1(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.primary)){
        WelcomeBackground()
        WelcomeScreenContent()
        Column {

        }
        Box(modifier = Modifier, contentAlignment = Alignment.BottomCenter) {
            Button(onClick = {navController.navigate("sayfa2")
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black), modifier = Modifier.padding(top = 600.dp, start = 150.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = "Start", fontSize = 25.sp, fontFamily = museumTypee, color = Color.DarkGray,)
            }
        }


    }
    val activity=(LocalContext.current as Activity)
    BackHandler(onBack = {
        activity.finish()

    })

}
@Composable
private fun WelcomeScreenContent() {
    Box(modifier = Modifier
        .padding(all = 32.dp)
        .fillMaxWidth(), contentAlignment = Alignment.TopEnd
    ) {
        Icon(painter = painterResource(id = R.drawable.walk_walk),
            contentDescription = "walk")
    }
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(45.dp))
        Text(text = "Explore The World", modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp, start = 30.dp), fontFamily = oswald,
            fontSize = 35.sp, color = Color.Black)
        Spacer(modifier = Modifier.padding(25.dp))
        val painter= painterResource(id = R.drawable.paris)
        val description = "Paris"
        val title = "PARIS"
        Box(modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(25.dp)){
            ImageCard(painter = painter, contentDescriptor = description, title =title )
        }
        Spacer(modifier = Modifier.padding(25.dp))
        Text(text = "Museum Maps", modifier = Modifier.padding(horizontal = 100.dp, vertical = 15.dp),
            color = Color.Black, fontFamily = museumTypee, fontSize = 25.sp)

    }
}
@Composable
fun ImageCard (painter: Painter,
               contentDescriptor: String,
               title : String){
    Card(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(55.dp),
        elevation = 15.dp
    ) {
        Box(modifier = Modifier.size(800.dp,200.dp)){
            Image(painter = painter, contentDescription = contentDescriptor,
                contentScale = ContentScale.FillBounds
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent))
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
                contentAlignment = Alignment.TopEnd){
                Text(title,style= TextStyle(color = Color.Black, fontSize = 20.sp), fontFamily = parisType)
            }
        }

    }

}
@Composable
private fun WelcomeBackground() {
    Image(
        painterResource(id = R.drawable.zircon), contentDescription = "background",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()

    )
}


