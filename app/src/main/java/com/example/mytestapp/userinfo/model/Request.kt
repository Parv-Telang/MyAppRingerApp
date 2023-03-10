package com.example.mytestapp.userinfo.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Request(
    @field:JsonProperty("firstName") val firstName: String,
    @field:JsonProperty("lastName") val lastName: String,
    @field:JsonProperty("dob") val dob: String,
    @field:JsonProperty("gender") val gender: String,
    @field: JsonProperty("pincode") val pincode: String

)
