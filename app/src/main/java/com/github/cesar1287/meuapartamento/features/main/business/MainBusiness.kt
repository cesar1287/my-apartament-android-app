package com.github.cesar1287.meuapartamento.features.main.business

import com.firebase.ui.auth.AuthUI
import com.github.cesar1287.meuapartamento.core.api.Resource
import com.github.cesar1287.meuapartamento.core.base.BaseBusiness
import com.github.cesar1287.meuapartamento.core.repository.MainRepository
import com.google.firebase.auth.FirebaseUser
import org.koin.core.inject

class MainBusiness : BaseBusiness() {

    private val mainRepository: MainRepository by inject()

    fun getProviders(): MutableList<AuthUI.IdpConfig> {
        // Choose authentication providers
        return arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build(),
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.AnonymousBuilder().build())
    }

    fun saveUser(user: FirebaseUser) {
        mainRepository.saveUser(user)
    }

    suspend fun getPayments(): Resource {
        return mainRepository.getPayments()
    }
}