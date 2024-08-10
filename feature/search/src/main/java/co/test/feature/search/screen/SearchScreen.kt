package co.test.feature.search.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.test.feature.search.component.SearchCityList
import co.test.feature.search.component.SearchTextField
import co.test.feature.search.model.SearchAction
import co.test.model.CityModel

@Composable
fun SearchScreen(
    searchText: String,
    cityList: List<CityModel>,
    onAction: (SearchAction) -> Unit,
    onClickCity: (CityModel) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchTextField(
            searchText = searchText,
            onValueChange = {
                onAction(SearchAction.OnChangeSearchText(it))
            }
        )

        SearchCityList(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            cityList = cityList,
            onClickCity = onClickCity
        )
    }
}