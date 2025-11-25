package com.GradleSalto.projectutsnmp

import android.R
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.GradleSalto.projectutsnmp.databinding.ActivityDetailMahasiswaBinding

class ActivityDetailMahasiswa : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMahasiswaBinding
    private lateinit var mahasiswa: Biodata
    val items = arrayOf("About me", "My Courses", "Quotes")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val nama = intent.getStringExtra("nama")
        val nrp = intent.getStringExtra("nrp")
        val peminatan = intent.getStringExtra("peminatan")
        val aboutMe = intent.getStringExtra("aboutMe")
        val quotes = intent.getStringExtra("quotes")
        val courses = intent.getStringArrayExtra("myCourses")
        val imgRes = intent.getIntExtra("imageID", 0)

        with(binding){
            imgDetail.setImageResource(imgRes)
            txtNamaMhs.text = nama
            txtNrp.text = nrp
            txtDetail.text = aboutMe
        }

        //handle spinner
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerDisplayTextView.adapter = adapter

        binding.spinnerDisplayTextView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (items[position] == "About me") {
                    binding.txtDetail.text = aboutMe
                } else if (items[position] == "My Courses") {
                    binding.txtDetail.text = courses?.joinToString("\n")
                } else if (items[position] == "Quotes") {
                    binding.txtDetail.text = quotes
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        with(binding){
            if(peminatan == "DSAI"){
                radioDSAI.isChecked = true
            } else if(peminatan == "NCS"){
                radioNCS.isChecked = true
            } else if (peminatan == "IMES"){
                radioIMES.isChecked = true
            } else if (peminatan == "DMT"){
                radioDMT.isChecked = true
            } else if (peminatan == "GD"){
                radioGD.isChecked = true
            }
        }

        binding.btnAddFriend.setOnClickListener {
            FriendData.jumlahTeman += 1

            AlertDialog.Builder(this)
                .setTitle("Friend Request")
                .setMessage("Sukses menambah ${nama} sebagai friend.\nFriend anda sekarang adalah ${FriendData.jumlahTeman}.")
                .setPositiveButton("OK", null)
                .show()
        }

    }
}