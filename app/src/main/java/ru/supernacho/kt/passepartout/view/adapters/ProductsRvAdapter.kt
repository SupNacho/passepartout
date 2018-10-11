package ru.supernacho.kt.passepartout.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.supernacho.kt.passepartout.R
import ru.supernacho.kt.passepartout.model.entity.ProductWithCategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithPrices
import ru.supernacho.kt.passepartout.presenter.ProductPresenter
import ru.supernacho.kt.passepartout.view.viewholders.CategoryViewHolder
import ru.supernacho.kt.passepartout.view.viewholders.ProductViewHolder

class ProductsRvAdapter(val presenter: ProductPresenter): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var products = listOf<ProductWithPrices>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.priceview_item, parent, false)
        return ProductViewHolder(view, presenter)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = holder as? ProductViewHolder
        view?.productName?.text = products[position].productWithCategoryEntity.product.productName
//        view?.productShopPrice?.text = products[position].shopPricesEntity[0].price.toString()
        products[position].shopPricesEntity.forEach {
//            view?.productShopPrice?.text = it.price.toString()
            view?.addPrice(it)
        }
    }
}