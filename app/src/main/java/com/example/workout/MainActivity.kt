package com.example.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val detailButton: Button = findViewById(R.id.details_button)
		detailButton.setOnClickListener { onShowDetails() }
	}

	private fun onShowDetails() {
		val myIntent = Intent(this, DetailActivity::class.java)
		startActivity(myIntent)
	}
}
