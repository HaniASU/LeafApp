package com.example.leafapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.example.leafapp.R
import com.example.leafapp.authentication.Resource
import com.example.leafapp.databinding.FragmentSignUpBinding
import com.example.leafapp.showPassword
import com.example.leafapp.signUp
import com.example.leafapp.validatSignUp


class SignUpFragment : Fragment() {
    lateinit var binding :  FragmentSignUpBinding
    private val viewModel by viewModels<AuthViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding =  FragmentSignUpBinding.inflate(layoutInflater)


        // buttons clicks
        //sign in button
        binding.signIntBtnIdInBtnId.setOnClickListener()
        {
           // Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment_to_loginFragment2)
        }
        //sign up button
        binding.signUpBtnId.setOnClickListener()
        {
            if (validatSignUp(binding.nameEditText,binding.emailEditText,binding.passEditText))
            {
                    viewModel.signUp(binding.nameEditText.text.toString(),
                    binding.emailEditText.text.toString(),
                    binding.passEditText.text.toString())
            }

            //signUp(binding.nameEditText,binding.emailEditText,binding.passEditText,binding.root,binding.progressBar)
        }
        //show pass button
        binding.showBtn.setOnClickListener()
        {
            showPassword(binding.passEditText)
        }
        //cancel button
        binding.cancelBtnId.setOnClickListener()
        {
            Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment_to_loginFragment2)
        }


        return binding.root
    }
    override fun onStart() {
        super.onStart()
        viewModel.signUpState!!.observe(viewLifecycleOwner) {
            when(it)
            {
                is Resource.Fail -> {
                    Toast.makeText(requireContext(),"invalid data", Toast.LENGTH_LONG).show()
                    binding.progressBar.setVisibility(View.GONE)}
                is Resource.Load ->{binding.progressBar.setVisibility(View.VISIBLE)}
                is Resource.Success -> {
                    Toast.makeText(requireContext()," data", Toast.LENGTH_LONG).show()
                    Navigation.findNavController(requireView()).navigate(R.id.action_signUpFragment_to_loginFragment2)
                }

            }
        }
    }
}