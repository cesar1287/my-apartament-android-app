package com.github.cesar1287.meuapartamento.core.di

import com.github.cesar1287.meuapartamento.features.MainBusiness
import com.github.cesar1287.meuapartamento.features.MainViewModel
import com.github.cesar1287.meuapartamento.core.repository.MainRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val businessModule = module {
    single { MainBusiness() }
}

val repositoryModule = module {
    single { MainRepository() }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
}