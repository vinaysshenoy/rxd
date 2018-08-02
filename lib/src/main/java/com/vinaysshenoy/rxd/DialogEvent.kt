package com.vinaysshenoy.rxd

import android.app.Dialog

sealed class DialogEvent(val dialog: Dialog)

class Cancelled(dialog: Dialog): DialogEvent(dialog)
class Dismissed(dialog: Dialog): DialogEvent(dialog)
class PositiveClick(dialog: Dialog): DialogEvent(dialog)
class NeutralClick(dialog: Dialog): DialogEvent(dialog)
class NegativeClick(dialog: Dialog): DialogEvent(dialog)
class ItemSelected(dialog: Dialog, itemIndex: Int): DialogEvent(dialog)
class ItemUnselected(dialog: Dialog, itemIndex: Int): DialogEvent(dialog)

