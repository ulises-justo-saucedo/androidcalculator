package com.example.calculator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NumberButtonManager(private val activity: AppCompatActivity, private var tvOperation: TextView) {
    val buttons = arrayOfNulls<Button>(10)
    fun initializeButtons() {
        loadButtons()
        addEvents()
    }
    private fun loadButtons() {
        for(i in 0..9){
            val buttonId = activity.resources.getIdentifier("btn$i", "id", activity.packageName)
            buttons[i] = activity.findViewById(buttonId)
        }
    }
    private fun addEvents() {
        for(button in buttons){
            button?.setOnClickListener { tvOperation.text = "${tvOperation.text}${button.text}" }
        }
    }
}