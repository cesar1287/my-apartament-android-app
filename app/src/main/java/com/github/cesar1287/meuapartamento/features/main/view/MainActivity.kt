package com.github.cesar1287.meuapartamento.features.main.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.github.cesar1287.meuapartamento.R
import com.github.cesar1287.meuapartamento.features.main.viewmodel.MainViewModel
import com.github.cesar1287.meuapartamento.features.payment.view.PaymentActivity
import com.github.cesar1287.meuapartamento.util.ConstantsUtil.Main.RC_SIGN_IN
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkIfUserIsLoggedIn()
    }

    private fun checkIfUserIsLoggedIn() {
        val user = FirebaseAuth.getInstance().currentUser

        user?.let {
            startActivity(Intent(this, PaymentActivity::class.java))
        } ?: run {
            // Create and launch sign-in intent
            startFirebaseUIAuthActivity()
        }
    }

    private fun startFirebaseUIAuthActivity() {
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(mainViewModel.getProviders())
                .setIsSmartLockEnabled(false)
                .setTheme(R.style.AppTheme)
                .build(),
            RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                user?.let {
                    mainViewModel.saveUser(it)
                    mainViewModel.getPayments()
                } ?: run {
                    //todo show error user null
                }

                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
                //todo handle error
                finish()
            }
        }
    }
}