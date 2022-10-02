package com.example.proteintracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar

class SampleList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_list)

        val LvBtn = findViewById<Button>(R.id.btnShowList)
        LvBtn.setOnClickListener {
            val Intent = Intent(this,SampleListView::class.java)
            startActivity(Intent)


            }

    }
}