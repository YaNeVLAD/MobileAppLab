package com.example.mobileprojectlab.UI.firstFragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import com.example.mobileprojectlab.databinding.FragmentFirstBinding
import com.example.mobileprojectlab.presentation.firstFragment.FirstFragmentState
import com.example.mobileprojectlab.presentation.firstFragment.FirstViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FirstFragment : Fragment() {
    private val mViewModel: FirstViewModel by viewModels()

    private var _mBinding: FragmentFirstBinding? = null
    private val mBinding get() = _mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentFirstBinding.inflate(inflater, container, false)

        mViewModel.state
            .onEach { render(it) }
            .launchIn(mViewModel.viewModelScope)

        return mBinding.root
    }

    private fun render(state: FirstFragmentState) {
        mBinding.textView.text = state.text
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}