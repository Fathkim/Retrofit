package com.fathkim.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fathkim.retrofit.data.UserItemResponse
import com.fathkim.retrofit.databinding.ItemUserBinding

class AdapterUser: RecyclerView.Adapter<AdapterUser.UserViewHolder>() {
    private val listUser = ArrayList<UserItemResponse>()

    class UserViewHolder(val itemUser: ItemUserBinding): RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder (
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemUser.apply {
            with(listUser[position]){
                TextView.text = login
                Glide.with(ImageView.context).load(avatarUrl).into(ImageView)
            }
        }
    }

    override fun getItemCount(): Int = listUser.size

        fun setUser(user: ArrayList<UserItemResponse>){
            this.listUser.clear()
            this.listUser.addAll(user)
        }


}