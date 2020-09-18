package com.tgm.common.databinding

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestListener
import com.tgm.imgloader.IlOptions
import com.tgm.imgloader.ImgLoaderMgr


class BindAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun setSimpleImage(imageView: ImageView, url: String?) {
            url?.let {
                ImgLoaderMgr.instance.show(
                    IlOptions(
                        view = imageView,
                        url = it,
                        animate = false)
                )
            }
        }


        @JvmStatic
        @BindingAdapter("app:imageUrl", "app:imageHolder", requireAll = true)
        fun setImage(imageView: ImageView, url: String?, holder: Int) {
            url?.let {
                ImgLoaderMgr.instance.show(
                    IlOptions(
                        view = imageView,
                        url = url,
                        animate = false,
                        placeHolder = holder)
                )
            } ?: imageView.setImageResource(holder)
        }

        @JvmStatic
        @BindingAdapter("app:imageUrl", "app:imageHolder", "app:imgCorner", "app:imgListener", requireAll = false)
        fun setImage(imageView: ImageView, url: String?, holder: Int, corner: Float, listener: RequestListener<Drawable>?) {
            url?.let {
                ImgLoaderMgr.instance.show(
                    IlOptions(
                        view = imageView,
                        url = url,
                        animate = false,
                        placeHolder = holder,
                        listener = listener,
                        corner = corner)
                )
            } ?: imageView.setImageResource(holder)
        }


        @JvmStatic
        @BindingAdapter("app:srcId", "app:imgListener", requireAll = false)
        fun setImageViewResource(view: ImageView, resId: Int, listener: RequestListener<Drawable>?) {
            ImgLoaderMgr.instance.show(
                IlOptions(
                    view = view,
                    resId = resId,
                    listener = listener,
                    animate = false
            )
            )
        }

        @JvmStatic
        @BindingAdapter("app:layout_marginBottom")
        fun setLayoutMarginBottom(view: View, marginBottom: Float) {
            if (view.layoutParams is ViewGroup.MarginLayoutParams) {
                val p: ViewGroup.MarginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
                p.setMargins(p.leftMargin, p.topMargin, p.rightMargin, marginBottom.toInt())
                view.requestLayout()
            }
        }


        @JvmStatic
        @BindingAdapter("app:layout_marginStart")
        fun setLayoutMarginStart(view: View, marginStart: Float) {
            if (view.layoutParams is ViewGroup.MarginLayoutParams) {
                val p: ViewGroup.MarginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
                p.marginStart = marginStart.toInt()
                view.layoutParams = p
            }
        }

        @JvmStatic
        @BindingAdapter("app:layout_marginTop")
        fun setLayoutMarginTop(view: View, marginTop: Float) {
            if (view.layoutParams is ViewGroup.MarginLayoutParams) {
                val p: ViewGroup.MarginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
                p.setMargins(p.leftMargin, marginTop.toInt(), p.rightMargin, p.bottomMargin)
                view.requestLayout()
            }
        }


        @JvmStatic
        @BindingAdapter("app:background")
        fun setBackGround(view: View, drawable: Drawable) {
            view.background = drawable
        }


        @JvmStatic
        @BindingAdapter("app:layout_width", "app:layout_height", requireAll = true)
        fun setSize(view: View, width: Float, height: Float) {
            view.layoutParams.apply {
                this.width = width.toInt()
                this.height = height.toInt()
            }
            view.requestLayout()
        }


        @JvmStatic
        @BindingAdapter("app:setVisible")
        fun setVisibility(view: View, visibility: Int) {
            view.visibility = visibility
        }


        @JvmStatic
        @BindingAdapter("app:isSelected")
        fun isChecked(view: View, isSelected: Boolean) {
            view.isSelected = isSelected

        }

        @JvmStatic
        @BindingAdapter("app:isBringToFront")
        fun isBringToFront(view: View, isSelected: Boolean) {
            if (isSelected) {
                view.parent.bringChildToFront(view)
            }
        }

    }
}