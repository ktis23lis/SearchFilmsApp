package com.example.searchfilmsapp.ui. main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.searchfilmsapp.R
import com.example.searchfilmsapp.databinding.MainFragmentBinding
import com.example.searchfilmsapp.adapter.CategoriesAdapter
import com.example.searchfilmsapp.model.AppState
import com.example.searchfilmsapp.model.entities.Film
import com.example.searchfilmsapp.model.interfaces.OnItemViewClickListener
import com.example.searchfilmsapp.strings_iteractor.StringsInteractorImpl
import com.example.searchfilmsapp.ui.details.FilmFragment
import com.example.searchfilmsapp.ui.main.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.film_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private lateinit var _binding: MainFragmentBinding
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
    private var adapter : CategoriesAdapter?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewList.adapter = adapter
        viewModel.stringsInteractor = StringsInteractorImpl(requireContext())
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getFilmsFromLocalStorage()
    }


    private fun renderData (appState : AppState){
        when(appState){
            is AppState.Success -> {
                _binding.loadingLayout.visibility  = View.GONE
                adapter= CategoriesAdapter(object : OnItemViewClickListener{
                    override fun onItemViewClick(film: Film) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager->
                            val bundle = Bundle().apply {
                                putParcelable(FilmFragment.BUNDLE_EXTRA, film)
                            }
                            manager.beginTransaction()
                                    .add(R.id.container, FilmFragment.newInstance(bundle))
                                    .addToBackStack("")
                                    .commitAllowingStateLoss()
                        }
                    }
                }).apply {
//                    setFilm(appState.filmsData)
                    setCategories(appState.categoriesData)
                }
                recyclerViewList.adapter = adapter
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

