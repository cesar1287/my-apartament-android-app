package com.github.cesar1287.meuapartamento.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.firebase.ui.auth.AuthUI
import com.github.cesar1287.meuapartamento.core.Payments
import com.github.cesar1287.meuapartamento.core.base.BaseViewModel
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class MainViewModel: BaseViewModel() {

    private val mainBusiness: MainBusiness by inject()
    private val mainPaymentsLiveData: MutableLiveData<Payments> = MutableLiveData()

    fun getProviders(): MutableList<AuthUI.IdpConfig> {
        return mainBusiness.getProviders()
    }

    fun saveUser(user: FirebaseUser) {
        mainBusiness.saveUser(user)
    }

    fun getPayments() {
        viewModelScope.launch(Dispatchers.IO) {
            val payments = mainBusiness.getPayments()
        }
    }

}