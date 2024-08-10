package co.test.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    val base: String?,
    val clouds: Clouds?,
    val cod: Int?,
    val coord: Coord?,
    val dt: Int?,
    val id: Int?,
    @SerialName("main")
    val currentMain: CurrentMain?,
    val name: String?,
    @SerialName("rain")
    val currentRain: CurrentRain?,
    @SerialName("sys")
    val currentSys: CurrentSys?,
    val timezone: Int?,
    val visibility: Int?,
    val weather: List<Weather>?,
    val wind: Wind?
)

@Serializable
data class CurrentMain(
    val feels_like: Double?,
    val grnd_level: Int?,
    val humidity: Int?,
    val pressure: Int?,
    val sea_level: Int?,
    val temp: Double?,
    val temp_max: Double?,
    val temp_min: Double?
)

@Serializable
data class CurrentRain(
    @SerialName("1h")
    val hour1: Double?
)

@Serializable
data class CurrentSys(
    val country: String,
    val id: Int?,
    val sunrise: Int,
    val sunset: Int,
    val type: Int?
)