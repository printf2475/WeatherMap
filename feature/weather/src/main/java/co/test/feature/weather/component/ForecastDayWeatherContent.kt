package co.test.feature.weather.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.test.designsystem.theme.Gray200
import co.test.model.ForecastDayModel

@Composable
fun ForecastDayWeatherContent(
    modifier: Modifier = Modifier,
    forecastDayModels: List<ForecastDayModel>
) {
    Column(
        modifier = modifier
            .padding(horizontal = 10.dp)
            .background(Gray200, RoundedCornerShape(24.dp))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        forecastDayModels.forEach { model ->
            ForecastDayItemContent(
                time = model.time,
                rain = model.rain,
                minTemp = model.minTemp,
                maxTemp = model.maxTemp
            )
        }
    }
}

@Composable
private fun ForecastDayItemContent(
    time: String,
    rain: Int,
    minTemp: Int,
    maxTemp: Int,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$rain%",
            fontSize = 24.sp
        )

        Text(
            text = "$minTemp° / $maxTemp°",
            fontSize = 24.sp
        )
    }
}

@Preview
@Composable
private fun PreviewForecastDayItemContent() {
    ForecastDayItemContent(
        time = "2024-08-10",
        rain = 10,
        minTemp = 20,
        maxTemp = 30
    )
}