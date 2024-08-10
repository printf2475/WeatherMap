package co.test.feature.weather.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.test.designsystem.theme.Gray200
import co.test.weathermap.feature.weather.R

@Composable
fun CurrentWeatherContent(
    modifier: Modifier = Modifier,
    temp: Int,
    minTemp: Int,
    maxTemp: Int,
    @DrawableRes icon: Int,
    description: String
) {
    Row(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .background(Gray200, RoundedCornerShape(24.dp))
            .padding(horizontal = 40.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$temp°",
            fontSize = 52.sp
        )

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "${minTemp}° / ${maxTemp}°",
                fontSize = 28.sp
            )
            Text(
                text = description,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }

        Icon(
            modifier = Modifier.size(52.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}


@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun PreviewCurrentWeatherContent() {
    CurrentWeatherContent(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        temp = 30,
        minTemp = 20,
        maxTemp = 40,
        icon = R.drawable.ic_01d,
        description = "구름"
    )

}