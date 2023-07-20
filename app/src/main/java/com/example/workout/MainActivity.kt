package com.example.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), WorkoutListFragment.Listener {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun itemClicked(id: Long) {
		val fragmentContainer: View? = findViewById(R.id.fragment_container)
		if (fragmentContainer != null) {
			val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
			val details = WorkoutDetailFragment()
			details.setWorkout(id.toInt())
			ft.replace(R.id.fragment_container, details)
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
			ft.addToBackStack(null)
			ft.commit()
		}
		else {
			val myIntent = Intent(this, DetailActivity::class.java)
			myIntent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, id.toInt())
			startActivity(myIntent)
		}
	}
}
