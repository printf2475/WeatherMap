package co.test.feature.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.test.feature.search.screen.SearchScreen
import co.test.model.CityModel


@Composable
fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel(),
    onClickCity: (CityModel) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val filteredCityList = viewModel.filteredCityList.collectAsStateWithLifecycle(emptyList())

    SearchScreen(
        searchText = uiState.searchText,
        cityList = filteredCityList.value,
        onAction = viewModel::onAction,
        onClickCity = onClickCity
    )
}