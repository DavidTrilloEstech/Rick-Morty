package com.example.app_rickmorty.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_rickmorty.databinding.VistaPersonajeBinding
import com.example.app_rickmorty.model.data.personajes.CharacterResult




class CharacterAdapter(private val context:Context, private val listener: Myclick, private val characters: List<CharacterResult>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>(){

    interface Myclick{
        fun onHolderClick(character: CharacterResult)
    }

//    private val characters = ArrayList<CharacterResult>()

    inner class ViewHolder(val binding: VistaPersonajeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(VistaPersonajeBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character =characters[position]

        if (character.image.isNullOrEmpty()){
            character.image="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Rick_and_Morty.svg/1280px-Rick_and_Morty.svg.png"
        }

        Glide.with(context)
            .load(character.image)
            .into(holder.binding.imgChar)

        holder.binding.tvCharName.text=character.name

        holder.itemView.setOnClickListener {
            listener.onHolderClick(character)
        }
    }

//    fun refreshList(lista: List<CharacterResult>){
//            characters.clear()
//            characters.addAll(lista)
//    }
}