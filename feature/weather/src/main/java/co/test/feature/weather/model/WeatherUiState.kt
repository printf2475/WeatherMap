package co.test.feature.weather.model

import co.test.model.CityModel
import co.test.model.WeatherModel

data class WeatherUiState(
    val weatherModel: WeatherModel? = null,
    val cityModel: CityModel? = null,
)
