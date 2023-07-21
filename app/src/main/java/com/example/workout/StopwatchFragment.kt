package com.example.workout

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.Locale

class StopwatchFragment : Fragment() {
	private var seconds = 0
	private var running = false
	private var wasRunning = false

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val layout: View? = inflater.inflate(R.layout.fragment_stopwatch, container, false)

		val startButton: Button? = layout?.findViewById(R.id.start_button)
		val stopButton: Button? = layout?.findViewById(R.id.stop_button)
		val resetButton: Button? = layout?.findViewById(R.id.reset_button)

		startButton?.setOnClickListener { onClickStart() }
		stopButton?.setOnClickListener { onClickStop() }
		resetButton?.setOnClickListener { onClickReset() }

		runTimer(layout)
		return layout
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		if (savedInstanceState != null) {
			seconds = savedInstanceState.getInt("seconds")
			running = savedInstanceState.getBoolean("running")
			wasRunning = savedInstanceState.getBoolean("wasRunning")
		}
	}

	override fun onSaveInstanceState(savedInstanceState: Bundle) {
		savedInstanceState.putInt("seconds", seconds)
		savedInstanceState.putBoolean("running", running)
		savedInstanceState.putBoolean("wasRunning", wasRunning)
	}

	private fun onClickStart() {
		running = true
	}

	private fun onClickStop() {
		running = false
	}

	private fun onClickReset() {
		running = false
		seconds = 0
	}

	private fun runTimer(view: View?) {
		val timeView = view?.findViewById<View>(R.id.time_view) as TextView
		val handler = Handler()
		handler.post(object : Runnable {
			override fun run() {
				val hours = seconds / 3600
				val minutes = seconds % 3600 / 60
				val secs = seconds % 60
				val time = String.format(
					Locale.getDefault(),
					"%d:%02d:%02d", hours, minutes, secs
				)
				timeView.text = time
				if (running) {
					seconds++
				}
				handler.postDelayed(this, 1000)
			}
		})
	}
}
