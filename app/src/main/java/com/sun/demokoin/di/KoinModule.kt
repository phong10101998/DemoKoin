package com.sun.demokoin.di

import com.sun.demokoin.data.source.DataSource
import com.sun.demokoin.data.source.Repository
import com.sun.demokoin.data.source.remote.RemoteDataSource
import com.sun.demokoin.data.source.remote.api.ApiService
import com.sun.demokoin.data.source.remote.api.AuthenticationInterceptor
import com.sun.demokoin.ui.MainViewModel
import com.sun.demokoin.utils.Constant
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single { AuthenticationInterceptor() }
    fun callApi(): ApiService {
        val builder = OkHttpClient.Builder()
        builder.interceptors().add(AuthenticationInterceptor())
        val client = builder.build()
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build().create(ApiService::class.java)
    }
    single { callApi() }
}

val remoteDataSourceModule = module { single<DataSource.Remote> { RemoteDataSource(get()) } }

val repositoryModule = module { single { Repository(get()) } }

val viewModelModule = module { viewModel { MainViewModel(get()) } }
