package com.example.selfeducate.ui.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selfeducate.data.models.CourseEntity

//class CoursesAdapter(private val listener: Listener) : RecyclerView.Adapter<CoursesViewHolder>() {
//
//    private val items = arrayListOf<CourseEntity>()
//
//    fun setData(list: List<CourseEntity>) {
//        this.items.clear()
//        this.items.addAll(list)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
//        return CoursesViewHolder.create(parent, listener)
//    }
//
//    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
//        holder.bind(items[position])
//    }
//
//    override fun getItemCount(): Int {
//        return items.count()
//    }
//
//    interface Listener {
//        fun onClick(index: Int)
//    }
//}