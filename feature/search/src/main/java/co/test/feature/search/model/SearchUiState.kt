package co.test.feature.search.model

import co.test.model.CityModel

data class SearchUiState(
    val cityList: List<CityModel> = emptyList(),
    val searchText: String = "",
)
