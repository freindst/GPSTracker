package com.example.gpstracker

import CustomAdapter
import Message
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondScreenActivity : AppCompatActivity() {
    var dataModels: ArrayList<Message>? = null
    var listView: ListView? = null
    private var adapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        val extras = intent.extras
        val value: String?
        if (extras != null) {
            value = extras.getString("key")
            var textView: TextView = findViewById(R.id.textView2)
            textView.text = value
        }
        var listView = findViewById<ListView>(R.id.list_second)

        dataModels = ArrayList()

        adapter = CustomAdapter(dataModels, applicationContext)
        listView.adapter = adapter

    }
}