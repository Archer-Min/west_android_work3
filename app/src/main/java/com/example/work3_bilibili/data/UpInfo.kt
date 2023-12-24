package com.example.work3_bilibili.data

import android.os.Parcel
import android.os.Parcelable

data class UpInfo(
    val avatarResId: Int,
    val name: String,
    //动态文字
    val content: String,
    //动态图片
    val imageResId: Int,
    //粉丝数
    var followers: Int,
    //关注数
    val friends: Int,
    //获赞数
    val likes: Int,
) : Parcelable {

    // 从 Parcel 中构造 UpInfo 实例
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    // 将 UpInfo 对象序列化到 Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(avatarResId)
        parcel.writeString(name)
        parcel.writeString(content)
        parcel.writeInt(imageResId)
        parcel.writeInt(followers)
        parcel.writeInt(friends)
        parcel.writeInt(likes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UpInfo> {
        override fun createFromParcel(parcel: Parcel): UpInfo {
            return UpInfo(parcel)
        }

        override fun newArray(size: Int): Array<UpInfo?> {
            return arrayOfNulls(size)
        }
    }
}