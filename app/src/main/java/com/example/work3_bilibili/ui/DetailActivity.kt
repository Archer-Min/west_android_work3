package com.example.work3_bilibili.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.work3_bilibili.R
import com.example.work3_bilibili.data.UpInfo
import com.example.work3_bilibili.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var isFollowing: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        // 获取传递的 UpInfo 对象
        val upInfo: UpInfo? = intent.getParcelableExtra("upInfo")
        if (upInfo != null) {

            val avatarImageView: ImageView = binding.imageViewAvatar
            avatarImageView.setImageResource(upInfo.avatarResId)

            val nameTextView: TextView = binding.upName
            nameTextView.text = upInfo.name

            val followersTextView: TextView = binding.followers
            followersTextView.text = "粉丝\n ${upInfo.followers}"

            val friendsTextView: TextView = binding.friends
            friendsTextView.text = "关注\n ${upInfo.friends}"

            val likesTextView: TextView = binding.likes
            likesTextView.text = "点赞\n ${upInfo.likes}"

            val unfollowButton: Button = binding.unfollowButton

            val avatarImage: ImageView = binding.imageViewAvatar2
            avatarImage.setImageResource(upInfo.avatarResId)

            val name: TextView = binding.upName2
            name.text = upInfo.name

            val dynamicContent: TextView = binding.DynamicContent
            dynamicContent.text = upInfo.content

            val dynamicImage: ImageView = binding.DynamicImage
            dynamicImage.setImageResource(upInfo.imageResId)

            unfollowButton.setOnClickListener {
                if (isFollowing) {
                    // 执行取关操作
                    unfollowButton.text = "关注"
                    upInfo.followers--
                    // 返回取关成功的信息
                    val resultIntent = Intent()
                    resultIntent.putExtra("upInfo", upInfo) // 将 UpInfo 对象传递到 MainActivity
                    resultIntent.putExtra("unfollowStatus", true)
                    setResult(Activity.RESULT_OK, resultIntent)
                    Toast.makeText(this, "取关成功", Toast.LENGTH_SHORT).show()
                } else {
                    // 执行关注操作
                    unfollowButton.text = "取关"
                    upInfo.followers++
                    // 重新关注，把up信息添加回来
                    val resultIntent = Intent()
                    resultIntent.putExtra("upInfo", upInfo) // 将 UpInfo 对象传递到 MainActivity
                    resultIntent.putExtra("unfollowStatus", false)
                    setResult(Activity.RESULT_OK, resultIntent)
                    Toast.makeText(this, "关注成功", Toast.LENGTH_SHORT).show()
                }
                followersTextView.text = "粉丝\n ${upInfo.followers}" // 更新粉丝数
                isFollowing = !isFollowing

            }
        }
    }
}