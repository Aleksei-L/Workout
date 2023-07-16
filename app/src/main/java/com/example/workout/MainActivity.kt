package com.example.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity(), WorkoutListFragment.Listener {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun itemClicked(id: Long) {
		val myIntent = Intent(this, DetailActivity::class.java)
		myIntent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, id.toInt())
		startActivity(myIntent)
	}
}
