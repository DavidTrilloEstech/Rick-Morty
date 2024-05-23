package com.example.app_rickmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_rickmorty.R
import com.example.app_rickmorty.databinding.LocationFragmentBinding
import com.example.app_rickmorty.model.data.Localizacion.LocationResult
import com.example.app_rickmorty.model.data.personajes.Character
import com.example.app_rickmorty.model.data.personajes.CharacterResult
import com.example.app_rickmorty.ui.CharacterModel
import com.example.app_rickmorty.ui.adapters.CharacterAdapter

class FragmentLocation : Fragment() {

    private lateinit var binding: LocationFragmentBinding
    private val viewModel by activityViewModels<CharacterModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LocationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLocation().observe(viewLifecycleOwner){
            fillData(it)

            configRecycler(it.residents)
        }
    }

    private fun fillData(location: LocationResult){
        binding.tvLocationName.text=location.name
        binding.tvLocationDimension.text=location.dimension
        binding.tvLocationType.text=location.type
    }

    private fun configRecycler(list: List<String>){

        var stringId = ""

        var i = 0

        while (i < list.size){
            stringId += (list[i].substring(42))+ ", "
            i++
        }

        viewModel.getCharactersPorId(stringId).observe(viewLifecycleOwner){
            binding.recyclerView3.adapter = CharacterAdapter(requireContext(), object : CharacterAdapter.Myclick {
                override fun onHolderClick(character: CharacterResult) {
                    viewModel.setCharacter(character)
                    findNavController().navigate(R.id.action_fragmentLocation_to_fragmentCharDetail)
                }
            },it)
        }

    }
}