package com.example.ch6top1.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ch6top1.databinding.ItemUserBinding
import com.example.ch6top1.model.ResponseDataUserItem


class UserAdapter (var listUser : List<ResponseDataUserItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder (var binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.Nama.text = listUser[position].name
        holder.binding.Umur.text = listUser[position].age.toString()
        holder.binding.Address.text = listUser[position].address
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}