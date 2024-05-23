package com.example.aynur_bulatov_testandroid_vacc_2024.features.auth.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aynur_bulatov_testandroid_vacc_2024.R
import com.example.aynur_bulatov_testandroid_vacc_2024.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private val viewModel: AuthViewModel by viewModels()
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}