package com.example.aifood.ui.theme.dastan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KeyboardViewModel : ViewModel() {
    private val _isKeyboardOpen = MutableLiveData(false)
    val isKeyboardOpen: LiveData<Boolean> = _isKeyboardOpen

    fun updateKeyboardState(isOpen: Boolean) {
        _isKeyboardOpen.value = isOpen
    }
}

