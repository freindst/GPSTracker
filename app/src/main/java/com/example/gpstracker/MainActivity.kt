package com.example.gpstracker

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import Message
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Firebase.database.reference

        var button : Button = findViewById(R.id.gps_button)
        button.setOnClickListener{
            startActivity(Intent(this, SecondScreenActivity::class.java)).apply {

            }
            var textView : TextView = findViewById(R.id.gps_x_textView)
            /*
            val key = database.child("message").push().key
            if (key != null){
                writeNewMessage(key, "new message", Date().toString())

            }
            textView.text = Date().toString()
            var query = database.child("message").orderByKey()
            query.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    //Log.d(TAG, "here")
                    for (snap in snapshot.children){
                        val msg = snap.getValue<Message>()
                        val date = msg?.datetime
                        Log.d(TAG, "Value is: $date")
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
            */

            /*val myRef = database.getReference("message")
            myRef.setValue("Hello")
            myRef.addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val value = snapshot.getValue<String>()
                    Log.d(TAG, "Value is: $value")
                    textView.text = value
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException())
                }
            })*/
        }

    }


    fun writeNewMessage(msgId: String, text: String, timestamp: String){
        val msg = Message(text, timestamp)
        database.child("message").child(msgId).setValue(msg)
    }
}