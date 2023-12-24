package com.example.work3_bilibili.adapter

import android.app.Activity
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.work3_bilibili.R
import com.example.work3_bilibili.data.UpInfo
import com.example.work3_bilibili.ui.DetailActivity

class UpInfoAdapter(
    private val userList: MutableList<UpInfo>,
    private val onItemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<UpInfoAdapter.UpInfoViewHolder>() {

    var selectedItem = -1 // 初始化选中项为-1（未选中任何项）

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_info, parent, false)
        return UpInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpInfoViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.avatar.setImageResource(currentUser.avatarResId)
        holder.name.text = currentUser.name

        // 设置选中项时头像放大
        holder.avatar.scaleX = if (position == selectedItem) 1.2f else 1.0f
        holder.avatar.scaleY = if (position == selectedItem) 1.2f else 1.0f

        holder.itemView.setOnClickListener {
            // 更新选中项索引
            val previousSelectedItem = selectedItem
            selectedItem = holder.absoluteAdapterPosition
            notifyItemChanged(previousSelectedItem)
            notifyItemChanged(selectedItem)

            onItemClickListener.invoke(position)
        }

        holder.itemView.setOnLongClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)

            intent.putExtra("upInfo", userList[position]) // 将 UpInfo 对象传递到 DetailActivity
            (context as Activity).startActivityForResult(intent, 1)
            true // 返回 true 表示已处理长按事件
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UpInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
        val name: TextView = itemView.findViewById(R.id.textViewName)
    }
}
