package com.example.calculator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OperationButtonManager(private val activity: AppCompatActivity,private var tvOperation: TextView) {
    val btnAdd = activity.findViewById<Button>(R.id.btnAdd)
    val btnSub = activity.findViewById<Button>(R.id.btnSub)
    val btnMult = activity.findViewById<Button>(R.id.btnMult)
    val btnDiv = activity.findViewById<Button>(R.id.btnDiv)
    fun initializeButtons(){
        addEvents()
    }
    fun addEvents(){
        btnAdd.setOnClickListener { tvOperation.text = "${tvOperation.text}${btnAdd.text}" }
        btnSub.setOnClickListener { tvOperation.text = "${tvOperation.text}${btnSub.text}" }
        btnMult.setOnClickListener { tvOperation.text = "${tvOperation.text}${btnMult.text}" }
        btnDiv.setOnClickListener { tvOperation.text = "${tvOperation.text}${btnDiv.text}" }
    }
}