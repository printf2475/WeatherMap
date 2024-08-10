package co.test.feature.weather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.test.feature.weather.model.WeatherAction
import co.test.feature.weather.screen.WeatherScreen
import co.test.model.CityModel


@Composable
fun WeatherRoute(
    viewModel: WeatherViewModel = hiltViewModel(),
    cityModel: CityModel?,
    onSearch : () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.onAction(WeatherAction.OnLoadWeather(cityModel))
    }

    WeatherScreen(
        cityModel = uiState.cityModel,
        weatherModel = uiState.weatherModel,
        onSearch = onSearch
    )
}