package net.devspress.kotlintipcalculatorblind.eventlistener

import android.widget.SeekBar
import net.devspress.kotlintipcalculatorblind.MainActivity

class SeekbarEventListener(val mainActivity: MainActivity) : SeekBar.OnSeekBarChangeListener {
    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        mainActivity.percent = progress / 100.0
        mainActivity.calculate()
    }
}