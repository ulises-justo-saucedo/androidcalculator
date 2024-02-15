package com.example.calculator

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SpecialButtonsManager(private val activity: AppCompatActivity,private var tvOperation: TextView,private var tvMessage: TextView) {
    val btnResult = activity.findViewById<Button>(R.id.btnResult)
    val btnCleanOperation = activity.findViewById<Button>(R.id.btnCleanOperation)
    fun initializeButtons(){
        addEvent()
    }
    fun addEvent(){
        btnResult.setOnClickListener {
            validateMathExpression(tvOperation.text.toString())
        }
        btnCleanOperation.setOnClickListener { tvOperation.setText("") }
    }
    fun validateMathExpression(mathOperation: String){
        var validOperationPattern = Regex("^\\d+([-+*/]\\d+)*\$")
        if(validOperationPattern.matches(mathOperation)){
            val operation = mutableListOf<String>()
            mathOperationToList(operation,mathOperation)
            val result = performOperations(operation)
            tvMessage.setText("The result is: $result")
        }else{
            tvMessage.setText("Invalid arithmetic operation! >:I")
        }
    }
    fun mathOperationToList(operation: MutableList<String>,mathOperation: String){
        var number: String = ""
        for(char in mathOperation){
            if(char.isDigit()){
                number += char
            }else{
                operation.add(number)
                operation.add(char.toString())
                number = ""
            }
        }
        operation.add(number)
    }
    fun performOperations(operation: MutableList<String>): String {
        var result = ""
        var hasMoreTerms = true
        var mathOperator = "_"
        var firstTerm = 0f
        var secondTerm = 0f
        var mathOperatorIndex = 0
        while(hasMoreTerms){
            if(operation.size >= 3){
                if(operation.contains("/") || operation.contains("*")){
                    when(operation.indexOf("/")){
                        -1 -> mathOperatorIndex = operation.indexOf("*")
                        else -> mathOperatorIndex = operation.indexOf("/")
                    }
                    firstTerm = operation.get(mathOperatorIndex - 1).toFloat()
                    secondTerm = operation.get(mathOperatorIndex + 1).toFloat()
                    when(operation.get(mathOperatorIndex)){
                        "/" -> result = (firstTerm / secondTerm).toString()
                        "*" -> result = (firstTerm * secondTerm).toString()
                    }
                    for(i in 0..2){
                        operation.removeAt(mathOperatorIndex - 1)
                    }
                    operation.add(mathOperatorIndex - 1,result)
                }else{
                    mathOperator = operation.get(1)
                    firstTerm = operation.get(0).toFloat()
                    secondTerm = operation.get(2).toFloat()
                    when(mathOperator){
                        "+" -> result = (firstTerm + secondTerm).toString()
                        "-" -> result = (firstTerm - secondTerm).toString()
                    }
                    for(i in 0..2){
                        operation.removeAt(0)
                    }
                    operation.add(0,result)
                }
            }else{
                hasMoreTerms = false
            }
        }
        return operation.get(0)
    }
}