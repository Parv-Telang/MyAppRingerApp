package com.example.mytestapp.userinfo.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Response(
    @field: JsonProperty("success") val success: Boolean = false,
    @field: JsonProperty("responseCode") val responseCode: Int,
    @field: JsonProperty("responseMsg") val responseMsg: String,
    @field: JsonProperty("data") val data: ArrayList<Data>,


)