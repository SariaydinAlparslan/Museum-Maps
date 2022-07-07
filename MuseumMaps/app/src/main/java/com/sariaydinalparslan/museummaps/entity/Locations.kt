package com.sariaydinalparslan.museummaps.entity

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Locations(
    var yemek_resim_adi: Float? = 0f,
    var yemek_fiyat: Float? =0f,
    var yemek_adi : String? = ""


){

}

