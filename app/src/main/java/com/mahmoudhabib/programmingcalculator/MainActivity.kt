package com.mahmoudhabib.programmingcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private lateinit var num0: Button
    private lateinit var num1: Button
    private lateinit var num2: Button
    private lateinit var num3: Button
    private lateinit var num4: Button
    private lateinit var num5: Button
    private lateinit var num6: Button
    private lateinit var num7: Button
    private lateinit var num8: Button
    private lateinit var num9: Button

    private lateinit var numA: Button
    private lateinit var numB: Button
    private lateinit var numC: Button
    private lateinit var numD: Button
    private lateinit var numE: Button
    private lateinit var numF: Button

    private lateinit var hexadecimalTextView: TextView
    private lateinit var decimalTextView: TextView
    private lateinit var octalTextView: TextView
    private lateinit var binaryTextView: TextView

    private lateinit var inputTextView: TextView
    private lateinit var equalButton: Button
    private lateinit var clearAllButton: Button

    private lateinit var numeralSystem: NumeralSystem
    private lateinit var allNumbersButtonsList: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindUIElements()

        allNumbersButtonsList = listOf(
            num0, num1, num2, num3, num4,
            num5, num6, num7, num8, num9,
            numA, numB, numC, numD, numE, numF
        )
        //initialize numeralSystem as Hex
        numeralSystem = NumeralSystem.HexadecimalSystem
        setupTextViewsListeners()
        setupNumbersListeners()

        equalButton.setOnClickListener {
            val input = inputTextView.text.toString()
            val value = when (numeralSystem) {
                NumeralSystem.HexadecimalSystem -> input.toInt(16)
                NumeralSystem.DecimalSystem -> input.toInt()
                NumeralSystem.OctalSystem -> input.toInt(8)
                NumeralSystem.BinarySystem -> input.toInt(2)
            }
            hexadecimalTextView.text = buildString {
                append("HEX \t")
                append(numeralSystem.toHex(value))
            }
            decimalTextView.text = buildString {
                append("DEC \t")
                append(numeralSystem.toDec(value))
            }
            octalTextView.text = buildString {
                append("OCT \t")
                append(numeralSystem.toOct(value))
            }
            binaryTextView.text = buildString {
                append("BIN \t")
                append(numeralSystem.toBin(value))
            }
        }


        clearAllButton.setOnClickListener {
            resetAll()
        }


    }

    private fun resetAll() {
        inputTextView.text = ""
        hexadecimalTextView.text = "HEX\t\t0"
        decimalTextView.text = "DEC\t\t0"
        octalTextView.text = "OCT\t\t0"
        binaryTextView.text = "BIN \t\t0"
    }

    private fun setupTextViewsListeners() {
        hexadecimalTextView.setOnClickListener {
            numeralSystem = NumeralSystem.HexadecimalSystem
            updateNumeralSystemTextViewColors(hexadecimalTextView)
            setupHexadecimalNumbers()
            resetAll()
        }
        decimalTextView.setOnClickListener {
            numeralSystem = NumeralSystem.DecimalSystem
            updateNumeralSystemTextViewColors(decimalTextView)
            setupDecimalNumbers()
            resetAll()
        }
        octalTextView.setOnClickListener {
            numeralSystem = NumeralSystem.OctalSystem
            updateNumeralSystemTextViewColors(octalTextView)
            setupOctalNumbers()
            resetAll()
        }
        binaryTextView.setOnClickListener {
            numeralSystem = NumeralSystem.BinarySystem
            updateNumeralSystemTextViewColors(binaryTextView)
            setupBinaryNumbers()
            resetAll()
        }
    }

    private fun updateNumeralSystemTextViewColors(selectedTextView: TextView) {
        val selectedColor = ContextCompat.getColor(this, R.color.brand)
        val unselectedColor = ContextCompat.getColor(this, R.color.white)
        hexadecimalTextView.setTextColor(if (hexadecimalTextView == selectedTextView) selectedColor else unselectedColor)
        decimalTextView.setTextColor(if (decimalTextView == selectedTextView) selectedColor else unselectedColor)
        octalTextView.setTextColor(if (octalTextView == selectedTextView) selectedColor else unselectedColor)
        binaryTextView.setTextColor(if (binaryTextView == selectedTextView) selectedColor else unselectedColor)
    }

    private fun setupNumbersListeners() {
        val hexNumbersList = listOf("A", "B", "C", "D", "E", "F")
        allNumbersButtonsList.forEachIndexed { index, button ->
            button.setOnClickListener {
                inputTextView.let {
                    it.text = buildString {
                        append(it.text)
                        append(if (index <= 9) index else hexNumbersList[index % 10])
                    }
                }
            }
        }
    }

    private fun bindUIElements() {
        bindUIButtons()
        bindUITextViews()
    }

    private fun bindUIButtons() {
        num0 = findViewById(R.id.num0_btn)
        num1 = findViewById(R.id.num1_btn)
        num2 = findViewById(R.id.num2_btn)
        num3 = findViewById(R.id.num3_btn)
        num4 = findViewById(R.id.num4_btn)
        num5 = findViewById(R.id.num5_btn)
        num6 = findViewById(R.id.num6_btn)
        num7 = findViewById(R.id.num7_btn)
        num8 = findViewById(R.id.num8_btn)
        num9 = findViewById(R.id.num9_btn)

        numA = findViewById(R.id.numA_btn)
        numB = findViewById(R.id.numB_btn)
        numC = findViewById(R.id.numC_btn)
        numD = findViewById(R.id.numD_btn)
        numE = findViewById(R.id.numE_btn)
        numF = findViewById(R.id.numF_btn)

        clearAllButton = findViewById(R.id.clear_btn)
        equalButton = findViewById(R.id.equal_btn)

    }

    private fun bindUITextViews() {
        hexadecimalTextView = findViewById(R.id.hex_result_tv)
        decimalTextView = findViewById(R.id.decimal_result_tv)
        octalTextView = findViewById(R.id.octa_result_tv)
        binaryTextView = findViewById(R.id.binary_result_tv)

        inputTextView = findViewById(R.id.input_tv)
    }

    private fun setupBinaryNumbers() {
        allNumbersButtonsList.forEachIndexed { index, button ->
            button.isEnabled = index <= 1
        }
    }

    private fun setupOctalNumbers() {
        allNumbersButtonsList.forEachIndexed { index, button ->
            button.isEnabled = index <= 7
        }
    }

    private fun setupDecimalNumbers() {
        allNumbersButtonsList.forEachIndexed { index, button ->
            button.isEnabled = index <= 9
        }

    }

    private fun setupHexadecimalNumbers() {
        allNumbersButtonsList.forEach {
            it.isEnabled = true
        }
    }
}