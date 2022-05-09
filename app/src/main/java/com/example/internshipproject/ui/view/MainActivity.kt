package com.example.internshipproject.ui.view

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshipproject.R
import com.example.internshipproject.base.ui.BaseActivity
import com.example.internshipproject.data.model.PizzaResponse
import com.example.internshipproject.data.model.Size
import com.example.internshipproject.databinding.ActivityMainBinding
import com.example.internshipproject.ui.adapter.QuantityAdapter
import com.example.internshipproject.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity() {
    private lateinit var mainVM: MainViewModel

    private lateinit var quantityAdapter : QuantityAdapter

    private lateinit var list: MutableList<Size>

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelSetUp()
        fetchPizzaDetails()
    }

    private fun viewModelSetUp(){
        viewModel = getViewModel<MainViewModel>()
        mainVM = viewModel as MainViewModel
    }

    private fun fetchPizzaDetails(){
        //Network call is successfully completed..
        mainVM.getPizzaDetails().observe(this){
            setUpRecyclerView(it)
        }
    }

    private fun setUpRecyclerView(pizzaResponse: PizzaResponse){
        list = mutableListOf()
        quantityAdapter = QuantityAdapter()
        for (p in pizzaResponse.crusts!!){
            for(s in p.sizes!!){
                s.crustName = p.name
                list.add(s)
            }
        }
        quantityAdapter.differ.submitList(list)

        binding.rvQuantity.apply {
            adapter = quantityAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }
}