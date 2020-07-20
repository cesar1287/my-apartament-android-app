package com.github.cesar1287.meuapartamento.features

import com.firebase.ui.auth.AuthUI
import com.github.cesar1287.meuapartamento.core.base.BaseBusiness

class MainBusiness : BaseBusiness() {

    fun getProviders(): MutableList<AuthUI.IdpConfig> {
        // Choose authentication providers
        return arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build(),
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.AnonymousBuilder().build())
    }
}