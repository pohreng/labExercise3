package com.example.labexercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculate()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            reset()
        }
    }
    private fun calculate(){
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
        val radioGroupGender = radioGroup.checkedRadioButtonId
        val genderGroup = findViewById<RadioButton>(radioGroupGender)
        val gender = genderGroup.text
        val checkBoxSmoker = findViewById<CheckBox>(R.id.checkBoxSmoker)
        val checkSmoker = checkBoxSmoker.isChecked
        val sAge = findViewById<Spinner>(R.id.spinnerAge)
        val age = sAge.selectedItemPosition + 1


        var premium = 0

        if(age == 1){
            premium+=60
        }else if (age == 2) {
            premium += 70

            if (gender == "Male") {
                premium += 50
            }

            if (checkSmoker) {
                premium += 100
            }
        } else if (age == 3) {
            premium += 90

            if (gender == "Male")
            {
                premium += 100
            }

            if (checkSmoker) {
                premium += 150
            }
        } else if (age == 4) {
            premium += 120

            if (gender == "Male") {
                premium += 150
            }

            if (checkSmoker) {
                premium += 200
            }
        } else if (age == 5) {
            premium += 150

            if (gender == "Male") {
                premium += 200
            }

            if (checkSmoker) {
                premium += 250
            }
        } else if (age == 6) {
            premium += 150

            if (gender == "Male") {
                premium += 200
            }

            if (checkSmoker) {
                premium += 300
            }
        }

        textViewPremium.text = String.format("%s \n         %s %d",getString(R.string.insurance_premium), "RM", premium)


    }

    fun reset(){
        spinnerAge.setSelection(0)
        checkBoxSmoker.isChecked = false
        radioGroupGender.clearCheck()
        textViewPremium.text = getString(R.string.insurance_premium)
    }
}
