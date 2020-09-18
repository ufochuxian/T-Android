package com.tgm.common.databinding

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

open class ObservableViewModel : ViewModel(), Observable {

    val propertyChangeRegistry by lazy {
        PropertyChangeRegistry()
    }


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)


    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }


    fun notifyPropertyChanged(fieldId: Int) {
        propertyChangeRegistry.notifyCallbacks(this, fieldId, null)
    }


    fun notifyChange() {
        propertyChangeRegistry.notifyCallbacks(this, 0, null)

    }




}