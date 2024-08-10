package co.test.data.di

import android.content.Context
import co.test.data.api.WeatherApi
import co.test.data.datasource.LocalDataSource
import co.test.data.repository.WeatherRepositoryImpl
import co.test.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(
        @ApplicationContext context: Context
    ): LocalDataSource = LocalDataSource(context)

    @Singleton
    @Provides
    fun provideWeatherRepository(
        api: WeatherApi,
        localDataSource: LocalDataSource
    ): WeatherRepository = WeatherRepositoryImpl(api, localDataSource)

}