package com.example.workercontroller.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.workercontroller.ViewModl.WorkerViewModel
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.workercontroller.R
import com.example.workercontroller.ViewModl.HealpData


class RecyclerAdapter(
    private val navController: NavController,
    private val data: List<HealpData>,
    private val viewModel: WorkerViewModel
) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val myText: TextView = itemView.findViewById(R.id.itemDate)
        val image: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.myText.text = data[position].text
        holder.image.setOnClickListener {
            viewModel.updatePdf(data[position].pdf)
            navController.navigate(R.id.action_mainMenu_to_pdfReader)
        }
    }

    override fun getItemCount(): Int = data.size


}