package com.github.cesar1287.meuapartamento.features.payment.viewmodel

import com.github.cesar1287.meuapartamento.core.base.BaseViewModel
import com.github.cesar1287.meuapartamento.features.payment.business.PaymentBusiness

class PaymentViewModel(
    private val paymentBusiness: PaymentBusiness
) : BaseViewModel() {

    fun getValueToDepositPerMonth(totalAmount: Double?, initialValue: Double?, quantity: Double?): String {
        return paymentBusiness.getValueToDepositPerMonth(totalAmount, initialValue, quantity)
    }

    fun getPaymentPerMonth(totalAmount: Double?, quantity: Double?): String {
        return paymentBusiness.getPaymentPerMonth(totalAmount, quantity)
    }


}