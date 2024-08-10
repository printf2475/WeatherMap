package co.test.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import co.test.core.navigation.Routes
import co.test.feature.search.SearchRoute
import co.test.model.CityModel

fun NavController.navigateSearch() {
    navigate(Routes.Search)
}

fun NavGraphBuilder.searchNavGraph(
    onClickCity: (CityModel) ->Unit
) {
    composable<Routes.Search> {
        SearchRoute(
            onClickCity = onClickCity
        )
    }
}