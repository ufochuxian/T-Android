package com.tgm.common.databinding


class ListEmptyBinding(val iconRes: Int, val bottomShow: Boolean, val text: String) {

    var onClickListener: (() -> Unit)? = null

    fun onButtonClick() {
        onClickListener?.invoke()
    }
}