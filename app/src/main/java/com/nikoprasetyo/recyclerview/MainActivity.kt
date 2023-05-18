package com.nikoprasetyo.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.nikoprasetyo.recyclerview.adapter.AdapterTeamBola
import com.nikoprasetyo.recyclerview.databinding.ActivityMainBinding
import com.nikoprasetyo.recyclerview.model.pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listpemain = ArrayList<pemain>()
        listpemain.add(pemain("Thibaut Courtois", R.drawable.courtois,"Penjaga Gawang","2.00 m","Bree (Belgia)","11 Mei 1992"))
        listpemain.add(pemain("Karim Benzema", R.drawable.courtois,"Penyerang","1,85 m","Lyon (Perancis)","19 Desember 1987"))
        listpemain.add(pemain("Marcelo Vieira da Silva", R.drawable.courtois,"Belakang","1,74 m","Rio de Janeiro (Brasil)","12 Mei 1988"))
        listpemain.add(pemain("Sergio Ramos García", R.drawable.courtois,"Belakang","1,84 m","Camas (Sevilla)","30 Maret 1986"))
        listpemain.add(pemain("Zinedine Yazid Zidane", R.drawable.courtois,"Pelatih","1,85 m","Marseille (Prancis)","23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola(this,listpemain,object : AdapterTeamBola.OnClickListener{
            override fun detailData(item: pemain?) {
                Dialog(this@MainActivity,).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                   btn.setOnClickListener {
                       this.dismiss()
                   }


                }.show()
            }

        })
    }

}