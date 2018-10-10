package ru.supernacho.kt.passepartout.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.supernacho.kt.passepartout.R
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.presenter.ProductPresenter
import ru.supernacho.kt.passepartout.view.viewholders.CategoryViewHolder

class CategoryRvAdapter(val presenter: ProductPresenter): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var categories = listOf<CategoryEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view, presenter)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = holder as? CategoryViewHolder
        view?.categoryName?.text = categories[position].categoryName
    }
}