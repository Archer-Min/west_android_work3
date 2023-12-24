package com.example.work3_bilibili.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.work3_bilibili.R
import com.example.work3_bilibili.adapter.UpInfoAdapter
import com.example.work3_bilibili.adapter.DynamicInfoAdapter
import com.example.work3_bilibili.data.DataSender
import com.example.work3_bilibili.data.UpInfo
import com.example.work3_bilibili.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var upInfoList: MutableList<UpInfo>

    private lateinit var upInfoAdapter: UpInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        upInfoList = DataSender.prepareUpData()


        upInfoAdapter = UpInfoAdapter(upInfoList) { position ->
            val viewPager: ViewPager2 = findViewById(R.id.activityViewpager)
            viewPager.setCurrentItem(position, true)
        }

        val recyclerView: RecyclerView = binding.upList
        recyclerView.adapter = upInfoAdapter

        val viewPager: ViewPager2 = findViewById(R.id.activityViewpager)
        viewPager.adapter = DynamicInfoAdapter(upInfoList)
    }


    // 在 onActivityResult 方法中处理返回的数据
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val unfollowStatus = data?.getBooleanExtra("unfollowStatus", false)
                val upInfo: UpInfo? = data?.getParcelableExtra("upInfo")
                if (unfollowStatus == true) {
                    // 根据 upInfo 对象从 upInfoList 中删除对应的条目
                    val index = upInfoList.indexOfFirst { it.name == upInfo?.name }
                    Log.d("d", index.toString())
                    if (index != -1) {
                        upInfoList.removeAt(index)
                        upInfoAdapter.notifyDataSetChanged()
                    }
                } else {
                    if (upInfo != null) {
                        upInfoList.add(upInfo)
                        upInfoAdapter.notifyDataSetChanged()
                    }
                }
            }
        }

        //通知适配器数据已更改
        val recyclerView: RecyclerView = binding.upList
        recyclerView.adapter = upInfoAdapter
        recyclerView.adapter?.notifyDataSetChanged()
        val viewPager: ViewPager2 = findViewById(R.id.activityViewpager)
        viewPager.adapter = DynamicInfoAdapter(upInfoList)
        viewPager.adapter?.notifyDataSetChanged()
    }
}