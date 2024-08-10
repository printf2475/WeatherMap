package co.test.model

data class WeatherModel(
    val currentWeatherModel:CurrentWeatherModel,
    val forecastHourModels: List<Forecast3HourModel>,
    val forecastDayModels: List<ForecastDayModel>
)


data class CurrentWeatherModel(
    val temp: Int,
    val minTemp: Int,
    val maxTemp: Int,
    val description: String,
    val iconType: IconType,
    val humidity: Int,
    val cloud :Int,
    val windSpeed : Double,
)


data class Forecast3HourModel(
    val time: String,
    val temp: Int,
    val iconType: IconType,
    val rain: Int
)

data class ForecastDayModel(
    val time: String,
    val minTemp : Int,
    val maxTemp:Int,
    val rain: Int
)

enum class IconType {
    ICON01D,
    ICON02D,
    ICON03D,
    ICON04D,
    ICON09D,
    ICON10D,
    ICON11D,
    ICON13D,
    ICON50D,
}
