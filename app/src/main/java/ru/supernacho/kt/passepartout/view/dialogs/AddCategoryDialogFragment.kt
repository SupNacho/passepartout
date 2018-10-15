package ru.supernacho.kt.passepartout.view.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.add_category_dialog_fragment.view.*
import ru.supernacho.kt.passepartout.App
import ru.supernacho.kt.passepartout.R
import ru.supernacho.kt.passepartout.mvpmoxyfix.MvpAppCompatDialogFragment
import ru.supernacho.kt.passepartout.presenter.AddCatDialogPresenter
import ru.supernacho.kt.passepartout.view.ProductSelector
import java.lang.RuntimeException

class AddCategoryDialogFragment : MvpAppCompatDialogFragment(), IAddCtaegoryDialog {
    @InjectPresenter
    lateinit var presenter: AddCatDialogPresenter

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogContext = context
        val alertDialog: AlertDialog.Builder
        if (dialogContext != null) {
            alertDialog = AlertDialog.Builder(dialogContext)
            val view = activity?.layoutInflater?.inflate(R.layout.add_category_dialog_fragment, null)
            alertDialog.setView(view)
            val categoryField = view?.et_add_category
            view?.btn_add_category?.setOnClickListener {
                if (!categoryField?.text.isNullOrEmpty())
                    addCategory(categoryField?.text.toString())
            }
            view?.btn_cancel_add_category?.setOnClickListener {
                onCancel()
            }

            return alertDialog.create()
        }
        throw RuntimeException("Dialog context destroyed")
    }

    @ProvidePresenter
    fun providePresenter(): AddCatDialogPresenter {
        val presenter = AddCatDialogPresenter(AndroidSchedulers.mainThread())
        App.instance.appComponent.inject(presenter)
        return presenter
    }

    private fun addCategory(categoryName: String) {
        presenter.addCategory(categoryName)
    }

    override fun onSuccess() {
        (activity as ProductSelector).updateCategories()
        this.dismiss()
    }

    override fun onError() {
        Toast.makeText(context, "Getting error while adding category", Toast.LENGTH_SHORT).show()
    }

    private fun onCancel() {
        this.dismiss()
    }
}