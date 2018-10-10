package ru.supernacho.kt.passepartout.view.util

import androidx.recyclerview.widget.DiffUtil
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithCategoryEntity

class ProdsCatsDiffUtilCallBack(private val oldList: List<ProductWithCategoryEntity>, private val newList: List<ProductWithCategoryEntity>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
    = oldList[oldItemPosition] == newList[newItemPosition]

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition].category == newList[newItemPosition].category
            && oldList[oldItemPosition].product == newList[newItemPosition].product
}