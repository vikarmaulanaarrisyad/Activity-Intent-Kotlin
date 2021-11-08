package com.nim19041081.intentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STUDENT = "extra_person"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_object)

        val tvObject: TextView = findViewById(R.id.tv_move_object)
        val student = intent.getParcelableExtra<Student>(EXTRA_STUDENT) as Student
        val text = "Name : ${student.name.toString()},\nEmail : ${student.email},\nAge : ${student.age},\nLocation : ${student.city}"
        tvObject.text = text
        
    }
}