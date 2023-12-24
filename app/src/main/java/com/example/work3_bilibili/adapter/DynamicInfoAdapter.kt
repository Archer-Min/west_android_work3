package com.example.work3_bilibili.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work3_bilibili.R
import com.example.work3_bilibili.data.UpInfo

class DynamicInfoAdapter(
    private val dynamicList: MutableList<UpInfo>
) : RecyclerView.Adapter<DynamicInfoAdapter.DynamicInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DynamicInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dynamic_info, parent, false)
        return DynamicInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DynamicInfoViewHolder, position: Int) {
        val currentDynamic = dynamicList[position]
        holder.avatar.setImageResource(currentDynamic.avatarResId)
        holder.name.text = currentDynamic.name + "的动态"
        holder.content.text = currentDynamic.content
        holder.image.setImageResource(currentDynamic.imageResId)
    }

    override fun getItemCount(): Int {
        return dynamicList.size
    }

    class DynamicInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.upAvatar)
        val name: TextView = itemView.findViewById(R.id.upName)
        val content: TextView = itemView.findViewById(R.id.textViewDynamicContent)
        val image: ImageView = itemView.findViewById(R.id.imageViewDynamicImage)
    }
}