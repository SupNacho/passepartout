package ru.supernacho.kt.passepartout.view.util

import androidx.recyclerview.widget.DiffUtil
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity

class CategoryDiffUtilCallBack(private val oldList: List<CategoryEntity>, private val newList: List<CategoryEntity>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
    = oldList[oldItemPosition] == newList[newItemPosition]

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition].categoryName == newList[newItemPosition].categoryName
            && oldList[oldItemPosition].idCategory == newList[newItemPosition].idCategory
}