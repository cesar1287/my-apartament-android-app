package com.github.cesar1287.meuapartamento.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.github.cesar1287.meuapartamento.R
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
            //todo user logged in
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
                .build(),
            RC_SIGN_IN)
    }
}