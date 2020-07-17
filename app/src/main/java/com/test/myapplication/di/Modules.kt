package com.test.myapplication.di

import com.test.myapplication.datamapper.PostDataMapper
import com.test.myapplication.localdatasource.PostDataStore
import com.test.myapplication.localdatasource.PostLocalDataSource
import com.test.myapplication.remotedatasource.PostRemoteDataSource
import com.test.myapplication.repository.PostRepository
import com.test.myapplication.usecases.PostUseCases
import com.test.myapplication.viewmodel.PostViewModel
import net.simplifiedcoding.data.network.PostsApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule : Module = module {
    single { PostUseCases(get()) }
    single { PostRepository(get(),get()) }
    single { PostRemoteDataSource(get()) }
    single { PostLocalDataSource(get()) }
    single { PostDataMapper(get()) }
    single { PostsApi() }
    single { PostDataStore(get()) }
}

val viewModelModule = module {
    viewModel { PostViewModel(get()) }
}