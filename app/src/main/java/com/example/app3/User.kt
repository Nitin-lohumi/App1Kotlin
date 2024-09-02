package com.example.app3
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class TwoWayViewModel : ViewModel() {
    val userName = MutableLiveData<String>()
}
