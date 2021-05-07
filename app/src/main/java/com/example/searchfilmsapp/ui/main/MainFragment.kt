package com.example.searchfilmsapp.ui. main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.searchfilmsapp.R
import com.example.searchfilmsapp.databinding.MainFragmentBinding
import com.example.searchfilmsapp.adapter.CategoriesAdapter
import com.example.searchfilmsapp.adapter.FilmsAdapter
import com.example.searchfilmsapp.databinding.ItemListsBinding
import com.example.searchfilmsapp.model.AppState
import com.example.searchfilmsapp.model.entities.Film
import com.example.searchfilmsapp.model.interfaces.OnItemViewClickListener
import com.example.searchfilmsapp.ui.details.FilmFragment
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    private lateinit var _binding: MainFragmentBinding
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    //
    private val adapter = CategoriesAdapter()
    private var myadapter : FilmsAdapter?= null
    private lateinit var mybinding: ItemListsBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        mybinding = ItemListsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mybinding.recyclerFilmsViewList.adapter = myadapter
        binding.recyclerViewList.adapter = adapter
        viewModel = ViewModelProvider(this).get(MainViewModel :: class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getFilmsFromLocalStorage()
    }


    private fun renderData (appState : AppState){
        when(appState){
            is AppState.Success -> {
                _binding.loadingLayout.visibility  = View.GONE
                //блок ниже не работает, при нажатии ничего не происходит, код сюда не попадает почему не могу понять
                //если я делаю анналогично, только с адаптером CategoriesAdapter протсходит переход на другой фрагмент,
                //только после нажатия на категорию, а мне нужно на карточку FilmsAdapter
                myadapter = FilmsAdapter(object : OnItemViewClickListener{
                    override fun onItemViewClick(film: Film) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(FilmFragment.BUNDLE_EXTRA, film)
                            }
                            manager.beginTransaction()
                                .add(R.id.container, FilmFragment.newInstance(bundle))
                                .addToBackStack("")
                                .commitAllowingStateLoss()
                        }
                    }
                }).apply { setListFilm(appState.filmsData)
                }
                adapter.setFilm(appState.filmsData)
            }
            is AppState.Loading -> {
                _binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                _binding.loadingLayout.visibility = View.GONE
                Snackbar
                    .make(_binding.mainView, getString(R.string.error), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.reload)) {viewModel.getFilmsFromLocalStorage()}
                    .show()
            }
        }

    }




}

