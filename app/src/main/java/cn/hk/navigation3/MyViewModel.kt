package cn.hk.navigation3

import android.util.Log
import androidx.core.widget.TextViewCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var number: MutableLiveData<Int> = MutableLiveData(0)

    fun get() = number

    fun set(result: Int) {
        number.value = result
    }


    fun count(x: Int) {
        number.value = number.value?.plus(x)
        if (number.value!! < 0)
            number.value = 0
    }


}