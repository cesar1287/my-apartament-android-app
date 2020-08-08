package com.github.cesar1287.meuapartamento.core.di

import com.github.cesar1287.meuapartamento.features.main.business.MainBusiness
import com.github.cesar1287.meuapartamento.features.main.viewmodel.MainViewModel
import com.github.cesar1287.meuapartamento.core.repository.MainRepository
import com.github.cesar1287.meuapartamento.features.payment.business.PaymentBusiness
import com.github.cesar1287.meuapartamento.features.payment.viewmodel.PaymentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val businessModule = module {
    single { MainBusiness() }
    single { PaymentBusiness() }
}

val repositoryModule = module {
    single { MainRepository() }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { PaymentViewModel(get()) }
}