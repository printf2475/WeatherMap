package co.test.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.test.domain.usecase.GetCityModelListUseCase
import co.test.feature.search.model.SearchAction
import co.test.feature.search.model.SearchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getCityModelListUseCase: GetCityModelListUseCase
) : ViewModel() {
    companion object {
        private const val TAG = "SearchViewModel"
        private const val DEBOUNCE_TIME = 500L
    }

    var uiState: MutableStateFlow<SearchUiState> = MutableStateFlow(SearchUiState())
        private set

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val filteredCityList = uiState.asStateFlow()
        .debounce(DEBOUNCE_TIME)
        .mapLatest { state ->
            if (state.searchText.isEmpty()) {
                return@mapLatest state.cityList
            }

            state.cityList.filter {
                it.name.contains(state.searchText) || it.country.contains(state.searchText)
            }
        }


    init {
        loadCityModelList()
    }

    fun onAction(action: SearchAction) {
        when (action) {
            is SearchAction.OnChangeSearchText -> onChangeSearchText(action.searchText)
        }
    }

    private fun loadCityModelList() = viewModelScope.launch {
        val result = getCityModelListUseCase()
        uiState.update {
            it.copy(cityList = result)
        }
    }

    private fun onChangeSearchText(text: String) = viewModelScope.launch {
        uiState.update {
            it.copy(searchText = text)
        }
    }
}