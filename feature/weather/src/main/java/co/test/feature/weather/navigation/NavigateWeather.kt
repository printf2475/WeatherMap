package co.test.feature.weather.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import co.test.core.navigation.CityModelType
import co.test.core.navigation.Routes
import co.test.feature.weather.WeatherRoute
import co.test.model.CityModel
import kotlin.reflect.typeOf

fun NavController.navigateWeather(
    cityModel: CityModel
) {
    navigate(Routes.Weather(cityModel))
}

fun NavGraphBuilder.weatherNavGraph(
    onSearch: () -> Unit,
) {
    composable<Routes.Weather>(
        typeMap = mapOf(typeOf<CityModel>() to CityModelType)
    ) {
        val args = it.toRoute<Routes.Weather>()
        WeatherRoute(
            cityModel = args.cityModel,
            onSearch = onSearch
        )
    }
}