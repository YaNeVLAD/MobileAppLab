package com.example.mobileprojectlab.UI.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mobileprojectlab.databinding.FragmentLoginBinding
import com.example.mobileprojectlab.presentation.login.LoginState
import com.example.mobileprojectlab.presentation.login.LoginViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LoginFragment : Fragment() {
    private var _mBinding: FragmentLoginBinding? = null
    private val mBinding get() = _mBinding!!

    private val mViewModel by lazy {
        ViewModelProvider(owner = this)[LoginViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _mBinding = FragmentLoginBinding.inflate(inflater, container, false)

        mViewModel.state
            .onEach { render(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        return mBinding.root
    }

    private fun render(state: LoginState) {
        mBinding.loginButton.isEnabled = !state.isInProgress
        mBinding.loginError.text =
            if (state.error != null) {
                mBinding.loginError.isInvisible = false
                state.error
            } else {
                mBinding.loginError.isInvisible = true
                ""
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.loginButton.setOnClickListener {
            mViewModel.onLoginButtonPressed(
                mBinding.loginInputText.text.toString(),
                mBinding.passwordInputText.text.toString()
            )
        }

    }
}