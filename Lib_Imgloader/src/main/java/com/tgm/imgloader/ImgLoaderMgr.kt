package com.tgm.imgloader

import android.graphics.Bitmap
import android.graphics.drawable.Drawable


class ImgLoaderMgr private constructor() {

    private val mImageLoader = GlideImageLoader()

    companion object {
        val instance: ImgLoaderMgr = ImgLoaderMgr()
    }


    fun show(option: IlOptions) {
        mImageLoader.showImage(option)
    }

    fun getDrawable(option: IlOptions): Drawable? {
        return mImageLoader.getDrawable(option)
    }

    fun getBitmap(option: IlOptions): Bitmap? {
        return mImageLoader.getBitmap(option)
    }

}