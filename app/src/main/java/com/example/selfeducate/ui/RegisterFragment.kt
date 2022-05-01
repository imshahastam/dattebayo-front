package com.example.selfeducate.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.selfeducate.Injector
import com.example.selfeducate.OnButtonsClick
import com.example.selfeducate.R
import com.example.selfeducate.data.models.UserDto
import com.example.selfeducate.data.models.UserEntity
import com.example.selfeducate.databinding.FragmentRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private var binding1 : FragmentRegisterBinding? = null
    private val binding get() = binding1!!
    private lateinit var listener : OnButtonsClick
    private val api get() = Injector.api

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonsClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        binding1 = FragmentRegisterBinding.bind(view)

        binding.apply {
            btn.setOnClickListener {

                if (regLogin.text.toString().isNotEmpty() && regEmail.text.toString().isNotEmpty() &&  regPasswd.text.toString().isNotEmpty()) {
                    requireActivity().onBackPressed()

                    api.createUser(UserDto(
                        login = regLogin.text.toString(),
                        email = regEmail.text.toString(),
                        password = regPasswd.text.toString()
                    )).enqueue(object : Callback<UserDto> {
                        override fun onResponse(call: Call<UserDto>, response: Response<UserDto>) {
                            println("OK")
                        }

                        override fun onFailure(call: Call<UserDto>, t: Throwable) {
                            println("Failure")
                            Log.e(RegisterFragment::class.simpleName, t.message ?: "unkown error")
                        }

                    })
                }
                else{
                    Toast.makeText(context, "Заполните все поля!", Toast.LENGTH_SHORT).show()
                }
                listener.openFragment()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}
