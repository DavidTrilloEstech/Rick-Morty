package com.example.app_rickmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.app_rickmorty.databinding.LocationFragmentBinding
import com.example.app_rickmorty.model.data.Localizacion.LocationResult
import com.example.app_rickmorty.ui.CharacterModel

class FragmentLocation : Fragment() {

    private lateinit var binding: LocationFragmentBinding
    private val viewModel by activityViewModels<CharacterModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LocationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLocation().observe(viewLifecycleOwner){
            fillData(it)
        }
    }

    private fun fillData(location: LocationResult){
        binding.tvLocationName.text=location.name
        binding.tvLocationDimension.text=location.dimension
        binding.tvLocationType.text=location.type
    }
}