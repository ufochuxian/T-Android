package com.tgm.common.databinding

import android.view.View
import androidx.databinding.BindingAdapter

class ViewBindAdapter {

    companion object {


        @JvmStatic
        @BindingAdapter("android:layout_height")
        fun setLayoutHeight(view: View, height: Float) {
            val layoutParams = view.layoutParams;
            layoutParams.height = height.toInt();
            view.layoutParams = layoutParams;
        }


    }


}