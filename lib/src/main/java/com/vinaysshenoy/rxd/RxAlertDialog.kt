package com.vinaysshenoy.rxd

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.util.Log

private const val TAG = "RxAlertDialog"

class RxAlertDialog : DialogFragment() {

	private lateinit var dialogType: DialogType

	fun show(
		fragmentManager: FragmentManager,
		tag: String,
		dialogType: DialogType
	) {
		this.dialogType = dialogType
		show(fragmentManager, tag)
	}

	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
		outState.putParcelable("dialog_type", dialogType)
	}

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
		if (savedInstanceState != null) {
			dialogType = savedInstanceState.getParcelable("dialog_type")
		}

		return dialogType.create(context!!)
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)
		Log.d(TAG, "On Attach to ${context.javaClass.canonicalName}")
	}

}