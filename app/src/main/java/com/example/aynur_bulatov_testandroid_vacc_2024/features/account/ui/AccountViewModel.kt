package com.example.aynur_bulatov_testandroid_vacc_2024.features.account.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aynur_bulatov_testandroid_vacc_2024.features.account.data.AccountRepository
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val repository: AccountRepository
) : ViewModel() {
    private var _list: MutableStateFlow<List<ProductModel>> = MutableStateFlow(listOf())
    val list: StateFlow<List<ProductModel>> = _list

    fun getAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAll().collect {
                _list.value = it
            }
        }
    }

    fun clearDB() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearDB()
        }
    }

}