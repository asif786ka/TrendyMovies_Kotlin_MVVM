package com.android.asif.llc.kotlin.trendymovies.android.di

import com.android.asif.llc.kotlin.trendymovies.BuildConfig
import com.android.asif.llc.kotlin.trendymovies.android.utils.BASE_URL
import com.android.asif.llc.kotlin.trendymovies.android.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {

        val client = OkHttpClient.Builder()

        // Only show the logs in debug versions
        if (BuildConfig.DEBUG) {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            client.addInterceptor(logger)
        }

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client.build())
            .build()
            .create(ApiService::class.java)
    }
}