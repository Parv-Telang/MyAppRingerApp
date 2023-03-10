package com.example.mytestapp.util

sealed class Resource<T>(val data: T?, val message:String?, val errorCode: String?) {
    class Success<T>(data: T) : Resource<T>(data, null, null)
    class Error<T>(data: T? = null, message: String?= null, errorCode: String?= null):
            Resource<T>(data, message = message, errorCode= errorCode)
    class Loading<T>(data: T?= null): Resource<T>(data, null, null)
}
