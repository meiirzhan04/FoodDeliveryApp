package com.example.aifood.ui.theme.dastan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aifood.R

data class BottomCC(
    val image_0:Int,
    val image_1:Int,
    val label:String,
    var isActive: Boolean)

class BottomViewModel : ViewModel() {

    private val _bottomItems = MutableLiveData<List<BottomCC>>()
    val bottomItems: LiveData<List<BottomCC>> get() = _bottomItems

    init {
        _bottomItems.value = listOf(
            BottomCC(R.drawable.ic_bottom_home, R.drawable.ic_bottom_home1, "home", true),
            BottomCC(R.drawable.ic_bottom_basket, R.drawable.ic_bottom_basket1, "basket", false),
            BottomCC(R.drawable.ic_bottom_chat, R.drawable.ic_bottom_chat1, "chat", false),
            BottomCC(R.drawable.ic_bottom_profile, R.drawable.ic_bottom_profile1, "profile", false)
        )
    }

    fun toggleItemState(label: String) {
        _bottomItems.value = _bottomItems.value?.map {
            if (it.label == label) {

                it.copy(isActive = true)
            } else {
                it.copy(isActive = false)
            }
        }
    }
}
