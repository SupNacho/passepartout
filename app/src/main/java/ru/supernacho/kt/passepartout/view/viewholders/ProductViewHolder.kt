package ru.supernacho.kt.passepartout.view.viewholders

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.priceview_item.view.*
import ru.supernacho.kt.passepartout.presenter.ProductPresenter

class ProductViewHolder(val view: View, presenter: ProductPresenter): RecyclerView.ViewHolder(view) {
    val productName: TextView
    val productShopPrice: TextView
    init {
        productName = view.tv_product_name
        productShopPrice = view.tv_shop_price

        productName.setOnClickListener {
            Log.d("UI", " Product selected: ${presenter.products[layoutPosition].product.productName}")
        }
    }
}