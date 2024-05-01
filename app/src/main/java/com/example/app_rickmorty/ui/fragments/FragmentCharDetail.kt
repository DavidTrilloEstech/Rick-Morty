package com.example.app_rickmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.app_rickmorty.R
import com.example.app_rickmorty.databinding.FragmentCharacterDetailBinding
import com.example.app_rickmorty.model.data.personajes.CharacterResult
import com.example.app_rickmorty.ui.CharacterModel
import com.example.app_rickmorty.ui.MainActivity
import com.example.app_rickmorty.ui.adapters.EpisodeAdapter

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

        binding.tvOrigin.setOnClickListener{
            findNavController().navigateUp()
        }

        binding.tvLocation.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun fillCharacterData(character: CharacterResult) {
        binding.tvNombre.text = character.name

        binding.tvStatus.text = character.status

        binding.tvOrigin.text = character.origin.name

        binding.tvLocation.text = character.location.name

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

        binding.recyclerView2.adapter=EpisodeAdapter(character.episode)


        (requireActivity() as MainActivity).supportActionBar?.title = character.name
    }
}