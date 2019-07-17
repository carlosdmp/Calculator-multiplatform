package sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import calculator.*

actual class Sample {
    actual fun checkMe() = 44
}

actual object Platform {
    actual val name: String = "Android"
}

class MainActivity : AppCompatActivity(), CalculatorView {

    override fun showState(state: CalculatorState) {
        findViewById<TextView>(R.id.tv_display).text = state.currentNumber.toString()
    }

    private val presenter = CalculatorPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Sample().checkMe()
        setContentView(R.layout.activity_main)
        listOf(
            R.id.b_op1, R.id.b_op2, R.id.b_op3,
            R.id.b_op4, R.id.b_op5, R.id.b_op6,
            R.id.b_op7, R.id.b_op8, R.id.b_op9,
            R.id.b_op9
        ).map { findViewById<Button>(it) }
            .forEach { button ->
                button.setOnClickListener {
                    presenter.onNumberPressed(button.text.toString().toDouble())
                }
            }
        findViewById<Button>(R.id.b_op_plus).setOnClickListener {
            presenter.onOperation(Sum)
        }
        findViewById<Button>(R.id.b_op_sub).setOnClickListener {
            presenter.onOperation(Substract)
        }
        findViewById<Button>(R.id.b_equal).setOnClickListener {
            presenter.onOperation(Equal)
        }
        findViewById<Button>(R.id.b_clear).setOnClickListener {
            presenter.onOperation(Clear)
        }
    }
}