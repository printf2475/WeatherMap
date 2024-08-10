package co.test.feature.weather.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.test.feature.weather.util.weatherIcon
import co.test.model.Forecast3HourModel
import co.test.weathermap.feature.weather.R

@Composable
fun Forecast3hWeatherContent(
    modifier: Modifier = Modifier,
    forecast3hModels: List<Forecast3HourModel>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        items(forecast3hModels){ model ->
            Forecast3hWeatherItemContent(
                time = model.time,
                temp = model.temp,
                icon = model.iconType.weatherIcon,
                rain = model.rain
            )
        }
    }
}

@Composable
private fun Forecast3hWeatherItemContent(
    time: String,
    temp: Int,
    @DrawableRes icon: Int,
    rain: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = "${time}시")
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Text(text = "$temp°")
        Text(text = "$rain%")
    }
}

@Preview
@Composable
private fun PreviewForecast3hWeatherListContent() {
    Forecast3hWeatherItemContent(
        time = "12", temp = 30, icon = R.drawable.ic_01d, rain = 10
    )
}