package co.test.feature.weather.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.test.feature.weather.component.CurrentWeatherContent
import co.test.feature.weather.component.Forecast3hWeatherContent
import co.test.feature.weather.component.ForecastDayWeatherContent
import co.test.feature.weather.component.RainCloudWindSpeedContent
import co.test.feature.weather.component.SearchButton
import co.test.feature.weather.util.weatherIcon
import co.test.model.CityModel
import co.test.model.WeatherModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun WeatherScreen(
    cityModel: CityModel?,
    weatherModel: WeatherModel?,
    onSearch: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        SearchButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            onSearch = onSearch
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = cityModel?.name ?: "",
            fontSize = 52.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))


        if (weatherModel == null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            CurrentWeatherContent(
                modifier = Modifier.fillMaxWidth(),
                temp = weatherModel.currentWeatherModel.temp,
                minTemp = weatherModel.currentWeatherModel.minTemp,
                maxTemp = weatherModel.currentWeatherModel.maxTemp,
                icon = weatherModel.currentWeatherModel.iconType.weatherIcon,
                description = weatherModel.currentWeatherModel.description
            )

            Spacer(modifier = Modifier.height(30.dp))

            Forecast3hWeatherContent(
                modifier = Modifier.fillMaxWidth(),
                forecast3hModels = weatherModel.forecastHourModels
            )

            Spacer(modifier = Modifier.height(30.dp))

            ForecastDayWeatherContent(
                modifier = Modifier.fillMaxWidth(),
                forecastDayModels = weatherModel.forecastDayModels
            )

            Spacer(modifier = Modifier.height(30.dp))

            GoogleMap(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                cameraPositionState = rememberCameraPositionState {
                    position = CameraPosition.fromLatLngZoom(
                        LatLng(
                            cityModel?.coord?.lat ?: 0.0,
                            cityModel?.coord?.lon ?: 0.0
                        ), 10f
                    )
                }
            )

            RainCloudWindSpeedContent(
                humidity = weatherModel.currentWeatherModel.humidity,
                cloud = weatherModel.currentWeatherModel.cloud,
                windSpeed = weatherModel.currentWeatherModel.windSpeed.toFloat()
            )
        }
    }
}


