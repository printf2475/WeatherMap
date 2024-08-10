package co.test.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import co.test.core.navigation.Routes
import co.test.feature.search.navigation.navigateSearch
import co.test.feature.search.navigation.searchNavGraph
import co.test.feature.weather.navigation.navigateWeather
import co.test.feature.weather.navigation.weatherNavGraph
import co.test.model.CityModel

private const val TAG: String = "NavigationContainer"

@Composable
fun NavigationContainer(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Routes.Weather(cityModel = CityModel())
    ) {
        weatherNavGraph(
            onSearch = navHostController::navigateSearch
        )

        searchNavGraph(
            onClickCity = navHostController::navigateWeather
        )
    }
}