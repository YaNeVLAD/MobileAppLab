package com.example.mobileprojectlab.presentation.login

data class LoginState(
    val isValid: Boolean,
    val isLoading: Boolean,
    val error: String?,
) {
    companion object {
        fun init() = LoginState(
            isValid = false,
            isLoading = false,
            error = null
        )
    }
}
