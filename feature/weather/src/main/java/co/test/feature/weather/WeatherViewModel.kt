package co.test.feature.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.test.domain.usecase.GetWeatherModelUseCase
import co.test.feature.weather.model.WeatherAction
import co.test.feature.weather.model.WeatherUiState
import co.test.model.CityModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherModelUseCase: GetWeatherModelUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "WeatherViewModel"
    }

    var uiState: MutableStateFlow<WeatherUiState> = MutableStateFlow(WeatherUiState())
        private set

    fun onAction(action: WeatherAction) {
        when (action) {
            is WeatherAction.OnLoadWeather -> onLoadWeather(action.cityModel)
        }

    }

    private fun onLoadWeather(cityModel: CityModel?) = viewModelScope.launch {
        val city = cityModel ?: CityModel()
        val weatherModel = getWeatherModelUseCase(city.coord.lat, city.coord.lon)
        if (weatherModel == null) {
            uiState.update {
                it.copy(cityModel = city)
            }
            return@launch
        }

        uiState.update {
            it.copy(
                weatherModel = weatherModel,
                cityModel = city
            )
        }
    }

}