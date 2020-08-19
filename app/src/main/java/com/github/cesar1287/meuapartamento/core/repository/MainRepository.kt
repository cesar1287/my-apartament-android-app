package com.github.cesar1287.meuapartamento.core.repository

import com.github.cesar1287.meuapartamento.core.api.Resource
import com.github.cesar1287.meuapartamento.core.base.BaseRepository
import com.github.cesar1287.meuapartamento.util.ConstantsUtil.Firestore.FIRESTORE_EMAIL
import com.github.cesar1287.meuapartamento.util.ConstantsUtil.Firestore.FIRESTORE_NAME
import com.github.cesar1287.meuapartamento.util.ConstantsUtil.Firestore.FIRESTORE_PAYMENTS
import com.github.cesar1287.meuapartamento.util.ConstantsUtil.Firestore.FIRESTORE_USERS
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.SetOptions

class MainRepository : BaseRepository() {

    fun saveUser(user: FirebaseUser) {
        val userFirebase = hashMapOf(
            FIRESTORE_NAME to user.displayName,
            FIRESTORE_EMAIL to user.email
        )

        // Add a new document with a generated ID
        db.collection(FIRESTORE_USERS)
            .document(user.uid)
            .set(userFirebase, SetOptions.merge())
    }

    suspend fun getPayments(): Resource {
        val paymentsReference = db.collection(FIRESTORE_USERS).document(firebaseUser?.uid ?: "").collection(FIRESTORE_PAYMENTS)
        val result = Tasks.await(paymentsReference.get())
        return Resource.success(result.documents)
    }

}