package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

        var currentString: String = ""
        var currentNumber: Double = 0.0
        var storedNumber: Double = 0.0
        var doingOp: Boolean = false
        var additionWait: Boolean = false
        var subtractionWait: Boolean = false
        var divisionWait: Boolean = false
        var multiplicationWait: Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateText()
        getButtons()

    }


    fun clearNumbers(){
        currentString = ""
        currentNumber = 0.0
        storedNumber = 0.0
    }

    public fun updateText(){
        val _currenttext : TextView = findViewById(R.id.textView) as TextView
        if (currentString.isNotEmpty()) {
            _currenttext.text = currentNumber.toString()
        } else {
            _currenttext.text = "0.0"
        }
    }

    fun getButtons(){
        findViewById<Button>(R.id.button0)
            .setOnClickListener {
                
                
                if (currentString.isNotEmpty()) {
                    doingOp = false
                    currentString = currentString.plus("0");
                    currentNumber = currentString.toDouble()

                }
                updateText()
            }
        findViewById<Button>(R.id.button1)
            .setOnClickListener {
                doingOp = false
                currentString = currentString.plus("1");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button2)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("2");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button3)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("3");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button4)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("4");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button5)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("5");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button6)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("6");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button7)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("7");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button8)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("8");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button9)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("9");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.buttondivide)
            .setOnClickListener {
                if (divisionWait) {
                    currentString = (storedNumber / currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                doingOp = true
                divisionWait = true
                storedNumber = currentNumber
                currentString = ""

            }
        findViewById<Button>(R.id.buttonplus)
            .setOnClickListener {
                if (additionWait) {
                    currentString = (currentNumber + storedNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                doingOp = true
                additionWait = true
                storedNumber = currentNumber
                currentString = ""


            }
        findViewById<Button>(R.id.buttonminus)
            .setOnClickListener {
                if (subtractionWait) {
                    currentString = (storedNumber - currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                doingOp = true
                subtractionWait = true
                storedNumber = currentNumber
                currentString = ""

            }
        findViewById<Button>(R.id.buttonmultiply)
            .setOnClickListener {
                if (multiplicationWait) {
                    currentString = (currentNumber * storedNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                doingOp = true
                multiplicationWait = true
                storedNumber = currentNumber
                currentString = ""

            }
        findViewById<Button>(R.id.buttonclear)
            .setOnClickListener {
                
                clearNumbers()
                updateText()

            }
        findViewById<Button>(R.id.buttonnegative)
            .setOnClickListener {
                if (!doingOp) {
                    if (currentString.first() == '-') {
                        currentString = currentString.drop(1)
                    } else {
                        currentString = "-".plus(currentString)
                    }

                    currentNumber = currentString.toDouble()
                    updateText()
                }
            }
        findViewById<Button>(R.id.buttonpercent)
            .setOnClickListener {
                
                currentNumber /= 100
                updateText()

            }
        findViewById<Button>(R.id.buttonperiod)
            .setOnClickListener {
                if (!currentString.contains('.')) {
                    currentString = currentString.plus(".");
                    currentNumber = currentString.toDouble()
                    updateText()
                }

            }
        findViewById<Button>(R.id.buttonequals)
            .setOnClickListener {
                
                if (additionWait) {
                    currentString = (currentNumber + storedNumber).toString()
                    additionWait = false
                }
                if (subtractionWait) {
                    currentString = (storedNumber - currentNumber).toString()
                    subtractionWait = false
                }
                if (multiplicationWait) {
                    currentString = (currentNumber * storedNumber).toString()
                    multiplicationWait = false
                }
                if (divisionWait) {
                    currentString = (storedNumber / currentNumber).toString()
                    divisionWait = false
                }
                currentNumber = currentString.toDouble()
                doingOp = false
                additionWait = false
                subtractionWait = false
                multiplicationWait = false
                divisionWait = false
                updateText()

            }

    }
}