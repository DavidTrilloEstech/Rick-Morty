package com.example.app_rickmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickmorty.databinding.VistaEpisodeBinding
import com.example.app_rickmorty.databinding.VistaPersonajeBinding
import com.example.app_rickmorty.model.data.Episodios.EpisodeResult
import com.example.app_rickmorty.model.data.personajes.CharacterResult

class EpisodeAdapter (val listaCap : List<String>, val listener : Myclick): RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    interface Myclick{
        fun onHolderClick(episode : String)
    }
    inner class ViewHolder(val binding: VistaEpisodeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(VistaEpisodeBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return listaCap.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val episode =listaCap[position]

        holder.binding.textView.text="Episodio " + episode.substring(40)

        holder.itemView.setOnClickListener {
            listener.onHolderClick(episode.substring(40))
        }
    }
}