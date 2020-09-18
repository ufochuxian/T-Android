package com.tgm.imgloader

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class GlideImageLoader : ImageLoader {

    @SuppressLint("CheckResult")
    override fun showImage(options: IlOptions) {

        options.view?.let { view ->

            val request = Glide.with(view)
            val dtr = if (options.resId != -1) {
                request.load(options.resId)
            } else {
                request.load(options.url)
            }

            if (options.listener != null) {
                dtr.listener(options.listener)
            }
            if (options.placeHolder != -1) {
                dtr.placeholder(options.placeHolder)
            }
            if (options.errorDrawable != -1) {
                dtr.error(options.errorDrawable)
            }
            if (!options.animate) {
                dtr.dontAnimate()
            }
            if (options.isSkipMemoryCache) {
                dtr.skipMemoryCache(options.isSkipMemoryCache)
            }
            options.size?.let {
                dtr.override(it.reWidth, it.reHeight)
            }
            if (options.corner > 0) {
                dtr.apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(options.corner.toInt(), 0)))
            }

            dtr.into(view)
        }
    }


    override fun getDrawable(options: IlOptions): Drawable? {
        options.context?.let { context ->
            val builder = Glide.with(context).load(options.url)
            options.size?.let { size ->
                builder.override(size.reWidth, size.reHeight)
            }
            return builder.submit().get()
        }
        return null
    }


    override fun getBitmap(options: IlOptions): Bitmap? {
        options.context?.let { context ->
            val builder = Glide.with(context).asBitmap().load(options.url)
            options.size?.let { size ->
                builder.override(size.reWidth, size.reHeight)
            } ?: run {
                builder.override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
            }
            return builder.submit().get()
        }
        return null
    }
}