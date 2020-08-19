package com.github.cesar1287.meuapartamento.features.payment.business

import com.github.cesar1287.meuapartamento.core.base.BaseBusiness

class PaymentBusiness : BaseBusiness() {

    fun getValueToDepositPerMonth(totalAmount: Double?, initialValue: Double?, quantity: Double?): String {
        return ((totalAmount!! - initialValue!!) / quantity!!).toString()
    }

    fun getPaymentPerMonth(totalAmount: Double?, quantity: Double?): String {
        return (totalAmount!! / quantity!!).toString()
    }


}