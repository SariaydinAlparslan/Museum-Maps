package com.sariaydinalparslan.museummaps

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.sariaydinalparslan.museummaps.Viewmodel.MapViewModel
import com.sariaydinalparslan.museummaps.ui.theme.parisType

@Composable
fun MapScreen2(navController: NavController){
    val viewModel: MapViewModel = viewModel()
    val museumList = viewModel.museumlist.observeAsState(listOf())
    var mapProperties by remember { mutableStateOf(MapProperties(mapType = MapType.NORMAL)) }
    val cameraPositionState = rememberCameraPositionState { position =
        CameraPosition.fromLatLngZoom(LatLng(9.341831766966683, 7.8411663348575065), 5f) }
    GoogleMap(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        cameraPositionState = cameraPositionState,
        properties = mapProperties
    ) {
        museumList.value.forEach {
            val alpState = rememberMarkerState(position = LatLng(it.yemek_fiyat!!.toDouble(), it.yemek_resim_adi!!.toDouble()))
            MarkerInfoWindowContent(
                state = alpState,
                icon = BitmapDescriptorFactory.fromResource(R.drawable.muse24),
                title = it.yemek_adi,) {
                Column(modifier = Modifier.padding(2.dp)) {
                    Text(
                        it.title ?: "",
                        color = Color.Black,
                        fontFamily = FontFamily.Serif,
                        fontSize = 25.sp
                    )
                    Spacer(modifier = Modifier.padding(all = 3.dp))
                    Row(
                        modifier = Modifier
                            .padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.museum3),
                            contentDescription = "image"
                        )

                    }

                }
            }
        }

    }
    Column {
        Map2TypeControls(onMapTypeClick = {
            Log.d("GoogleMap", "Selected map type $it")
            mapProperties = mapProperties.copy(mapType = it)
        })
    }
}
@Composable
fun Map2TypeButton(type: MapType, onClick: () -> Unit) {
    Map2Button(text = type.toString(), onClick = onClick)
}

@Composable
fun Map2TypeControls(
    onMapTypeClick: (MapType) -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .horizontalScroll(state = ScrollState(0)),
        horizontalArrangement = Arrangement.Center
    ) {
        MapType.values().forEach {
            Map2TypeButton(type = it) { onMapTypeClick(it) }
        }
    }
}
@Composable
private fun Map2Button(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier.padding(4.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.Black
        ),
        onClick = onClick
    ) {
        Text(text = text, fontFamily = parisType )
    }
}
