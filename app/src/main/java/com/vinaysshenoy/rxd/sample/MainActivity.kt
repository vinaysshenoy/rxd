package com.vinaysshenoy.rxd.sample

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.vinaysshenoy.rxd.ConfirmDialog
import com.vinaysshenoy.rxd.RxAlertDialog

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		if (savedInstanceState == null) {
			RxAlertDialog().show(
					supportFragmentManager, "alert_dialog",
					ConfirmDialog(
							"Yes", negativeButton = "Cancel", title = "Alert!", message = "Hello there!"
					)
			)
		}
	}

	override fun onAttachFragment(fragment: Fragment) {
		super.onAttachFragment(fragment)
		Log.d(TAG, "Attach fragment with tag: ${fragment.tag}")
	}
}
