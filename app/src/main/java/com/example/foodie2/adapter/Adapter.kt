package com.example.foodie2.adapter

import Foods
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.foodie2.R
import com.example.foodie2.databinding.ItemViewBinding

class Adapter (private val context : Context, var foods: MutableList<Foods>) : RecyclerView.Adapter<Adapter.FoodHolder>(){
    private var listener: OnClickListener? = null

    class FoodHolder(itemViewBinding: ItemViewBinding):ViewHolder(itemViewBinding.root){
        var s = 0
        private val binding = itemViewBinding
        fun bind(food : Foods){
            binding.title.text = food.title
            binding.price.text = food.price.toString()
            binding.quantity.text = food.quantity.toString()
            binding.img.load(food.img){
                placeholder(R.drawable.ic_launcher_background)
            }
        }
        val plus = binding.plus
        val minus = binding.minus
        val quantity = binding.quantity



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {


        val binding = ItemViewBinding.inflate(LayoutInflater.from(context),parent,false)



        return FoodHolder(binding)

    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        val foodViewModel = foods[position]
        holder.bind(foodViewModel)
        holder.itemView.setOnClickListener {
            if (listener != null) {
                listener!!.onItemClick(position,foodViewModel )
            }
        }

        holder.plus.setOnClickListener {
            holder.s = holder.quantity.text.toString().toInt()
            holder.s++
            holder.quantity.text = holder.s.toString()
        }


        holder.minus.setOnClickListener {
            holder.s = holder.quantity.text.toString().toInt()
            if (holder.s>0) {
                holder.s--
                holder.quantity.text=holder.s.toString()
            }
        }

    }

    override fun getItemCount(): Int {
        return foods.size
    }

    fun setOnClickListener(listenerr: OnClickListener) {
        this.listener = listenerr
    }

    interface OnClickListener {
        fun onItemClick( position: Int, food: Foods)
    }
}