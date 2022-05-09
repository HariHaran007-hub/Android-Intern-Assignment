package com.example.internshipproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.internshipproject.data.model.Size
import com.example.internshipproject.databinding.QuantityBinding

class QuantityAdapter : RecyclerView.Adapter<QuantityAdapter.QuantityViewHolder>(){

    private val callback = object : DiffUtil.ItemCallback<Size>(){
        override fun areItemsTheSame(oldItem: Size, newItem: Size): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Size, newItem: Size): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuantityViewHolder {
       val binding =QuantityBinding
           .inflate(LayoutInflater.from(parent.context), parent, false)
        return QuantityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuantityViewHolder, position: Int) {
        val size = differ.currentList[position]
        holder.bind(size!!)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class QuantityViewHolder (
        private var quantityBinding: QuantityBinding
    ) : RecyclerView.ViewHolder(quantityBinding.root){
        fun bind(size: Size){
            quantityBinding.crustSize.text = size.name
            quantityBinding.price.text = size.price.toString()
            quantityBinding.crustName.text = size.crustName
            quantityBinding.customizeBtn.setOnClickListener {
                onItemClickListener?.let {
                    it(size)
                }
            }
        }
    }

    //Set upping the recyclerview click listener
    private var onItemClickListener : ((Size)->Unit) ? = null

    fun setOnItemClickListener(listener : (Size)->Unit){
        onItemClickListener = listener
    }
}