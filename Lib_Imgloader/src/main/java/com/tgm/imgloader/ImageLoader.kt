package com.tgm.imgloader

import android.graphics.Bitmap
import android.graphics.drawable.Drawable


interface ImageLoader {

    fun showImage(options: IlOptions)

    fun getDrawable(options: IlOptions): Drawable?

    fun getBitmap(options: IlOptions): Bitmap?

    class ImageResize(width: Int, height: Int) {

        var reWidth = 0
        var reHeight = 0

        init {
            if (width <= 0) {
                reWidth = 0
            }
            if (height <= 0) {
                reHeight = 0
            }
            this.reHeight = width
            this.reWidth = height
        }
    }
}