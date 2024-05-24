package com.example.app_rickmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app_rickmorty.R
import com.example.app_rickmorty.databinding.FragmentEpisodeBinding
import com.example.app_rickmorty.model.data.Episodios.EpisodeResult
import com.example.app_rickmorty.model.data.personajes.Character
import com.example.app_rickmorty.model.data.personajes.CharacterResult
import com.example.app_rickmorty.ui.CharacterModel
import com.example.app_rickmorty.ui.MainActivity
import com.example.app_rickmorty.ui.adapters.CharacterAdapter
import com.example.app_rickmorty.ui.adapters.EpisodeAdapter

class FragmentEpisode : Fragment() {

    private lateinit var binding: FragmentEpisodeBinding
    private val viewModel by activityViewModels<CharacterModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setEpisode().observe(viewLifecycleOwner){
            fillData(it)
        }
    }

    private fun fillData(episode : EpisodeResult) {

        var temporada = "Temporada "

        if (episode.episode.substring(1, 3).startsWith("0")) {
            temporada += episode.episode.substring(2, 3)
        } else {
            temporada += episode.episode.substring(1, 3)
        }

        var episodio = "Episodio "

        if (episode.episode.substring(4).startsWith("0")) {
            episodio += episode.episode.substring(5)
        } else {
            episodio += episode.episode.substring(4)
        }


        binding.tvNombreEpisode.text = episode.name
        binding.tvAirDateEpisode.text = episode.air_date
        binding.tvTemporada.text = temporada
        binding.tvNumeroEpisodio.text = episodio

        (requireActivity() as MainActivity).supportActionBar?.title = episode.episode

        var stringId = ""
        for (i in episode.characters) {
            stringId += i.substring(42) + ", "
        }

        viewModel.getCharactersPorId(stringId).observe(viewLifecycleOwner) {
            binding.recyclerCharactersEpisode.adapter =
                CharacterAdapter(requireContext(), object : CharacterAdapter.Myclick {
                    override fun onHolderClick(character: CharacterResult) {
                        viewModel.setCharacter(character)
                        findNavController().navigate(R.id.action_fragmentLocation_to_fragmentCharDetail)
                    }
                }, it)
        }
    }
}