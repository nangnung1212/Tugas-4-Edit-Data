package com.example.proteintracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

var items = arrayOf(
            "lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"
        )
        lateinit var LvSample : ListView
        lateinit var spSampleList : Spinner
        lateinit var editText: EditText



class SampleListView : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_sample_list_view)
                LvSample = findViewById(R.id.LvSample)
                LvSample.adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,items
                )

                LvSample.setOnItemClickListener { parent, view, i, l ->
                    Snackbar.make(
                        view, "Anda memilih: ${items[i]}",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                spSampleList = findViewById(R.id.spSampleListView)
                spSampleList.adapter = ArrayAdapter (this,
                    android.R.layout.simple_spinner_item, items
                )
                spSampleList.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view:
                    View, position: Int, id: Long) {
                        Snackbar.make(LvSample, "Anda memilih${items[position]}", Snackbar.LENGTH_LONG).show()
                    }
                    override fun onNothingSelected(parent: AdapterView<*>) {
                    }
                }
                registerForContextMenu(LvSample)
            }

            override fun onCreateContextMenu(
                menu: ContextMenu?, v: View?,
                menuInfo: ContextMenu.ContextMenuInfo?
            ) {
                super.onCreateContextMenu(menu, v, menuInfo)
                val inflater = menuInflater
                inflater.inflate(R.menu.menu_sample_list_view, menu)
            }
                override fun onContextItemSelected(item: MenuItem): Boolean {
                    var info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                    when (item.itemId) {
                        R.id.menu_add -> {
                            Snackbar.make(
                                LvSample,
                                "Anda memilih: Add Item ke-${info.id}",
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
                        R.id.menu_edit -> {
                            Snackbar.make(
                                LvSample,
                                "Anda memilih: Edit Item ke-${info.id}",
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
                        R.id.menu_delete -> {
                            Snackbar.make(
                                LvSample,
                                "Anda memilih: Delete Item ke-${info.id}",
                                Snackbar.LENGTH_LONG
                            ).show()
                        }

                        }

                        return super.onContextItemSelected(item)
                    }


}
