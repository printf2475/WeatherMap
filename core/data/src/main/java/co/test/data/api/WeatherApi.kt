package co.test.data.api

import co.test.data.model.ForecastWeather
import co.test.data.model.CurrentWeather
import co.test.weathermap.core.data.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path

class WeatherApi(
    private val client: HttpClient
) {

    suspend fun getForecastWeather(
        lat: Double,
        lon: Double,
    ): ForecastWeather = client.get {
        url {
            path("data/2.5/forecast")
            parameters.append("lat", lat.toString())
            parameters.append("lon", lon.toString())
            parameters.append("appid", BuildConfig.WEATHER_API_KEY)
            parameters.append("lang", "kr")
            parameters.append("units", "metric")

        }
    }.body()

    suspend fun getCurrentWeather(
        lat: Double,
        lon: Double,
    ): CurrentWeather = client.get {
        url {
            path("data/2.5/weather")
            parameters.append("lat", lat.toString())
            parameters.append("lon", lon.toString())
            parameters.append("appid", BuildConfig.WEATHER_API_KEY)
            parameters.append("lang", "kr")
            parameters.append("units", "metric")
        }
    }.body()
}