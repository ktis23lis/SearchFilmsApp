package com.example.searchfilmsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilmsapp.R
import com.example.searchfilmsapp.databinding.ItemListsBinding
import com.example.searchfilmsapp.model.Repository
import com.example.searchfilmsapp.model.RepositoryImpl
import com.example.searchfilmsapp.model.entities.Categories
import com.example.searchfilmsapp.model.entities.Film
import com.example.searchfilmsapp.model.interfaces.OnItemViewClickListener


class CategoriesAdapter( var onItemViewClickListener: OnItemViewClickListener) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {
    private val repository: Repository = RepositoryImpl()

    private lateinit var binding: ItemListsBinding
    private var categoriesData : List<Categories> = listOf()
    private val adapter = FilmsAdapter(onItemViewClickListener)

    fun setCategories(data : List<Categories>){
        categoriesData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        binding = ItemListsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = with (binding) {
        holder.bind2(categoriesData[position])
        var  filmsData : ArrayList<Film> = arrayListOf()
        when(position){
            0->filmsData.addAll(repository.getHorror())
            1->filmsData.addAll(repository.getDram())
        }
        adapter.setListFilm(filmsData)
    }

    override fun getItemCount(): Int {
        return categoriesData.size
    }

    inner class CategoryViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        fun bind2(categories: Categories)  = with (binding){
            categoriesTextView.text = categories.division
            recyclerFilmsViewList.adapter = adapter

        }
    }


}

