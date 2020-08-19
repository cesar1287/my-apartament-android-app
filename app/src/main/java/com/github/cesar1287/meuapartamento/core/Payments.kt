package com.github.cesar1287.meuapartamento.core

import com.google.firebase.firestore.DocumentReference

data class Payments(
    val initialValue: Double,
    val paymentValue: Double,
    val depositValue: Double,
    val paymentsCollection: DocumentReference,
    val depositsCollection: DocumentReference
)