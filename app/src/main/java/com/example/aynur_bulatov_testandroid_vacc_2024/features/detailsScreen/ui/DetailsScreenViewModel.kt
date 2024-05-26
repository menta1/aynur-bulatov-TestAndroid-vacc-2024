package com.example.aynur_bulatov_testandroid_vacc_2024.features.detailsScreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aynur_bulatov_testandroid_vacc_2024.features.detailsScreen.data.DetailsScreenRepository
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(private val repository: DetailsScreenRepository) :
    ViewModel() {

    private var _state: MutableStateFlow<DetailsState> = MutableStateFlow(DetailsState.Default)
    val state get() = _state

    fun initData(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = DetailsState.Content(repository.getDetails(id))
        }
    }

    fun addToShopCart(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.addToShopCart(id)
            }
        }
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clear()
        }
    }
}