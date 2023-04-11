package com.example.jobshet26intan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var siswaView: RecyclerView
    lateinit var siswaAdapter: siswa_adapter
    var db = DBHelper(this, null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnRefresh = findViewById<Button>(R.id.btnRefresh)

        siswaView = findViewById(R.id.rvsiswa)
        siswaView.layoutManager = LinearLayoutManager(this)

        siswaAdapter = siswa_adapter(db.getSiswa())
        siswaView.adapter = siswaAdapter

        btnTambah.setOnClickListener() {
            val intent= Intent(this, editactivity::class.java)
            startActivity(intent)
        }

        btnRefresh.setOnClickListener() {
            siswaAdapter = siswa_adapter(db.getSiswa())
            siswaView.adapter = siswaAdapter
        }
    }
}