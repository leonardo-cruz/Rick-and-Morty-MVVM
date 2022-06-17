package com.lcruz.rickandmorty.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lcruz.rickandmorty.R
import com.lcruz.rickandmorty.databinding.ItemCharactersMainBinding
import com.lcruz.rickandmorty.model.Character

class CharactersAdapter(val context: Context) :
    RecyclerView.Adapter<CharactersAdapter.MyViewHolder>() {
    var charactersList: MutableList<Character> = mutableListOf()

    class MyViewHolder(val binding: ItemCharactersMainBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemCharactersMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        charactersList[position].let { character ->
            holder.binding.run {
                Glide.with(context).load(character.image).placeholder(R.drawable.rick)
                    .into(this.ivCharacterItem)
                this.tvCharactersMain.text = character.name
            }
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    fun updateList(newList: MutableList<Character>) {
        charactersList = newList
        notifyDataSetChanged()
    }
}