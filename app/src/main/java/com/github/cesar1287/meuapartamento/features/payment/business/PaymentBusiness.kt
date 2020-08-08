package com.github.cesar1287.meuapartamento.features.payment.business

import com.github.cesar1287.meuapartamento.core.base.BaseBusiness

class PaymentBusiness : BaseBusiness() {

    fun getValueToDeposit(totalAmount: Double, initialValue: Double, quantity: Double): Double {
        return (totalAmount - initialValue) / quantity
    }


}