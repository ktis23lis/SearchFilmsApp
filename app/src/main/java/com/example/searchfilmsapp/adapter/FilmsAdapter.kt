package com.example.searchfilmsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilmsapp.databinding.FilmsItemBinding
import com.example.searchfilmsapp.model.AppState
import com.example.searchfilmsapp.model.entities.Film
import com.example.searchfilmsapp.model.interfaces.OnItemViewClickListener


class FilmsAdapter(private var onItemViewClickListener: OnItemViewClickListener) :
        RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    private var filmsData : List< Film> = mutableListOf()
    private lateinit var binding: FilmsItemBinding

    fun setListFilm (data : List<Film>){
        filmsData = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
       binding = FilmsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int)  {
        holder.bind(filmsData[position])
    }

    override fun getItemCount(): Int {
        return filmsData.size
    }

    inner class FilmsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
            fun bind(film: Film) = with(binding){
                imageView.setImageResource(film.image)
                filmsmNameTextView.text = film.name
                earReleaseTextView.text = film.date.toString()
                root.setOnClickListener {
                    onItemViewClickListener.onItemViewClick(film)
                }
                }

            
    }
}