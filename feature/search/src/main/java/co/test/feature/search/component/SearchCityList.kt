package co.test.feature.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import co.test.designsystem.theme.Gray200
import co.test.model.CityModel

@Composable
fun SearchCityList(
    modifier: Modifier,
    cityList: List<CityModel>,
    onClickCity: (CityModel) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(cityList) {
            SearchListContent(
                name = it.name,
                country = it.country,
                onClick = { onClickCity(it) }
            )
        }
    }
}

@Composable
private fun SearchListContent(
    name: String,
    country: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Gray200, RoundedCornerShape(24.dp))
            .padding(20.dp)
            .clickable(onClick = onClick),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = name, fontWeight = FontWeight.Bold)
        Text(text = country)
    }
}