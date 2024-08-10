package co.test.feature.weather.util

import androidx.annotation.DrawableRes
import co.test.model.IconType
import co.test.weathermap.feature.weather.R

val IconType.weatherIcon : Int
    @DrawableRes
    get() = when(this){
        IconType.ICON01D -> R.drawable.ic_01d
        IconType.ICON02D -> R.drawable.ic_02d
        IconType.ICON03D -> R.drawable.ic_03d
        IconType.ICON04D -> R.drawable.ic_04d
        IconType.ICON09D -> R.drawable.ic_09d
        IconType.ICON10D -> R.drawable.ic_10d
        IconType.ICON11D -> R.drawable.ic_11d
        IconType.ICON13D -> R.drawable.ic_13d
        IconType.ICON50D -> R.drawable.ic_50d
    }