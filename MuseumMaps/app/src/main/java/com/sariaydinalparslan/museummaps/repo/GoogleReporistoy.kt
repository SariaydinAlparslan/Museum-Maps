package com.sariaydinalparslan.museummaps.repo

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.sariaydinalparslan.museummaps.entity.Locations

class GoogleReporistoy {
    var museumlist = MutableLiveData<List<Locations>>()
    var refLokasyonlar : DatabaseReference

    init {
        val db = FirebaseDatabase.getInstance()
        refLokasyonlar=db.getReference("yemekler")
        museumlist = MutableLiveData()
    }

    fun lokasyonlarıGetir(): MutableLiveData<List<Locations>> {
        return museumlist
    }
    fun tumLokasyonlarAl(){
        refLokasyonlar.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val liste =ArrayList<Locations>()
                for (d in snapshot.children){
                    val loka = d.getValue(Locations::class.java)
                    if (loka != null){

                        liste.add(loka)
                    }
                }

                museumlist.value=liste
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }
}