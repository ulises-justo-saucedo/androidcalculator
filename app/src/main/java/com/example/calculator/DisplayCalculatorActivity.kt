package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DisplayCalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_calculator)
        initializeButtons()
    }

    fun initializeButtons(){
        val tvOperation = findViewById<TextView>(R.id.tvOperation)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        tvOperation.setText("")
        val numberButtonManager = NumberButtonManager(this,tvOperation)
        val operationButtonManager = OperationButtonManager(this,tvOperation)
        val specialButtonsManager = SpecialButtonsManager(this,tvOperation,tvMessage)
        numberButtonManager.initializeButtons()
        operationButtonManager.initializeButtons()
        specialButtonsManager.initializeButtons()
    }
}