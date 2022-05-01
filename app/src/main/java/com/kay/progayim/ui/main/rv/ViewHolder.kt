package com.kay.progayim.ui.main.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kay.progayim.R
import com.kay.progayim.data.models.Courses
import com.kay.progayim.databinding.RecycleBinding

class ViewHolder(private val binding: RecycleBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(courses : Courses) {
        with(binding){

            Glide.with(itemView.context).load(R.drawable.heart).into(img)
            courseName.text = courses.name
            description.text = courses.status
            teacher.text = courses.species

        }
    }

    companion object {
        fun create(parent: ViewGroup, listener: CoursesAdapter.Listener):ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle,parent,false)

            val binding = RecycleBinding.bind(view)

            return ViewHolder(binding).apply {
                itemView.setOnClickListener {
                    listener.click(adapterPosition)
                }
            }
        }
    }

}