package co.test.data.mapper

import co.test.data.model.ForecastWeather
import co.test.model.CurrentWeatherModel
import co.test.data.model.CurrentWeather
import co.test.model.Forecast3HourModel
import co.test.model.ForecastDayModel
import co.test.model.IconType

fun ForecastWeather.toForecast3Hours(): List<Forecast3HourModel> =
    this.list.groupBy { it.dt_txt?.substringBefore(" ") }
        .asSequence()
        .toList()
        .map { it.value }
        .take(2)
        .flatten().map {
            Forecast3HourModel(
                time = it.dt_txt?.substringAfter(" ")?.split(":")?.firstOrNull() ?: "",
                temp = it.forecastMain?.temp?.toInt() ?: 0,
                iconType = when (it.weather?.firstOrNull()?.icon) {
                    "01d" -> IconType.ICON01D
                    "02d" -> IconType.ICON02D
                    "03d" -> IconType.ICON03D
                    "04d" -> IconType.ICON04D
                    "09d" -> IconType.ICON09D
                    "10d" -> IconType.ICON10D
                    "11d" -> IconType.ICON11D
                    "13d" -> IconType.ICON13D
                    "50d" -> IconType.ICON50D
                    else -> IconType.ICON01D
                },
                rain = it.forecastRain?.hour3?.toInt() ?: 0
            )
        }.toList()

fun ForecastWeather.toForecastDays(): List<ForecastDayModel> =
    this.list.groupBy { it.dt_txt?.substringBefore(" ") ?: "" }.toList().map {
        ForecastDayModel(
            time = it.first,
            minTemp = it.second.minOf { it.forecastMain?.temp ?: 0.0 }.toInt(),
            maxTemp = it.second.maxOf { it.forecastMain?.temp ?: 0.0 }.toInt(),
            rain = it.second.sumOf { it.forecastRain?.hour3?.toInt() ?: 0 } / it.second.size
        )
    }

fun CurrentWeather.toModel(): CurrentWeatherModel = CurrentWeatherModel(
    temp = this.currentMain?.temp?.toInt() ?: 0,
    minTemp = this.currentMain?.temp_min?.toInt() ?: 0,
    maxTemp = this.currentMain?.temp_max?.toInt() ?: 0,
    description = weather?.firstOrNull()?.description ?: "",
    iconType = when (this.weather?.firstOrNull()?.icon) {
        "01d" -> IconType.ICON01D
        "02d" -> IconType.ICON02D
        "03d" -> IconType.ICON03D
        "04d" -> IconType.ICON04D
        "09d" -> IconType.ICON09D
        "10d" -> IconType.ICON10D
        "11d" -> IconType.ICON11D
        "13d" -> IconType.ICON13D
        "50d" -> IconType.ICON50D
        else -> IconType.ICON01D
    },
    humidity = this.currentMain?.humidity ?: 0,
    cloud = this.clouds?.all ?: 0,
    windSpeed = this.wind?.speed ?: 0.0


)