package ru.supernacho.kt.passepartout.view.viewholders

import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_item.view.*
import ru.supernacho.kt.passepartout.presenter.ProductPresenter

class CategoryViewHolder(val view: View, val presener: ProductPresenter): RecyclerView.ViewHolder(view){
    val categoryName: TextView
    val categoryFrame: FrameLayout
    init {
        categoryFrame = view.fl_category_item_bg
        categoryName = view.tv_category_item_name
        categoryFrame.setOnClickListener {
            Log.d("UI", "Selected category: ${presener.categories[layoutPosition].categoryName}")
        }
    }
}