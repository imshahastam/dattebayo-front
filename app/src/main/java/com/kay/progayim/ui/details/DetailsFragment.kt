package com.kay.progayim.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kay.progayim.databinding.FragmInfoBinding
import com.kay.progayim.ui.Event
import com.kay.progayim.ui.main.MainViewModel
import com.kay.progayim.ui.main.rv.CoursesAdapter

class DetailsFragment: Fragment() {

    private var _binding: FragmInfoBinding? = null
    private val binding: FragmInfoBinding
    get() = _binding!!
    private lateinit var detailVM: DetailsViewModel
    private lateinit var mainVM : MainViewModel
    //private val chAdapter: CoursesAdapter = CoursesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainVM = ViewModelProvider(this)[MainViewModel::class.java]
        detailVM = ViewModelProvider(this)[DetailsViewModel::class.java]
        detailVM.setId(arguments?.getLong(Long::class.java.canonicalName))
        detailVM.fetchCh()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmInfoBinding.inflate(inflater)
        return _binding?.root

        Log.e("id","kkk")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
//        subscribeToLD()
//        setupViews()
        Log.e("id","lll")
    }

//    private fun setupViews() {
//        with(binding){
//            recycler.adapter = chAdapter
//            val layoutManager = LinearLayoutManager(activity)
//            recycler.layoutManager = layoutManager
//            recycler.adapter = chAdapter
//            recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))
//        }
//    }
//
//    private fun subscribeToLD(){
//        mainVM.coursesLiveData.observe(viewLifecycleOwner, {
//            chAdapter.setData(it)
//            Log.e("id","llgggl")
//        })
//
////        mainVM.event.observe(viewLifecycleOwner, {
////            when(it){
////                is Event.ShowToast -> showToast(getString(it.resId))
////                is Event.ShowLoading -> binding.swipeRefreshLayout.isRefreshing = true
////                is Event.StopLoading -> binding.swipeRefreshLayout.isRefreshing = false
////                else -> {}
////            }
////        })
//    }

    private fun subscribeToLiveData() {
        detailVM.event.observe(viewLifecycleOwner,{
            when(it){
                is Event.FetchedCh -> {
                    setInfoCh(it)
                }
                else -> {}
            }
        })
    }

    private fun setInfoCh(it: Event.FetchedCh) {
        binding.courseName.text = it.character.name
    }


    companion object{
        fun newInstance(id: Long): DetailsFragment {
            val argum = Bundle().apply { putLong(Long::class.java.canonicalName, id) }
            return DetailsFragment().apply { arguments = argum }
        }
    }

}