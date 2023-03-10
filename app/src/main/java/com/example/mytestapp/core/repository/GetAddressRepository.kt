package com.example.mytestapp.core.repository

import com.example.mytestapp.userinfo.model.Request
import com.example.mytestapp.userinfo.model.Response
import com.example.mytestapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetAddressRepository {
    fun getAddressInfo(getAddressRequest: Request): Flow<Resource<Response>>
}