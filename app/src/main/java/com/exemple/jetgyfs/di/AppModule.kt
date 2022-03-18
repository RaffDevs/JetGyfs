package com.exemple.jetgyfs.di

import com.exemple.jetgyfs.data.repository.GifRepositoryImpl
import com.exemple.jetgyfs.domain.repository.GifRepository
import com.exemple.jetgyfs.networking.Constants
import com.exemple.jetgyfs.data.data_source.api.GifApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRepository(api: GifApi): GifRepository {
        return GifRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideGifApi() : GifApi {
        return Retrofit.Builder()
            .baseUrl(Constants.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GifApi::class.java)
    }
}