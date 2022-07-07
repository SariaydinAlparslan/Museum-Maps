package com.sariaydinalparslan.museummaps.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sariaydinalparslan.museummaps.entity.Locations
import com.sariaydinalparslan.museummaps.repo.GoogleReporistoy


class MapViewModel: ViewModel() {
    var museumlist = MutableLiveData<List<Locations>>()
    var yrepo = GoogleReporistoy()

    init {
        lokasyonlarıYukle()
        museumlist = yrepo.lokasyonlarıGetir()
    }

    fun lokasyonlarıYukle(){

        yrepo.tumLokasyonlarAl()
    }
}
