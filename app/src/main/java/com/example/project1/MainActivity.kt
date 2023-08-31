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
            _currenttext.text = currentNumber.toString();
        } else {
            _currenttext.text = "0.0"
        }
    }

    fun getButtons(){
        findViewById<Button>(R.id.button0)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                
                if (currentString.isNotEmpty()) {
                    currentString = currentString.plus("0");
                    currentNumber = currentString.toDouble()

                }
                updateText()
            }
        findViewById<Button>(R.id.button1)
            .setOnClickListener {
                Log.d("clicked", "button 1")
                
                currentString = currentString.plus("1");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button2)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                
                currentString = currentString.plus("2");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button3)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                
                currentString = currentString.plus("3");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button4)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                
                currentString = currentString.plus("4");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button5)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                
                currentString = currentString.plus("5");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button6)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                
                currentString = currentString.plus("6");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button7)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                
                currentString = currentString.plus("7");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button8)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                currentString = currentString.plus("8");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button9)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                
                currentString = currentString.plus("9");
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.buttondivide)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                doingOp = true
                divisionWait = true
                storedNumber = currentNumber
                currentString = ""

            }
        findViewById<Button>(R.id.buttonplus)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                doingOp = true
                additionWait = true
                storedNumber = currentNumber
                currentString = ""

            }
        findViewById<Button>(R.id.buttonminus)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                doingOp = true
                subtractionWait = true
                storedNumber = currentNumber
                currentString = ""

            }
        findViewById<Button>(R.id.buttonmultiply)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                doingOp = true
                multiplicationWait = true
                storedNumber = currentNumber
                currentString = ""

            }
        findViewById<Button>(R.id.buttonclear)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                clearNumbers()
                updateText()

            }
        findViewById<Button>(R.id.buttonnegative)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                currentString = "-".plus(currentString)
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.buttonpercent)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                currentNumber /= 100
                updateText()

            }
        findViewById<Button>(R.id.buttonperiod)
            .setOnClickListener {
                Log.d("clicked", "button 0")


            }
        findViewById<Button>(R.id.buttonequals)
            .setOnClickListener {
                Log.d("clicked", "button 0")
                if (additionWait) {
                    currentNumber += storedNumber
                    additionWait = false
                }
                if (subtractionWait) {
                    currentNumber -= storedNumber
                    subtractionWait = false
                }
                if (multiplicationWait) {
                    currentNumber *= storedNumber
                    multiplicationWait = false
                }
                if (divisionWait) {
                    currentNumber = storedNumber / currentNumber
                    divisionWait = false
                }
                updateText()

            }

    }
}