package com.vinaysshenoy.rxd

import android.app.Dialog
import android.content.Context
import android.os.Parcelable
import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import kotlinx.android.parcel.Parcelize

sealed class DialogType : Parcelable {

	abstract fun create(context: Context): Dialog
}

@Parcelize
data class ConfirmDialog @JvmOverloads constructor(
	val positiveButton: CharSequence,
	val neutralButton: CharSequence = "",
	val negativeButton: CharSequence = "",
	val title: CharSequence = "",
	val message: CharSequence = ""
) : DialogType() {

	override fun create(context: Context): Dialog {
		val builder = AlertDialog.Builder(context)
				.setPositiveButton(positiveButton) { _, _ -> }

		if (neutralButton.isNotBlank()) {
			builder.setNeutralButton(neutralButton) { _, _ -> }
		}

		if (negativeButton.isNotBlank()) {
			builder.setNegativeButton(negativeButton) { _, _ -> }
		}

		if (title.isNotBlank()) {
			builder.setTitle(title)
		}

		if (message.isNotBlank()) {
			builder.setMessage(message)
		}

		return builder.create()
	}
}

@Parcelize
data class ConfirmDialogRes @JvmOverloads constructor(
	@StringRes val positiveButton: Int,
	@StringRes val neutralButton: Int = 0,
	@StringRes val negativeButton: Int = 0,
	@StringRes val title: Int = 0,
	@StringRes val message: Int = 0
) : DialogType() {

	override fun create(context: Context): Dialog {
		val builder = AlertDialog.Builder(context)
				.setPositiveButton(positiveButton) { _, _ -> }

		if (neutralButton > 0) {
			builder.setNeutralButton(neutralButton) { _, _ -> }
		}

		if (negativeButton > 0) {
			builder.setNegativeButton(negativeButton) { _, _ -> }
		}

		if (title > 0) {
			builder.setTitle(title)
		}

		if (message > 0) {
			builder.setMessage(message)
		}

		return builder.create()
	}
}

