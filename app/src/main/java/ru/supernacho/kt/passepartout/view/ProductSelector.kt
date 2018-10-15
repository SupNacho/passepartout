package ru.supernacho.kt.passepartout.view

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_product_selector.*
import kotlinx.android.synthetic.main.app_bar_product_selector.*
import kotlinx.android.synthetic.main.content_product_selector.*
import ru.supernacho.kt.passepartout.App
import ru.supernacho.kt.passepartout.R
import ru.supernacho.kt.passepartout.model.entity.CategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithCategoryEntity
import ru.supernacho.kt.passepartout.model.entity.ProductWithPrices
import ru.supernacho.kt.passepartout.mvpmoxyfix.MvpAppCompatActivity
import ru.supernacho.kt.passepartout.presenter.ProductPresenter
import ru.supernacho.kt.passepartout.view.adapters.CategoryRvAdapter
import ru.supernacho.kt.passepartout.view.adapters.ProductsRvAdapter
import ru.supernacho.kt.passepartout.view.dialogs.AddCategoryDialogFragment
import ru.supernacho.kt.passepartout.view.util.CategoryDiffUtilCallBack
import ru.supernacho.kt.passepartout.view.util.ProdsCatsDiffUtilCallBack
import javax.inject.Inject

class ProductSelector : MvpAppCompatActivity(), ProductView, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var app: App

    @InjectPresenter
    lateinit var presenter: ProductPresenter

    private lateinit var categoryAdapter: CategoryRvAdapter
    private lateinit var productsAdapter: ProductsRvAdapter
    private lateinit var catLayoutManager : LinearLayoutManager
    private lateinit var productsLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_selector)
        setSupportActionBar(toolbar)
        App.instance.appComponent.inject(this)
        fabInit()
        navDrawerInit()
        initCategoriesRv()
        initProductsRv()
        presenter.getProductsByCategory(null)
        presenter.getCategories()
    }

    private fun initProductsRv() {
        productsAdapter = ProductsRvAdapter(presenter)
        productsLayoutManager = LinearLayoutManager(this)
        productsLayoutManager.orientation = RecyclerView.VERTICAL
        val productsRv = this.rv_products_prod_selector
        productsRv.layoutManager = productsLayoutManager
        productsRv.adapter = productsAdapter
    }

    private fun initCategoriesRv() {
        categoryAdapter = CategoryRvAdapter(presenter)
        catLayoutManager = LinearLayoutManager(this)
        catLayoutManager.orientation = RecyclerView.HORIZONTAL
        val categoryRv = this.rv_categories_prod_selector
        categoryRv.layoutManager = catLayoutManager
        categoryRv.adapter = categoryAdapter
    }

    @ProvidePresenter
    fun providePresenter(): ProductPresenter {
        val presenter = ProductPresenter(AndroidSchedulers.mainThread())
        App.instance.appComponent.inject(presenter)
        return presenter
    }


    override fun updateCategories(categories: List<CategoryEntity>) {
        val pos = catLayoutManager.findLastVisibleItemPosition()
        val catDiffUtil = CategoryDiffUtilCallBack(categoryAdapter.categories, categories)
        val diffResult = DiffUtil.calculateDiff(catDiffUtil)
        diffResult.dispatchUpdatesTo(categoryAdapter)
        categoryAdapter.categories = categories
        catLayoutManager.scrollToPositionWithOffset(pos, 0)
    }

    override fun updateProducts(products: List<ProductWithPrices>) {
        val pos = productsLayoutManager.findLastVisibleItemPosition()
        val diffResult = DiffUtil.calculateDiff(ProdsCatsDiffUtilCallBack(productsAdapter.products, products))
        diffResult.dispatchUpdatesTo(productsAdapter)
        productsAdapter.products = products
        productsLayoutManager.scrollToPositionWithOffset(pos, 0)
    }

    private fun navDrawerInit() {
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun fabInit() {
        fab.setOnClickListener { view ->
            tempAddCategory()
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action") {
                        presenter.checkDb()
                        presenter.getCategories()
                    }.show()
        }
    }

    private fun tempAddCategory(){
        AddCategoryDialogFragment().show(supportFragmentManager, "123123")
    }

    fun updateCategories(){
        presenter.getCategories()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.product_selector, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
