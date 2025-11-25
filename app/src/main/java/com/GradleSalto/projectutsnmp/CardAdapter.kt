package com.GradleSalto.projectutsnmp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.GradleSalto.projectutsnmp.databinding.BiodataCardBinding

class CardAdapter(): RecyclerView.Adapter<CardAdapter.BiodataViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BiodataViewHolder {
        var binding = BiodataCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
            return BiodataViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: BiodataViewHolder,
        position: Int
    ) {
        val item = BiodataData.biodata[position]

        holder.binding.txtNama.text = BiodataData.biodata[position].nama
        holder.binding.txtNRP.text = BiodataData.biodata[position].nrp
        holder.binding.txtPeminatan.text = BiodataData.biodata[position].peminatan
        holder.binding.imgMahasiswa.setImageResource(BiodataData.biodata[position].imageID)

        holder.binding.root.setOnClickListener {
            val context = holder.binding.root.context
            val intent = Intent(context, ActivityDetailMahasiswa::class.java)

            intent.putExtra("nama", item.nama)
            intent.putExtra("nrp", item.nrp)
            intent.putExtra("peminatan", item.peminatan)
            intent.putExtra("imageID", item.imageID)
            intent.putExtra("aboutMe", item.aboutMe)
            intent.putExtra("quotes", item.quotes)
            intent.putExtra("myCourses", item.myCourses)

            context.startActivity(intent)
        }
    }

    override fun getItemCount() = BiodataData.biodata.size


    class BiodataViewHolder( var binding: BiodataCardBinding): RecyclerView.ViewHolder(binding.root)
}