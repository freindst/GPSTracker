package com.example.gpstracker

import CustomAdapter
import Message
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue


class SecondScreenActivity : AppCompatActivity() {
    private var dataModels: ArrayList<Message>? = null
    var listView: ListView? = null
    private var adapter: CustomAdapter? = null
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        database = Firebase.database.reference
        var listView = findViewById<ListView>(R.id.list_second)

        dataModels = ArrayList()

        adapter = CustomAdapter(dataModels, applicationContext)
        listView.adapter = adapter
        var query = database.child("message").orderByKey()
        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children){
                    val msg = snap.getValue<Message>()
                    if (msg != null){
                        dataModels!!.add(msg)
                    }
                }
                adapter!!.notifyDataSetChanged();
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


    }
}