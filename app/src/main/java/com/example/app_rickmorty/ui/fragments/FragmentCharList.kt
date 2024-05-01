package com.example.app_rickmorty.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app_rickmorty.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.Observer
import com.example.app_rickmorty.databinding.FragmentCharacterListBinding
import com.example.app_rickmorty.model.data.personajes.CharacterResult
import com.example.app_rickmorty.ui.CharacterModel
import com.example.app_rickmorty.ui.adapters.CharacterAdapter

class FragmentCharList : Fragment() {
    private lateinit var binding: FragmentCharacterListBinding
    private val viewModel by activityViewModels<CharacterModel>()
    private var currentPage = 1
    private var totaLPage = 42
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actualizarPagina()

        binding.btnMinusPage.setOnClickListener{
            currentPage--
            if (currentPage>totaLPage){
                currentPage=1
            }else if (currentPage==0){
                currentPage=totaLPage
            }
            actualizarPagina()
        }

        binding.btnPlusPage.setOnClickListener{
            currentPage++
            if (currentPage>totaLPage){
                currentPage=1
            }else if (currentPage==0){
                currentPage=totaLPage
            }
            actualizarPagina()
        }

        binding.floatingActionButton.setOnClickListener{
            if (!binding.editTextText.text.isNullOrEmpty()){
                viewModel.getCharByName(binding.editTextText.text.toString())
            }
        }
    }

    fun actualizarPagina(){
        viewModel.getPagina(currentPage).observe(viewLifecycleOwner) { character ->
            val list = character.characterResults

            val adaptador= CharacterAdapter( requireContext(), object : CharacterAdapter.Myclick {
                override fun onHolderClick(character: CharacterResult) {
                    viewModel.setCharacter(character)
                    findNavController().navigate(R.id.action_fragmentCharList_to_fragmentCharDetail)
                }
            },list)
            binding.recyclerView.adapter=adaptador
        }
    }
}

