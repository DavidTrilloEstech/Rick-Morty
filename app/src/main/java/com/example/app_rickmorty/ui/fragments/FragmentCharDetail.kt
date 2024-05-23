package com.example.app_rickmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.app_rickmorty.R
import com.example.app_rickmorty.databinding.FragmentCharacterDetailBinding
import com.example.app_rickmorty.model.data.personajes.CharacterResult
import com.example.app_rickmorty.model.retrofit.RetrofitHelper
import com.example.app_rickmorty.ui.CharacterModel
import com.example.app_rickmorty.ui.MainActivity
import com.example.app_rickmorty.ui.adapters.EpisodeAdapter

class FragmentCharDetail : Fragment() {
    private  lateinit var binding: FragmentCharacterDetailBinding
    private val viewModel by activityViewModels<CharacterModel>()
    private var location =""
    private var origin =""

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
            navegacionLocation(origin)
        }

        binding.tvLocation.setOnClickListener {
            navegacionLocation(location)
        }

    }

    private fun fillCharacterData(character: CharacterResult) {
        binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())

        location=character.location.url

        origin=character.origin.url

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

    private fun navegacionLocation(locationUrl : String){
        if (!locationUrl.isNullOrEmpty()){
            viewModel.setLocation(locationUrl.substring(41).toInt())
            findNavController().navigate(R.id.action_fragmentCharDetail_to_fragmentLocation)
        }


    }
}