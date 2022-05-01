package com.kay.progayim.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kay.progayim.R
import com.kay.progayim.databinding.ActivityMainBinding
import com.kay.progayim.ui.OnClick
import com.kay.progayim.ui.autor.AutorFragment
import com.kay.progayim.ui.details.DetailsFragment
import com.kay.progayim.ui.edit.EditFragment
import com.kay.progayim.ui.registration.RegistrationFragment
import com.kay.progayim.ui.search.SearchCoursesFragment

class MainActivity : AppCompatActivity(), OnClick {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        if(savedInstanceState == null){
//            openFragm(RegistrationFragment,false)
//        }

        supportFragmentManager.beginTransaction()
            .add(R.id.container, AutorFragment())
            .commit()
    }

    override fun openFragm(fragment: Fragment, addToBackStack: Boolean?) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment).apply {
                if (addToBackStack == true) {
                    addToBackStack(null)
                }
            }
            .commit()
    }

    override fun goToAdd() {
        val fragment = RegistrationFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun goMain(id: Long) {
        val fragment = MainFragment()
        val bundle = Bundle()
        bundle.putLong("id", id)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .commit()
    }

    override fun goTOEdit(id: Long) {
        val fragment = EditFragment()
        val bundle = Bundle()
        bundle.putLong("id", id)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null).commit()
    }

    override fun sortByName(id: Long) {
        val fragment = SearchCoursesFragment()
        val bundle = Bundle()
        bundle.putLong("id", id)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null).commit()
    }
}