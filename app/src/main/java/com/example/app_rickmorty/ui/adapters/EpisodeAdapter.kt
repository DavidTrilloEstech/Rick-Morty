package com.example.app_rickmorty.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickmorty.databinding.VistaPersonajeBinding

class EpisodeAdapter (val listaCap : List<String>): RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: VistaPersonajeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return listaCap.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}