package com.github.cesar1287.meuapartamento.core.base

import com.google.firebase.firestore.FirebaseFirestore
import org.koin.core.KoinComponent

open class BaseRepository : KoinComponent {

    val db = FirebaseFirestore.getInstance()
}