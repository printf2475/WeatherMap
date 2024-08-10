package co.test.data.di

import android.util.Log
import co.test.weathermap.domain.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @OptIn(ExperimentalSerializationApi::class)
    @Singleton
    @Provides
    fun provideHttpClient() = HttpClient(OkHttp) {
        followRedirects = false
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d("Ktor", "message: $message")
                }
            }

            level = LogLevel.BODY
        }
        install(ContentNegotiation) {
            json(Json {
                explicitNulls = false
                ignoreUnknownKeys = true
                isLenient = true
                encodeDefaults = true
                coerceInputValues = true
                ignoreUnknownKeys = true
            })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
            connectTimeoutMillis = 15000L
            socketTimeoutMillis = 15000L
        }
        defaultRequest {
            url(BuildConfig.WEATHER_API_BASE_URL)
            accept(ContentType.Application.Json)
        }
    }

}