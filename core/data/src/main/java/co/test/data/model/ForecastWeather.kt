package co.test.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastWeather(
    val city: City?,
    val cnt: Int?,
    val cod: String?,
    val list: List<Data>,
    val message: Int?
)

@Serializable
data class City(
    val coord: Coord?,
    val country: String?,
    val id: Int?,
    val name: String?,
    val population: Int?,
    val sunrise: Int?,
    val sunset: Int?,
    val timezone: Int?
)


@Serializable
data class Data (
    val clouds: Clouds?,
    val dt: Int?,
    val dt_txt: String?,
    @SerialName("main")
    val forecastMain: ForecastMain?,
    val pop: Double?,
    @SerialName("rain")
    val forecastRain: ForecastRain?,
    @SerialName("sys")
    val forecastSys: ForecastSys?,
    val visibility: Int?,
    val weather: List<Weather>?,
    val wind: Wind?
)

@Serializable
data class ForecastMain(
    val feels_like: Double?,
    val grnd_level: Int?,
    val humidity: Int?,
    val pressure: Int?,
    val sea_level: Int?,
    val temp: Double?,
    val temp_kf: Double?,
    val temp_max: Double?,
    val temp_min: Double?
)

@Serializable
data class ForecastRain(
    @SerialName("3h")
    val hour3: Double?
)

@Serializable
data class ForecastSys(
    val pod: String?
)



