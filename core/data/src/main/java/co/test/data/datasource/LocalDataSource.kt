package co.test.data.datasource

import android.content.Context
import co.test.model.CityModel
import kotlinx.serialization.json.Json

class LocalDataSource(
    private val context: Context
) {
    companion object {
        private const val WEATHER_JSON = "city_list.json"
    }

    private val json = Json { ignoreUnknownKeys = true }

    fun getCityListForSearch(): List<CityModel> = kotlin.runCatching {
        val jsonString = context.assets.open(WEATHER_JSON)
            .bufferedReader().use { it.readText() }

        json.decodeFromString<List<CityModel>>(jsonString)
    }.getOrElse { emptyList() }
}