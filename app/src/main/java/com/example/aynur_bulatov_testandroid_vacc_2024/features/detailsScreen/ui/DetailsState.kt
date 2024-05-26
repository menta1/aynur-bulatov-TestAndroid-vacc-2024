package com.example.aynur_bulatov_testandroid_vacc_2024.features.detailsScreen.ui

import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel

sealed class DetailsState {
    data object Default : DetailsState()
    class Content(val detail: ProductModel) : DetailsState()
}