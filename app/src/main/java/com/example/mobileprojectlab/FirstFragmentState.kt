package com.example.mobileprojectlab

data class FirstFragmentState(
    val isLoading: Boolean,
    val text: String
) {
    companion object {
        fun init() = FirstFragmentState(true, "Hello World!")
    }
}
