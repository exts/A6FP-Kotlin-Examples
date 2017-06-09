package net.devspress.kotlintipcalculatorblind.eventlistener

import android.text.Editable
import android.text.TextWatcher
import net.devspress.kotlintipcalculatorblind.MainActivity

class AmountTextEventListener(val mainActivity: MainActivity) : TextWatcher {
    override fun afterTextChanged(s: Editable?) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        mainActivity.billAmount = s.toString().toDouble() / 100.0
        mainActivity.calculate()
    }
}