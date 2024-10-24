package com.example.mobileprojectlab.presentation.login

data class LoginState(
    val isInProgress: Boolean,
    val error: String?,
) {
    companion object {
        fun init() = LoginState(false, null)
    }
}
