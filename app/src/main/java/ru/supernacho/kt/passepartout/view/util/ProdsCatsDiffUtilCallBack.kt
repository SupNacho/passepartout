package ru.supernacho.kt.passepartout.view.util

import androidx.recyclerview.widget.DiffUtil
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithCategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithPrices

class ProdsCatsDiffUtilCallBack(private val oldList: List<ProductWithPrices>, private val newList: List<ProductWithPrices>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
    = oldList[oldItemPosition] == newList[newItemPosition]

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition].productWithCategoryEntity == newList[newItemPosition].productWithCategoryEntity
            && oldList[oldItemPosition].shopPricesEntity == newList[newItemPosition].shopPricesEntity
}