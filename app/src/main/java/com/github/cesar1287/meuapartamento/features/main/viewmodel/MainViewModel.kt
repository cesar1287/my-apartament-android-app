package com.github.cesar1287.meuapartamento.features.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.firebase.ui.auth.AuthUI
import com.github.cesar1287.meuapartamento.core.Payments
import com.github.cesar1287.meuapartamento.core.base.BaseViewModel
import com.github.cesar1287.meuapartamento.features.main.business.MainBusiness
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class MainViewModel(
    private val mainBusiness: MainBusiness
): BaseViewModel() {

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