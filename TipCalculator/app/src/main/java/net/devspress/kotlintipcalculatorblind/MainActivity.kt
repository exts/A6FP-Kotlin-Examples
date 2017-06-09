package net.devspress.kotlintipcalculatorblind

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import net.devspress.kotlintipcalculatorblind.eventlistener.AmountTextEventListener
import net.devspress.kotlintipcalculatorblind.eventlistener.SeekbarEventListener
import java.lang.NumberFormatException
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    var percent = 0.15
    var billAmount = 0.0

    private val percentFormat = NumberFormat.getPercentInstance()
    private val currencyFormat = NumberFormat.getCurrencyInstance()

    private var amountTextEdit : EditText? = null
    private var amountTextView : TextView? = null

    private var percentTextView : TextView? = null
    private var percentSeekbar : SeekBar? = null

    private var tipTextView : TextView? = null
    private var totalTextView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        amountTextView = findViewById(R.id.amountTextView) as TextView
        amountTextEdit = findViewById(R.id.amountEditText) as EditText

        percentSeekbar = findViewById(R.id.percentSeekBar) as SeekBar
        percentTextView = findViewById(R.id.percentTextView) as TextView

        tipTextView = findViewById(R.id.tipTextView) as TextView
        totalTextView = findViewById(R.id.totalTextView) as TextView

        amountTextEdit?.addTextChangedListener(AmountTextEventListener(this))
        percentSeekbar?.setOnSeekBarChangeListener(SeekbarEventListener(this))
    }

    fun calculate() {

        //calculate values
        val tip = percent * billAmount
        val total = billAmount + tip

        //try setting bill text view
        try {
            amountTextView?.setText(currencyFormat.format(billAmount))
        } catch(e: NumberFormatException) {
            amountTextView?.setText("")
        }

        //set other text view text
        tipTextView?.setText(currencyFormat.format(tip))
        totalTextView?.setText(currencyFormat.format(total))
        percentTextView?.setText(percentFormat.format(percent))
    }
}
