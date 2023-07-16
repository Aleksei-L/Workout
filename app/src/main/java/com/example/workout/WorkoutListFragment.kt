package com.example.workout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class WorkoutListFragment : ListFragment() {
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val names = arrayOfNulls<String>(Workout.workouts.size)
		for (i in names.indices)
			names[i] = Workout.workouts[i].getName()

		val adapter: ArrayAdapter<String> = ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1, names)
		listAdapter = adapter

		return super.onCreateView(inflater, container, savedInstanceState)
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)
		listener = context as? Listener
	}

	private var listener: Listener? = null

	interface Listener {
		fun itemClicked(id: Long)
	}

	override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
		super.onListItemClick(l, v, position, id)
		listener?.itemClicked(id)
	}
}
