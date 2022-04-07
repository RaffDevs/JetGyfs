package com.exemple.jetgyfs.di

import android.content.Context
import androidx.room.Room
import com.exemple.jetgyfs.data.repository.GifRepositoryImpl
import com.exemple.jetgyfs.domain.repository.GifRepository
import com.exemple.jetgyfs.networking.Constants
import com.exemple.jetgyfs.data.datasource.api.GifApi
import com.exemple.jetgyfs.data.repository.FavoriteGiffRepositoryImpl
import com.exemple.jetgyfs.domain.repository.FavoriteGiffRepository
import com.exemple.jetgyfs.infra.GiffDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideGiffDatabase(@ApplicationContext context: Context) : GiffDatabase {
        return Room.databaseBuilder(
            context,
            GiffDatabase::class.java,
            "giff_db"
        ).fallbackToDestructiveMigration()
        .build()
    }

    @Singleton
    @Provides
    fun provideRepository(api: GifApi): GifRepository {
        return GifRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideFavoriteGiffRepository(dao: GiffDatabase): FavoriteGiffRepository {
        return FavoriteGiffRepositoryImpl(dao.giffDao())
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