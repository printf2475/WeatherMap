package co.test.feature.search.model

sealed class SearchAction {
    data class OnChangeSearchText(
        val searchText: String
    ) : SearchAction()
}