package com.example.mvvmroomretro.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmroomretro.R
import com.example.mvvmroomretro.model.Datum
import com.example.mvvmroomretro.model.photos

class ZigAdapter(var context: Context, list: ArrayList<photos>): RecyclerView.Adapter<ZigAdapter.ViewHolder>() {
 val list =list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.zig_adpter_activity, parent, false)
        return ViewHolder(context ,view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Article= list.get(position)
        //   holder.textView.text = Article.title
        holder.bindItems(Article)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(var context: Context, view: View):RecyclerView.ViewHolder(view){
        fun bindItems(Article:photos){
            val iv_avatar = itemView.findViewById<ImageView>(R.id.image_zig)
            try {

                Glide.with(itemView).load(Article.img)
                    .apply(RequestOptions().centerCrop())
                    .into(iv_avatar)
                itemView.setOnClickListener({
                    Toast.makeText(itemView.context, "Clicked Position $position", Toast.LENGTH_SHORT).show()
                })
            }catch (e:Exception){
                println(e.message)
            }
        }
    }
}