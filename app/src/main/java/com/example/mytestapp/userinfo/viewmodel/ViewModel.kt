package com.example.mytestapp.userinfo.viewmodel

//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.mytestapp.core.model.InputWrapper
//import javax.inject.Inject
//
//class UserInfoViewModel @Inject constructor(
//    handle: SavedStateHandle
//) : ViewModel() {
//
//    var firstName = handle.getStateFlow("firstNAme", InputWrapper())
//    var lastName = handle.getStateFlow("lastNAme", InputWrapper())
//
//    fun onFirstNameEntered(input: String) {
//       firstName.value = firstName.value.copy(value = input)
//    }
//
//}