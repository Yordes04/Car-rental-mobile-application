package com.example.louemonchar.presentation.enregistrervoiture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.louemonchar.http.Auto

class PartageVueModel :ViewModel() {
    private val nouvelle_Voiture = MutableLiveData<Auto?>()
    val nouvelleVoiture : MutableLiveData<Auto?>
        get()= nouvelle_Voiture

    fun voitureEnregistrer(voiture:Auto){
        nouvelle_Voiture.value=voiture
    }
    fun clearNouvelleVoiture() {
        nouvelle_Voiture.value = null
    }
}