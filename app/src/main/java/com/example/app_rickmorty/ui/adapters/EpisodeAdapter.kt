package com.example.app_rickmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickmorty.databinding.VistaEpisodeBinding
import com.example.app_rickmorty.databinding.VistaPersonajeBinding

class EpisodeAdapter (val listaCap : List<String>): RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {
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
    }
}