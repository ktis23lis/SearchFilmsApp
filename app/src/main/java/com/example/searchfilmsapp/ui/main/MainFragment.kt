package com.example.searchfilmsapp.ui. main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilmsapp.R
import com.example.searchfilmsapp.databinding.MainFragmentBinding
import com.example.searchfilmsapp.adapter.CategoriesAdapter
import com.example.searchfilmsapp.model.AppState
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var _binding: MainFragmentBinding
//    private  var data : Array <String> = resources.getStringArray(R.array.category)


    private val binding get() = _binding!!
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val adapter = CategoriesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
//        val view = binding.root
//        return view
//        initRecyclerView()
//        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewList.adapter = adapter
        viewModel = ViewModelProvider(this).get(MainViewModel :: class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getFilmsFromLocalStorage()

    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
////        val observer = Observer<Any>{
////            renderData(it)
//        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it as AppState) })
//        viewModel.getFilm()
////    }
//        viewModel.getData().observe(viewLifecycleOwner, observer)
//    }

    private fun renderData (appState : AppState){
        when(appState){
            is AppState.Success -> {
//                val filmsData = appState.filmsData
                _binding.loadingLayout.visibility  = View.GONE
                adapter.setFilm(appState.filmsData)
//            initRecyclerView(recyclerView, data)
//                setData(filmsData)
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



//    private fun setData(filmData: Film){
//
//
//    }
//    private fun initRecyclerView(recyclerView: RecyclerView, data: Array<String>){
////        val categoryList = generateCategoryLists(10)
//        recyclerView.adapter = CategoriesAdapter(data)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.setHasFixedSize(true)


    }

//    private fun generateCategoryLists(size : Int): List<Categories> {
//        val list = ArrayList<Categories>()
//        for (i in 0 until size){
//            val item = Categories("Item $i")
//            list +=item
//        }
//        return list
//    }







//
//}