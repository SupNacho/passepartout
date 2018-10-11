package ru.supernacho.kt.passepartout.view.viewholders

import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.priceview_item.view.*
import ru.supernacho.kt.passepartout.model.entity.ShopPricesEntity
import ru.supernacho.kt.passepartout.presenter.ProductPresenter

class ProductViewHolder(val view: View, presenter: ProductPresenter): RecyclerView.ViewHolder(view) {
    companion object {
        var count = 100
    }
    val productName: TextView
    val productShopPrice: TextView

    init {
        productName = view.tv_product_name
        productShopPrice = view.tv_shop_price

        productName.setOnClickListener {
            Log.d("UI", " Product selected: ${presenter.products[layoutPosition].productWithCategoryEntity.product.productName}")
        }
    }

    fun addPrice(shopPrice: ShopPricesEntity){
        val tvPrice = TextView(view.context)
        tvPrice.id = count
        tvPrice.textSize = 16f


        view.cl_priceview_item.addView(tvPrice)
        tvPrice.text = shopPrice.price.toString()

    }
}