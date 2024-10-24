package com.example.mobileprojectlab.domain.login

data class ErrorEvent(
    val isToast: Boolean,
    val text: String?
): Event