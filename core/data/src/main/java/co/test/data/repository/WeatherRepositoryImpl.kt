package co.test.data.repository

import co.test.data.api.WeatherApi
import co.test.data.datasource.LocalDataSource
import co.test.data.mapper.toModel
import co.test.data.mapper.toForecast3Hours
import co.test.data.mapper.toForecastDays
import co.test.domain.repository.WeatherRepository
import co.test.model.CityModel
import co.test.model.CurrentWeatherModel
import co.test.model.Forecast3HourModel
import co.test.model.ForecastDayModel

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi,
    private val localDataSource: LocalDataSource
) : WeatherRepository {
    override suspend fun getForecastWeather(
        lat: Double,
        lon: Double
    ): Pair<List<Forecast3HourModel>, List<ForecastDayModel>> {
        val forecastWeather = weatherApi.getForecastWeather(lat, lon)
        return Pair(forecastWeather.toForecast3Hours(), forecastWeather.toForecastDays())
    }

    override suspend fun getCurrentWeather(lat: Double, lon: Double): CurrentWeatherModel =
        weatherApi.getCurrentWeather(lat, lon).toModel()

    override suspend fun getCityListForSearch(): List<CityModel> =
        localDataSource.getCityListForSearch()
}