package com.github.cesar1287.meuapartamento.features.payment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.core.widget.addTextChangedListener
import br.com.concrete.canarinho.watcher.ValorMonetarioWatcher
import com.github.cesar1287.meuapartamento.R
import com.github.cesar1287.meuapartamento.extensions.brlToDouble
import com.github.cesar1287.meuapartamento.features.payment.viewmodel.PaymentViewModel
import com.github.cesar1287.meuapartamento.util.MaskWatcher
import kotlinx.android.synthetic.main.activity_payment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

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
            it?.let { quantity ->
                val totalAmount = tilPaymentTotalAmount.editText?.text.toString().brlToDouble()
                val initialValue = tilPaymentInitialValue.editText?.text.toString().brlToDouble()
                val valueToDeposit = viewModel.getValueToDeposit(totalAmount, initialValue, quantity.toString().brlToDouble())
                tilPaymentDepositValue.editText?.text = Editable.Factory.getInstance().newEditable(valueToDeposit.toString())
            }
        }
    }

    private fun setupViews() {
        tilPaymentTotalAmount.editText?.addTextChangedListener(ValorMonetarioWatcher())
        tilPaymentDepositValue.editText?.addTextChangedListener(ValorMonetarioWatcher())
        tilPaymentInitialValue.editText?.addTextChangedListener(ValorMonetarioWatcher())
    }
}