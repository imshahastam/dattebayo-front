package com.example.selfeducate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.selfeducate.ui.AuthorizationFragment
import com.example.selfeducate.ui.RegisterFragment

class MainActivity : AppCompatActivity(), OnButtonsClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, RegisterFragment())
            .commit()
    }

    override fun openFragment() {
        val frg = BlankFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, frg)
            .commit()
    }
}