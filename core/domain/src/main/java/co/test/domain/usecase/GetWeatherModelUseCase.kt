package co.test.domain.usecase

import android.util.Log
import co.test.domain.repository.WeatherRepository
import co.test.model.CurrentWeatherModel
import co.test.model.Forecast3HourModel
import co.test.model.ForecastDayModel
import co.test.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetWeatherModelUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    companion object {
        private const val TAG = "GetWeatherModelUseCase"
    }

    suspend operator fun invoke(lat: Double, lon: Double): WeatherModel? =
        withContext(Dispatchers.IO) {
            return@withContext runCatching {
                val forecastWeatherPairDeferred =
                    async { weatherRepository.getForecastWeather(lat, lon) }
                val currentWeatherDeferred = async { weatherRepository.getCurrentWeather(lat, lon) }

                val forecastWeatherPair: Pair<List<Forecast3HourModel>, List<ForecastDayModel>> =
                    forecastWeatherPairDeferred.await()

                val currentWeather: CurrentWeatherModel = currentWeatherDeferred.await()
                return@withContext WeatherModel(
                    currentWeatherModel = currentWeather,
                    forecastHourModels = forecastWeatherPair.first,
                    forecastDayModels = forecastWeatherPair.second
                )
            }.getOrElse {
                Log.e(TAG, "error", it)
                null
            }
        }
}