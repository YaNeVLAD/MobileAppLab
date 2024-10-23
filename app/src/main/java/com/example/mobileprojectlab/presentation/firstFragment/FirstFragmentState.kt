package com.example.mobileprojectlab.presentation.firstFragment

data class FirstFragmentState(
    val isLoading: Boolean,
    val text: String
) {
    companion object {
        fun init() = FirstFragmentState(true, "Hello World!")
    }
}
