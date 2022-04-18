package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.API.Character

class CharactersAdapter(): RecyclerView.Adapter<CharactersViewHolder>() {
    private var charactersList = mutableListOf<com.example.myapplication.API.Character>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        var item: com.example.myapplication.API.Character = charactersList[position]
        Glide.with(holder.binding.imageView.context)
            .load(item.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.binding.imageView)
        holder.binding.textView.text = item.name
        holder.binding.textView2.text = item.gender
        holder.binding.textView3.text = item.species
        holder.binding.item.setOnClickListener{
            var bundle = Bundle()
            bundle.putLong("key", item.id)
            holder.binding.root.findNavController().navigate(R.id.characterFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
    fun addList(charactersList: List<Character>){
        this.charactersList.clear()
        this.charactersList.addAll(charactersList)
        notifyDataSetChanged()
    }
}

class CharactersViewHolder(var binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {

}
