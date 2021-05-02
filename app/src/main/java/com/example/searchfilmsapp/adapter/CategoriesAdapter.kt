package com.example.searchfilmsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilmsapp.databinding.ItemListsBinding
import com.example.searchfilmsapp.ui.main.Film

class CategoriesAdapter ():
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private var filmsData : List<Film> = listOf()
    private lateinit var binding: ItemListsBinding

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
            divisionTextView.text = film.categories.division
            root.setOnClickListener{
                Toast.makeText(itemView.context, "Позже вы сможете попасть в описание фильма," +
                        "но это позже" , Toast.LENGTH_LONG).show()
            }
        }
    }
}