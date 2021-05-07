package com.example.searchfilmsapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilmsapp.MainActivity
import com.example.searchfilmsapp.R
import com.example.searchfilmsapp.databinding.ItemListsBinding
import com.example.searchfilmsapp.model.entities.Film
import com.example.searchfilmsapp.model.interfaces.OnItemViewClickListener
import com.example.searchfilmsapp.ui.details.FilmFragment


class CategoriesAdapter :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    private var filmsData : List<Film> = listOf()
    private lateinit var binding: ItemListsBinding
//    private  var activity : MainActivity?= null

    private val adapter = FilmsAdapter(object : OnItemViewClickListener {
        override fun onItemViewClick(film: Film) {
            //есть подозрения что не работающий блок из mainFragment нужно перенести сюда, но
            //я не смогу обратьтся к методу getActivity, так как он только для фрагмента
//            val manager = activity?.supportFragmentManager
//            manager?.let { manager ->
//                val bundle = Bundle().apply {
//                    putParcelable(FilmFragment.BUNDLE_EXTRA, film)
//                }
//                manager.beginTransaction()
//                    .add(R.id.container, FilmFragment.newInstance(bundle))
//                    .addToBackStack("")
//                    .commitAllowingStateLoss()
//            }


        }
    })

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

