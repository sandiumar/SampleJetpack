package id.sandyu.samplejetpack.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //TODO: Implement the ViewModel
    private val _data = MutableLiveData<String>()
    val data: MutableLiveData<String>
    /*Getter */
    get() = _data
    init {
        _data.value = "Hello, world!"
    }
}