package co.test.domain.usecase

import co.test.domain.repository.WeatherRepository
import co.test.model.CityModel
import javax.inject.Inject

class GetCityModelListUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(): List<CityModel> = runCatching {
        weatherRepository.getCityListForSearch()
    }.getOrElse { emptyList() }

}