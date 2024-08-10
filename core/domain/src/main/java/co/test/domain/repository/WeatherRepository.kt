package co.test.domain.repository

import co.test.model.CityModel
import co.test.model.CurrentWeatherModel
import co.test.model.Forecast3HourModel
import co.test.model.ForecastDayModel

interface WeatherRepository {

    /**
     * 현재 날씨와 예보:
     *     1시간 분 단위 예보
     *     48시간 동안의 시간별 예보
     *     8일간의 일일 예보
     *     알림
     *
     * @param lat 위도
     * @param lon 경도
     * @param exclude 제외 항목
     * 제외 가능 값 current, minutely, hourly, daily, alerts
     */
    suspend fun getForecastWeather(
        lat: Double,
        lon: Double
    ): Pair<List<Forecast3HourModel>, List<ForecastDayModel>>

    suspend fun getCurrentWeather(
        lat: Double,
        lon: Double
    ): CurrentWeatherModel

    suspend fun getCityListForSearch(): List<CityModel>
}