package com.github.cesar1287.meuapartamento.features

import com.firebase.ui.auth.AuthUI
import com.github.cesar1287.meuapartamento.core.base.BaseViewModel
import org.koin.core.inject

class MainViewModel: BaseViewModel() {

    private val mainBusiness: MainBusiness by inject()

    fun getProviders(): MutableList<AuthUI.IdpConfig> {
        return mainBusiness.getProviders()
    }

}