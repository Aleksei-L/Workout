package com.example.workout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class WorkoutDetailFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_workout_detail, container, false)
	}

	override fun onStart() {
		super.onStart()
		val myView: View? = view
		if (myView != null) {
			val title: TextView = myView.findViewById(R.id.textTitle)
			val workout: Workout = Workout.workouts[workoutId]
			title.text = workout.getName()
			val description: TextView = myView.findViewById(R.id.textDescription)
			description.text = workout.getDescription()
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		if (savedInstanceState != null)
			workoutId = savedInstanceState.getInt("workoutId")
	}

	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
		outState.putInt("workoutId", workoutId)
	}

	private var workoutId = 0

	public fun setWorkout(id: Int) {
		workoutId = id
	}
}
