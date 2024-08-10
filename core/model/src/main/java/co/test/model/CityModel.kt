package co.test.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

/**
 *  {
 *    "id": 1839726,
 *   "name": "Asan",
 *   "country": "KR",
 *   "coord": {
 *       "lon": 127.004173,
 *       "lat": 36.783611
 *   }
 *  }
 */


@Serializable
@Parcelize
data class CityModel(
    val id: Int = 1839726,
    val name: String = "Asan",
    val country: String = "KR",
    val coord: CoordModel = CoordModel(
        lon = 127.004173,
        lat = 36.783611
    )
) : Parcelable

@Serializable
@Parcelize
data class CoordModel(
    val lon: Double,
    val lat: Double
) : Parcelable