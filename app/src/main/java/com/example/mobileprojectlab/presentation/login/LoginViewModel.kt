package com.example.mobileprojectlab.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileprojectlab.domain.login.ErrorEvent
import com.example.mobileprojectlab.domain.login.Event
import com.example.mobileprojectlab.domain.login.SuccessEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val state = MutableStateFlow(LoginState.init())
    val events = MutableSharedFlow<Event>()

    fun onLoginButtonPressed(login: String, password: String) {
        viewModelScope.launch {
            state.update { it.copy(isLoading = true) }

            delay(500)
            if (validate(login, password)) {
                sendSuccessEvent("Successful login!")
                state.update { it.copy(error = null, isValid = true) }
            } else {
                sendErrorEvent(true, "Wrong login or password")
                state.update { it.copy(error = "Wrong login or password", isValid = false) }
            }

            state.update { it.copy(isLoading = false) }
        }
    }

    private suspend fun sendSuccessEvent(text: String) {
        events.emit(SuccessEvent(text))
    }

    private suspend fun sendErrorEvent(isToast: Boolean, text: String?) {
        events.emit(ErrorEvent(isToast, text))
    }

    private fun validate(login: String, password: String): Boolean {
        return login.length >= 6 && password.length >= 6
    }
}