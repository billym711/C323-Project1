package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This program implements an Android application for a basic calculator.
 *
 * @author Billy Moore
 * @version 1.0
 * @since 2023-01-09
 */
class MainActivity : AppCompatActivity() {

    // This establishes some basic variables to store numbers and convert them to a printable string
    // We also have booleans to determine whether or not we are currently doing an operation, and which specific operation we're doing.
        private var currentString: String = ""
        private var currentNumber: Double = 0.0
        private var storedNumber: Double = 0.0
        private var doingOp: Boolean = false
        private var additionWait: Boolean = false
        private var subtractionWait: Boolean = false
        private var divisionWait: Boolean = false
        private var multiplicationWait: Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            currentString = savedInstanceState.getString("currentString").toString()
            currentNumber = savedInstanceState.getDouble("currentNumber")
            storedNumber = savedInstanceState.getDouble("storedNumber")
            doingOp = savedInstanceState.getBoolean("doingOp")
            additionWait = savedInstanceState.getBoolean("additionWait")
            subtractionWait = savedInstanceState.getBoolean("subtractionWait")
            divisionWait = savedInstanceState.getBoolean("divisionWait")
            multiplicationWait= savedInstanceState.getBoolean("multiplicationWait")
            }

        setContentView(R.layout.activity_main)

        //As we create the view, we update the text to 0 and initialize the functions of each Button.
        updateText()
        getButtons()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("currentString", currentString)
        outState.putDouble("currentNumber", currentNumber)
        outState.putDouble("storedNumber", storedNumber)
        outState.putBoolean("doingOp", doingOp)
        outState.putBoolean("additionWait", additionWait)
        outState.putBoolean("subtractionWait", subtractionWait)
        outState.putBoolean("divisionWait", divisionWait)
        outState.putBoolean("multiplicationWait", multiplicationWait)


        super.onSaveInstanceState(outState)
    }

    private fun clearNumbers(){
        //The function called by the "Clear" button to set all the numbers back to zero
        currentString = ""
        currentNumber = 0.0
        storedNumber = 0.0
    }

    private fun updateText(){
        //This is called any time the current number changes
        //Connecting to the xml TextView
        val currentText : TextView = findViewById(R.id.textView)

        //If the current number is empty, we just want to display zero
        //If it's not empty, we also don't want to display the .0 at the end for no reason
        //So we check the last 2 chars in the string and remove them if necessary
        //Then we update the TextView text
        if (currentString.isNotEmpty()) {
            if (currentNumber.toString().length >= 2 && currentNumber.toString().reversed().subSequence(0, 2) == "0.") {
                currentText.text = currentNumber.toString().dropLast(2)
            }else{
                currentText.text = currentNumber.toString()

            }
        } else {
            currentText.text = "0"
        }
    }

    private fun getButtons(){
        //This defines the behaviors of each button on click
            // Buttons 0 through 9 just add their corresponding number to the string
            //we also set doingOp to false to indicate that we aren't in between two numbers in an operation

        findViewById<Button>(R.id.button0)
            .setOnClickListener {
                
                //0 specifically checks for if the string is empty (we don't want multiple zeroes)
                if (currentString.isNotEmpty()) {
                    doingOp = false
                    currentString = currentString.plus("0")
                    currentNumber = currentString.toDouble()

                }
                updateText()
            }
        findViewById<Button>(R.id.button1)
            .setOnClickListener {
                doingOp = false
                currentString = currentString.plus("1")
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button2)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("2")
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button3)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("3")
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button4)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("4")
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button5)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("5")
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button6)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("6")
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button7)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("7")
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button8)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("8")
                currentNumber = currentString.toDouble()
                updateText()

            }
        findViewById<Button>(R.id.button9)
            .setOnClickListener {

                doingOp = false
                currentString = currentString.plus("9")
                currentNumber = currentString.toDouble()
                updateText()

            }
        // The operations are also very similar. We check if a division is already active, and update the number if so.
        // Otherwise we start a new operation.
        // This same pattern is used for all 4 operations
        findViewById<Button>(R.id.buttondivide)
            .setOnClickListener {
                if (additionWait) {
                    currentString = (currentNumber + storedNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (subtractionWait) {
                    currentString = (storedNumber - currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (multiplicationWait) {
                    currentString = (currentNumber * storedNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (divisionWait) {
                    currentString = (storedNumber / currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                doingOp = true
                divisionWait = true
                additionWait = false
                subtractionWait = false
                multiplicationWait = false
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
                if (subtractionWait) {
                    currentString = (storedNumber - currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (multiplicationWait) {
                    currentString = (currentNumber * storedNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (divisionWait) {
                    currentString = (storedNumber / currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                doingOp = true
                additionWait = true
                subtractionWait = false
                multiplicationWait = false
                divisionWait = false
                storedNumber = currentNumber
                currentString = ""


            }
        findViewById<Button>(R.id.buttonminus)
            .setOnClickListener {
                if (additionWait) {
                    currentString = (currentNumber + storedNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (subtractionWait) {
                    currentString = (storedNumber - currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (multiplicationWait) {
                    currentString = (currentNumber * storedNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (divisionWait) {
                    currentString = (storedNumber / currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                doingOp = true
                subtractionWait = true
                additionWait = false
                multiplicationWait = false
                divisionWait = false
                storedNumber = currentNumber
                currentString = ""

            }
        findViewById<Button>(R.id.buttonmultiply)
            .setOnClickListener {
                if (additionWait) {
                    currentString = (currentNumber + storedNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (subtractionWait) {
                    currentString = (storedNumber - currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (multiplicationWait) {
                    currentString = (currentNumber * storedNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                if (divisionWait) {
                    currentString = (storedNumber / currentNumber).toString()
                    currentNumber = currentString.toDouble()
                    updateText()
                }
                doingOp = true
                multiplicationWait = true
                additionWait = false
                subtractionWait = false
                divisionWait = false
                storedNumber = currentNumber
                currentString = ""

            }

        //Clear is pretty simple. Sets the numbers to zero and updates the text
        findViewById<Button>(R.id.buttonclear)
            .setOnClickListener {
                
                clearNumbers()
                updateText()

            }
        //Negative does not work if the string is empty or if you just pressed an operation.
        // If the string already has a negative sign, get rid of it.
        // If it doesn't, add one
        findViewById<Button>(R.id.buttonnegative)
            .setOnClickListener {
                if (currentString.isNotEmpty()) {
                    if (!doingOp) {
                        currentString = if (currentString.first() == '-') {
                            currentString.drop(1)
                        } else {
                            "-".plus(currentString)
                        }

                        currentNumber = currentString.toDouble()
                        updateText()
                    }
                }
            }
        // The percent button is just like the other operations. We just divide by 100 and update.
        findViewById<Button>(R.id.buttonpercent)
            .setOnClickListener {
                
                currentString = (currentString.toDouble() / 100).toString()
                currentNumber = currentString.toDouble()
                updateText()

            }
        // The decimal will only work if there's not already a decimal.
        // If there's no decimal, we just add one to the string.
        findViewById<Button>(R.id.buttonperiod)
            .setOnClickListener {
                if (!currentString.contains('.')) {
                    currentString = currentString.plus(".")
                    currentNumber = currentString.toDouble()
                    updateText()
                }

            }
        //Equals will check for whichever operation is active, then finish it and update the display.
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