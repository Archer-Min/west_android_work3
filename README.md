# 西二安卓作业3

## 问题记录

### APK打包

安装时提示解析包时出现问题，修改minSDK

参考https://blog.csdn.net/crazestone0614/article/details/127979666

### MutableList

不可变列表 (`List`)，无法直接使用 `removeAt()` 方法来删除元素，改为`MutableList<UpInfo>`

`drop` 函数并不会在原始列表上执行删除操作，它返回一个新列表，该列表中包含了原始列表中除去前 `index` 个元素之外的所有元素。

### 刷新 RecyclerView

-  **notifyDataSetChanged()**

  - **作用**：刷新整个 RecyclerView，重新绘制所有可见的列表项。

  - **使用场景**：当数据集整体变化（例如数据集完全更新、排序变化）时使用。

    `adapter.notifyDataSetChanged()`

-  **notifyItemChanged(position)**
  - **作用**：刷新指定位置的列表项。
  - **使用场景**：当某个特定位置的数据发生变化时使用，可以更新指定位置的视图。

-  **notifyItemInserted(position)**
  - **作用**：通知列表中插入了一个新的列表项。

-  **notifyItemRemoved(position)**
  - **作用**：通知列表中删除了一个列表项。

-  **notifyItemRangeChanged(startPosition, itemCount)**
  - **作用**：刷新指定范围内的列表项。

### Parcelable接口

将自定义对象打包成字节流，以便在应用内或应用之间传递。

```kotlin
import android.os.Parcel
import android.os.Parcelable

class ExampleObject(
    val name: String,
    val age: Int
) : Parcelable {

    // 写入数据到 Parcel 对象
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    // 从 Parcel 对象中读取数据并创建对象
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExampleObject> {
        // 从 Parcel 创建对象
        override fun createFromParcel(parcel: Parcel): ExampleObject {
            return ExampleObject(parcel)
        }

        // 创建指定长度的对象数组
        override fun newArray(size: Int): Array<ExampleObject?> {
            return arrayOfNulls(size)
        }
    }
}

```

