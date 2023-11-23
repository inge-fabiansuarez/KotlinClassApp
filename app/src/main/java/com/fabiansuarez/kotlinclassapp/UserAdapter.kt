package com.fabiansuarez.kotlinclassapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fabiansuarez.kotlinclassapp.databinding.UserItemBinding

class UserAdapter(private var dataSet: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myUser: User) {
            binding.user = myUser
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: UserItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.user_item,
            parent,
            false
        )
        return UserAdapter.ViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet.get(position))
    }

    fun refresh(myDataSet: ArrayList<User>) {
        dataSet = myDataSet
        notifyDataSetChanged()
    }
}