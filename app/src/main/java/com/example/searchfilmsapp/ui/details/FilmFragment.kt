package com.example.searchfilmsapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.searchfilmsapp.databinding.FilmFragmentBinding
import com.example.searchfilmsapp.model.entities.Film


class FilmFragment : Fragment() {
    private lateinit var binding: FilmFragmentBinding

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FilmFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Film>(BUNDLE_EXTRA)?.let { film ->
            film.categories.also { categories ->
                filmCategories.text = categories.division
            }
            filmImage.setImageResource(film.image)
            filmName.text = film.name
            filmEar.text = film.date.toString()
            filmDescription.text = film.description
        }


//        val film = arguments?.getParcelable<Film>(BUNDLE_EXTRA)
//        if (film != null) {
//            val categories = film.categories
//            filmCategories.text = categories.division
//            filmImage.setImageResource(film.image)
//            filmName.text = film.name
//            filmEar.text = film.date.toString()
//            filmDescription.text = film.description
//        }
    }

    companion object {
        const val BUNDLE_EXTRA = "film"
        fun newInstance(bundle: Bundle): FilmFragment {
            val fragment = FilmFragment()
            fragment.arguments = bundle
             return fragment
        }
    }
}