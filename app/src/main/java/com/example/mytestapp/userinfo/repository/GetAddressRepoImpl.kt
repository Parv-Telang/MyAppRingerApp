package com.example.mytestapp.userinfo.repository

import com.example.mytestapp.core.network.RetrofitAdapter
import com.example.mytestapp.core.repository.GetAddressRepository
import com.example.mytestapp.userinfo.model.Request
import com.example.mytestapp.userinfo.model.Response
import com.example.mytestapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAddressRepoImpl @Inject constructor(
    private val api: RetrofitAdapter
): GetAddressRepository {
    override fun getAddressInfo(getAddressRequest: Request): Flow<Resource<Response>> {
        TODO("Not yet implemented")

    }
}