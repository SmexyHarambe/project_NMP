package com.GradleSalto.projectutsnmp

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
            LayoutInflater.from(parent.context), parent, false)
            return BiodataViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: BiodataViewHolder,
        position: Int
    ) {
        holder.binding.txtNama.text = BiodataData.biodata[position].nama
        holder.binding.txtNRP.text = BiodataData.biodata[position].nrp
        holder.binding.txtPeminatan.text = BiodataData.biodata[position].peminatan
        holder.binding.imgMahasiswa.setImageResource(BiodataData.biodata[position].imageID)
    }

    override fun getItemCount() = BiodataData.biodata.size


    class BiodataViewHolder( var binding: BiodataCardBinding): RecyclerView.ViewHolder(binding.root)
}