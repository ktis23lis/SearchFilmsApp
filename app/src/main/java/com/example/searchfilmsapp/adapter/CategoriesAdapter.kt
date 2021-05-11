package com.example.searchfilmsapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilmsapp.databinding.ItemListsBinding
import com.example.searchfilmsapp.model.entities.Film
import com.example.searchfilmsapp.model.interfaces.OnItemViewClickListener


class CategoriesAdapter( var onItemViewClickListener: OnItemViewClickListener) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private var filmsData : List<Film> = listOf()
    private lateinit var binding: ItemListsBinding


    private val adapter = FilmsAdapter(onItemViewClickListener)



    fun setFilm (data : List<Film>){
        filmsData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        binding = ItemListsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CategoryViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(filmsData[position])
    }

    override fun getItemCount(): Int {
        return filmsData.size
    }

    inner class CategoryViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){
        fun bind (film : Film) = with (binding){
            categoriesTextView.text = film.categories.division
            recyclerFilmsViewList.adapter = adapter
            adapter.setListFilm(filmsData)
        }
    }
}

