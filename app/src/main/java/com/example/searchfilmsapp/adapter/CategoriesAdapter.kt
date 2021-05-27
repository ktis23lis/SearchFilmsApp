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
        val filmsData = ArrayList<Film>()
        if (position == 0) {
            val myArray = repository.getDram()
            for (i in myArray) {
                filmsData.add(i)
            }
        }
        if (position == 1) {
            val myArray = repository.getHorror()
            for (i in myArray) {
                filmsData.add(i)
            }
        }
         val adapter = FilmsAdapter(onItemViewClickListener,filmsData)
        holder.recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = categoriesData.size

    inner class CategoryViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        val recyclerView : RecyclerView = itemView.findViewById(R.id.recyclerFilmsViewList)
        fun bind2(categories: Categories)  = with (binding){
            categoriesTextView.text = categories.division


        }
    }


}

