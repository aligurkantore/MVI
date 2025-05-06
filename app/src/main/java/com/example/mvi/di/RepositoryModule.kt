package com.example.mvi.di

import android.content.Context
import com.example.mvi.data.repository.RepositoryImpl
import com.example.mvi.data.source.remote.Service
import com.example.mvi.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        @ApplicationContext context: Context,
        service: Service
    ): Repository = RepositoryImpl(
        context = context,
        service = service
    )
}