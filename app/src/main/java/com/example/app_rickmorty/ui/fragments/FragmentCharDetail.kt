package com.example.app_rickmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.app_rickmorty.R
import com.example.app_rickmorty.databinding.FragmentCharacterDetailBinding
import com.example.app_rickmorty.model.data.personajes.CharacterResult
import com.example.app_rickmorty.ui.CharacterModel
import com.example.app_rickmorty.ui.MainActivity

class FragmentCharDetail : Fragment() {
    private  lateinit var binding: FragmentCharacterDetailBinding
    private val viewModel by activityViewModels<CharacterModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getCharacter().observe(viewLifecycleOwner){
            fillCharacterData(it)
        }
    }

    private fun fillCharacterData(character: CharacterResult) {
        binding.tvNombre.text = character.name

        binding.tvStatus.text = "Status: " + character.status

        binding.tvOrigin.text = character.origin.name

        if (character.type.isNullOrEmpty()){
            binding.tvSpecies.text = character.species
        }else{
            binding.tvSpecies.text = character.type
        }


        if (character.gender== "Female"){
            binding.imgGender.setImageResource(R.drawable.baseline_female_24)
        }else if (character.gender=="Male"){
            binding.imgGender.setImageResource(R.drawable.baseline_male_24)
        }

        Glide.with(this).load(character.image).into(binding.imgChar)

        (requireActivity() as MainActivity).supportActionBar?.title = character.name
    }
}