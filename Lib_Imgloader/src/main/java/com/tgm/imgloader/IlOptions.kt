package com.tgm.imgloader

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.request.RequestListener
import com.tgm.imgloader.ImageLoader


class IlOptions(
    var view: ImageView? = null,
    var url: String? = null,
    var resId: Int = -1,
    var size: ImageLoader.ImageResize? = null,
    var placeHolder: Int = -1,
    var errorDrawable: Int = -1,
    var animate: Boolean = false,
    var isSkipMemoryCache: Boolean = false,
    var corner: Float = 0f,
    var context: Context? = null,
    var listener: RequestListener<Drawable>? = null
)