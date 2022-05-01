package com.kay.progayim.ui

import androidx.fragment.app.Fragment

interface OnClick {
    fun openFragm(fragment: Fragment,addToBackStack: Boolean? = true)
    fun goMain(id: Long)
    fun goToAdd()
    //fun goToInfo(id : Long)
    fun sortByName(id: Long)
    fun goTOEdit(id: Long)
}