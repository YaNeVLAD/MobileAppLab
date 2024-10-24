package com.example.mobileprojectlab.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    fun onLoginButtonPressed(login: String, password: String) {
        viewModelScope.launch {
            state.update { it.copy(isInProgress = true) }

            delay(500)
            if (validate(login, password)) {
                state.update { it.copy(error = "", isInProgress = false) }
            } else {
                state.update { it.copy(error = "Wrong Password", isInProgress = false) }
            }
        }
    }

    private fun validate(login: String, password: String): Boolean {
        return login.length >= 6 && password.length >= 6
    }

    val state = MutableStateFlow(LoginState.init())
}