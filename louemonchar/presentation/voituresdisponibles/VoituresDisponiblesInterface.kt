package com.example.louemonchar.presentation.voituresdisponibles

import com.example.louemonchar.http.Auto
import com.example.louemonchar.modèle.VoitureUiModèle

interface VoituresDisponiblesInterface {

    interface View {
        fun afficherVoitures(voitures: List<Auto>)
        fun afficherErreur(message: String)
        fun montrerBarreChargement()
        fun cacherBarreChargement()
        fun getListe(): List<Auto>


    }

    interface Presenter {
        fun chargerVoitures()
        fun rechercherParModèle(query: String)
        fun setDateLocation(date: java.util.Date)
        fun searchByDateRange()


        //temp

    }
}