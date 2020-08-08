package com.github.cesar1287.meuapartamento.features.payment.viewmodel

import com.github.cesar1287.meuapartamento.core.base.BaseViewModel
import com.github.cesar1287.meuapartamento.features.payment.business.PaymentBusiness

class PaymentViewModel(
    private val paymentBusiness: PaymentBusiness
) : BaseViewModel() {

    fun getValueToDeposit(totalAmount: Double, initialValue: Double, quantity: Double): Double {
        return paymentBusiness.getValueToDeposit(totalAmount, initialValue, quantity)
    }


}