package com.example.aynur_bulatov_testandroid_vacc_2024.features.detailsScreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.FragmentDetailsScreenBinding
import com.example.aynur_bulatov_testandroid_vacc_2024.features.detailsScreen.ui.DetailsScreenFragmentArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsScreenFragment : Fragment() {

    private val viewModel: DetailsScreenViewModel by viewModels()
    private var _binding: FragmentDetailsScreenBinding? = null

    private val args by navArgs<DetailsScreenFragmentArgs>()
    private val id by lazy { args.id }
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initData(id.toInt())

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect {
                when (it) {
                    is DetailsState.Content -> {
                        with(binding) {
                            nameDetails.text = it.detail.name
                            descVar.text = it.detail.description
                            ratingVar.text = it.detail.rating
                            buttonCat.text = it.detail.category
                            buttonPrice.text = it.detail.price
                        }

                        Glide.with(binding.thumbnail)
                            .load(it.detail.thumbnail)
                            .centerCrop()
                            .transform(RoundedCorners(2))
                            .into(binding.thumbnail)
                    }

                    DetailsState.Default -> {}
                }
            }
        }

        binding.button.setOnClickListener {
            viewModel.addToShopCart(id.toInt())
            Toast.makeText(requireContext(), "Успешно добавлено в корзину", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clear()
        _binding = null
    }
}