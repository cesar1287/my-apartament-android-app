package com.github.cesar1287.meuapartamento.features.payment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.core.widget.addTextChangedListener
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher
import com.github.cesar1287.meuapartamento.R
import com.github.cesar1287.meuapartamento.extensions.brlToDouble
import com.github.cesar1287.meuapartamento.features.payment.viewmodel.PaymentViewModel
import com.github.cesar1287.meuapartamento.util.MoneyTextWatcher
import kotlinx.android.synthetic.main.activity_payment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.ref.WeakReference

class PaymentActivity : AppCompatActivity() {

    private val viewModel: PaymentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        setupViews()
        setupObservables()
    }

    private fun setupObservables() {
        tilPaymentQuantity.editText?.addTextChangedListener {
            it?.let {
                val totalAmount = tilPaymentTotalAmount.editText?.text.toString().brlToDouble()
                val initialValue = tilPaymentInitialValue.editText?.text.toString().brlToDouble()
                val quantity = it.toString().brlToDouble()
                val valueToDepositPerMonth = viewModel.getValueToDepositPerMonth(totalAmount, initialValue, quantity)
                val paymentPerMonth = viewModel.getPaymentPerMonth(totalAmount, quantity)
                mtvPaymentValuePerMonth.text = valueToDepositPerMonth
                tilPaymentDepositValue.editText?.text = Editable.Factory.getInstance().newEditable(paymentPerMonth)
            }
        }
    }

    private fun setupViews() {
        tilPaymentTotalAmount.editText?.addTextChangedListener(MoneyTextWatcher(WeakReference(tilPaymentTotalAmount.editText!!)))
        tilPaymentDepositValue.editText?.addTextChangedListener(MoneyTextWatcher(WeakReference(tilPaymentDepositValue.editText!!)))
        tilPaymentInitialValue.editText?.addTextChangedListener(MoneyTextWatcher(WeakReference(tilPaymentInitialValue.editText!!)))
    }
}