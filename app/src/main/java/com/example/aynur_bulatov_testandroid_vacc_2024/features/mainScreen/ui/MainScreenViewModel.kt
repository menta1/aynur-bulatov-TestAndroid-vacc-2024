package com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.MainScreenRepository
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val mainScreenRepository: MainScreenRepository) :
    ViewModel() {

    private var _state: MutableStateFlow<MainState> = MutableStateFlow(MainState.Loading)
    val state get() = _state
    private var tryGet = true

    fun initData() {
        if (tryGet) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    mainScreenRepository.getProducts().collect {
                        _state.value = MainState.Content(it)
                        tryGet = true
                    }
                }
            }
        }
    }

    fun save(product: ProductModel) {
        viewModelScope.launch(Dispatchers.IO) {
            mainScreenRepository.saveProd(product)
        }
    }
}

