package com.example.app_rickmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app_rickmorty.databinding.FragmentListBinding
import com.example.app_rickmorty.model.data.Personajes.Character
import com.example.app_rickmorty.model.data.Personajes.CharacterResult
import com.example.app_rickmorty.model.data.Personajes.Location
import com.example.app_rickmorty.model.data.Personajes.Origin
import com.example.app_rickmorty.ui.adapters.CharacterAdapter

class FragmentList : Fragment() {
    private lateinit var binding : FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lista = ArrayList<CharacterResult>()

        val adaptador = CharacterAdapter(requireContext())
        adaptador.refreshList(lista)
        binding.recyclerView.adapter=adaptador

    }
}