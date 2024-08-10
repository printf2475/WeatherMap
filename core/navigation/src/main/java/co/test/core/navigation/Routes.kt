package co.test.core.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import co.test.model.CityModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

sealed class Routes {

    @Serializable
    data class Weather(val cityModel: CityModel) : Routes()

    @Serializable
    data object Search : Routes()
}

val CityModelType = object : NavType<CityModel>(
    isNullableAllowed = true
) {
    override fun put(bundle: Bundle, key: String, value: CityModel) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): CityModel? {
        return bundle.getParcelable(key) as? CityModel
    }

    override fun serializeAsValue(value: CityModel): String =
        Uri.encode(Json.encodeToString(value))

    override fun parseValue(value: String): CityModel =
        Json.decodeFromString<CityModel>(value)
}
