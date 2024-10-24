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
            state.update { it.copy(isLoading = true) }

            delay(500)
            if (validate(login, password)) {
                state.update { it.copy(error = null, isValid = true) }
            } else {
                state.update { it.copy(error = "Wrong login or password", isValid = false) }
            }

            state.update { it.copy(isLoading = false) }
        }
    }

    private fun validate(login: String, password: String): Boolean {
        return login.length >= 6 && password.length >= 6
    }

    val state = MutableStateFlow(LoginState.init())
}