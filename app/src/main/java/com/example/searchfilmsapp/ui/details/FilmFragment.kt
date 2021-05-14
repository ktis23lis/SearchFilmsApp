package com.example.searchfilmsapp.ui.details

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.searchfilmsapp.databinding.FilmFragmentBinding
import com.example.searchfilmsapp.model.AppState
import com.example.searchfilmsapp.model.FilmsDTO
import com.example.searchfilmsapp.model.entities.Film
import com.google.gson.Gson
import kotlinx.android.synthetic.main.film_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors

@Suppress("NAME_SHADOWING")
class FilmFragment : Fragment() {
    private lateinit var binding: FilmFragmentBinding

    private val viewModel: FilmsViewModel by lazy {
     ViewModelProvider(this).get(FilmsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FilmFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        val film = arguments?. getParcelable<Film>(BUNDLE_EXTRA)
        film?.let {
            filmCategories.text = it.categories.division

        viewModel.liveDataToObserve.observe(this@FilmFragment, {appState ->
            when(appState){
                is AppState.Error ->{
                    loadingLayout.visibility = View.GONE
                }
                AppState.Loading -> loadingLayout.visibility = View.VISIBLE
                is AppState.Success->{
                    loadingLayout.visibility = View.GONE
//                    if (film != null) {
//                        filmImage.setImageResource(film.image)
//                    }
                    filmName.text = appState.filmsData[0].name?.toString()
                    filmEar.text = appState.filmsData[0].date?.toString()
                    filmDescription.text = appState.filmsData[0].description?.toString()
                }
            }
        })
        viewModel.loadData(it.categories.division)


//        arguments?.getParcelable<Film>(BUNDLE_EXTRA)?.let { film ->
//            film.categories.also { categories ->
//                filmCategories.text = categories.division
//            }
//            filmImage.setImageResource(film.image)
//            filmName.text = film.name
//            filmEar.text = film.date.toString()
//            filmDescription.text = film.description
//
                }
    }

    companion object {
        const val BUNDLE_EXTRA = "film"
        fun newInstance(bundle: Bundle): FilmFragment {
            val fragment = FilmFragment()
            fragment.arguments = bundle
             return fragment
        }
    }

//    private fun displayFilm(filmsDTO: FilmsDTO){
//        with(binding){
//            mainView.visibility = View.VISIBLE
//            loadingLayout.visibility = View.GONE
//            val category = filmsBundle.categories
//        }
//        filmImage.setImageResource(filmsBundle.image)
//        filmName.text = filmsDTO.fact?.name
//        filmEar.text = filmsDTO.fact?.date.toString()
//        filmDescription.text = filmsDTO.fact.description
//    }



}