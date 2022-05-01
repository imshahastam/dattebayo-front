package com.kay.progayim.ui.details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kay.progayim.Injector
import com.kay.progayim.R
import com.kay.progayim.databinding.FragmInfoBinding
import com.kay.progayim.ui.OnClick

class DetailsFragmentt : Fragment(R.layout.fragm_info) {
    private var binding1 : FragmInfoBinding? = null
    private val binding get() = binding1!!
    private lateinit var listener : OnClick
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        binding1 = FragmInfoBinding.bind(view)

        binding.apply {
            val id = arguments?.getLong("id")!!
            val e = dbInstance.userDao().getById(id)
            courseName.text = e.login

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding1 = null
    }
}