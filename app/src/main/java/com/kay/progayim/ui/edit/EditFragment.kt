package com.kay.progayim.ui.edit

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kay.progayim.Injector
import com.kay.progayim.R
import com.kay.progayim.databinding.FragmEditBinding
import com.kay.progayim.ui.OnClick

class EditFragment : Fragment(R.layout.fragm_edit) {
    private var binding1 : FragmEditBinding? = null
    private val binding get() = binding1!!
    private val dbInstance get() = Injector.database
    private lateinit var listener : OnClick
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        binding1 = FragmEditBinding.bind(view)

        binding.apply {
            btn.setOnClickListener {
                val id = arguments?.getLong("id")!!
                val e = dbInstance.userDao().getById(id)
                if (login.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && passwd.text.toString().isNotEmpty()) {
                    e.login = login.text.toString()
                    e.email = email.text.toString()
                    e.password = passwd.toString()

                    dbInstance.userDao().update(e)
                    requireActivity().onBackPressed()
                }
                else{
                    Toast.makeText(context, "Заполните все поля !", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}