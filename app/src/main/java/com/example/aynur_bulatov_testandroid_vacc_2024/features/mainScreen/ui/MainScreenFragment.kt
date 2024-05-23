package com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.aynur_bulatov_testandroid_vacc_2024.R
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {

    private val viewModel: MainScreenViewModel by viewModels()
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}