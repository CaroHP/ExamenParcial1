package com.example.examenparcial

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val TEXT = "TEXT_CONTENT"
    private val TEXT2 = "TEXT_CONTENT"
    private val TEXT3 = "TEXT_CONTENT"
    private val TEXT4 = "TEXT_CONTENT"


    private var textView: TextView? = null
    private lateinit var userInput1: EditText
    private lateinit var userInput2: EditText
    private lateinit var userInput3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput1: EditText = findViewById<EditText>(R.id.input1)
        val userInput2: EditText = findViewById<EditText>(R.id.input2)
        val userInput3: EditText = findViewById<EditText>(R.id.input3)

        val buttonagregar: Button = findViewById<Button>(R.id.botonagregar)
        val buttonborrar: Button = findViewById<Button>(R.id.botonborrar)

        textView = findViewById<TextView>(R.id.textView)



        buttonagregar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val prueba1: String = userInput1.text.toString().trim()
                val prueba2: String = userInput2.text.toString().trim()
                val prueba3: String = userInput3.text.toString().trim()

                if (prueba1 != "" && prueba2 != "" && prueba3 != "" ){
                    textView?.append(userInput1.text)
                    textView?.append("+")
                    textView?.append(userInput2.text)
                    textView?.append("=")
                    textView?.append(userInput3.text)
                    userInput1.setText("")
                    userInput2.setText("")
                    userInput3.setText("")
                } else{
                    textView?.setText("Intente de nuevo")
                }
            }
        })

        buttonborrar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                textView?.text = ""
                userInput1.setText("")
                userInput2.setText("")
                userInput3.setText("")
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(TEXT, "")

    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onPause")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT, textView?.text.toString())

    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

}