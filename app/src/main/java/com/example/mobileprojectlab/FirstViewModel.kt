package com.example.mobileprojectlab

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class FirstViewModel : ViewModel() {
    val state = MutableStateFlow(FirstFragmentState.init())

}