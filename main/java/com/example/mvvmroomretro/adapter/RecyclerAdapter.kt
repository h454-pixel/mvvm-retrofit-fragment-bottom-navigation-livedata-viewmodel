package com.example.mvvmroomretro.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmroomretro.R
import com.example.mvvmroomretro.fragment.home
import com.example.mvvmroomretro.model.Datum


class RecyclerAdapter(var context: home) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var mList =ArrayList<Datum>()
    fun setupdate(mList: ArrayList<Datum>){
        this.mList =mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_ap_iscreen, parent, false)
        return ViewHolder(context ,view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Article=mList.get(position)

        holder.bindItems(Article)
    }

    override fun getItemCount(): Int {
     return mList.size
    }

    class ViewHolder(var context: home, view: View):RecyclerView.ViewHolder(view){
        fun bindItems(Article: Datum){
            val iv_avatar = itemView.findViewById<ImageView>(R.id.image_1)
            val txt_name = itemView.findViewById<TextView>(R.id.txt_name)
            val txt_job = itemView.findViewById<TextView>(R.id.txt_job)
            val txt_emid = itemView.findViewById<TextView>(R.id.txt_emid)
            val txt_phone = itemView.findViewById<TextView>(R.id.txt_ph)
            val txt_addres = itemView.findViewById<TextView>(R.id.txt_address)
            val checkBox =itemView.findViewById<CheckBox>(R.id.checkbox)
            try {
                txt_name.text =Article.name
                txt_job.text =Article.technology
                txt_phone.text=Article.mobile_no
                txt_addres.text=Article.address

                Glide.with(itemView).load(Article.image)
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