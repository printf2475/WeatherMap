package co.test.feature.weather.model

import co.test.model.CityModel

sealed class WeatherAction {
    data class OnLoadWeather(
        val cityModel: CityModel? = null
    ) : WeatherAction()
}