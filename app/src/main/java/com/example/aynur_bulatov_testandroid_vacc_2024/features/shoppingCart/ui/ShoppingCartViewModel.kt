package com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.data.ShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ShoppingCartViewModel @Inject constructor(
    private val repository: ShopRepository
) : ViewModel() {

    private val _list: MutableStateFlow<ShopState> = MutableStateFlow(ShopState.Default)
    val list get() = _list

    private val selected: MutableList<ProductModel> = mutableListOf()

    fun getAll() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getAll().collect {
                    if (it.isNotEmpty()) {
                        _list.value = ShopState.Content(it)
                    } else {
                        _list.value = ShopState.Empty()
                    }
                }
            }
        }
    }

    fun selectedItems(result: Pair<Boolean, ProductModel>) {
        if (result.first) {
            selected.add(result.second)
        } else {
            selected.remove(result.second)
        }
    }

    fun buySelectedItems() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.buyAll(selected)
            getAll()
        }
    }

}