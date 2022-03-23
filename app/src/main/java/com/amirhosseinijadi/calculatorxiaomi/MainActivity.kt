package com.amirhosseinijadi.calculatorxiaomi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amirhosseinijadi.calculatorxiaomi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onnumberClicked()
        onoperationclicked()
    }

    private fun onnumberClicked() {
        binding.btn0.setOnClickListener {
            if (binding.txtExpression.text.isNotEmpty()) {
                appendtex("0")
            }


        }
        binding.btn1.setOnClickListener {
            appendtex("1")

        }
        binding.btn2.setOnClickListener {
            appendtex("2")

        }
        binding.btn3.setOnClickListener {
            appendtex("3")

        }
        binding.btn4.setOnClickListener {
            appendtex("4")

        }
        binding.btn5.setOnClickListener {
            appendtex("5")

        }
        binding.btn6.setOnClickListener {
            appendtex("6")

        }
        binding.btn7.setOnClickListener {
            appendtex("7")

        }
        binding.btn8.setOnClickListener {
            appendtex("8")

        }
        binding.btn9.setOnClickListener {
            appendtex("9")

        }
        binding.btnDot.setOnClickListener {
            if (binding.txtExpression.text.isEmpty()) {
                appendtex("0.")
            } else if (!binding.txtExpression.text.contains(".")) {

                appendtex(".")
            }


        }
        binding.btnMosavi.setOnClickListener {
            val expression = ExpressionBuilder(binding.txtExpression.text.toString()).build()
            val result = expression.evaluate()

            val longresult = result.toLong()

            if (result == longresult.toDouble()) {
                binding.txtJavab.text = longresult.toString()
            } else {
                binding.txtJavab.text = result.toString()
            }
        }

    }

    private fun onoperationclicked() {
        binding.btnJam.setOnClickListener {
           appendtex("+")
            }

        
        binding.btnMenha.setOnClickListener {
            appendtex("-")
        }
        binding.btnZarb.setOnClickListener {
            appendtex("*")
        }
        binding.btnTaghsim.setOnClickListener {
            appendtex("/")
        }
        binding.btnParantezbaz.setOnClickListener {

            appendtex("(")
        }
        binding.btnParantezbaste.setOnClickListener {
            appendtex(")")
        }
        binding.btnAC.setOnClickListener {
            binding.txtExpression.text = ""
            binding.txtJavab.text = ""
        }
        binding.btnPakidan.setOnClickListener {
            val oldtext = binding.txtExpression.text.toString()
            if (oldtext.isNotEmpty()) {
                binding.txtExpression.text = oldtext.substring(0, oldtext.length - 1)


            }

        }

    }

    private fun appendtex(newtext: String) {
        if (binding.txtJavab.text.isNotEmpty()) {
            binding.txtExpression.text = ""
        }
        binding.txtJavab.text = ""
        binding.txtExpression.append(newtext)


    }
}