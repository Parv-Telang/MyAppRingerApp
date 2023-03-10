package com.example.mytestapp.userinfo.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Data(
    @field: JsonProperty("postCode") val postCode: String,
    @field: JsonProperty("latitude") val latitude: Int,
    @field: JsonProperty("longitude") val longitude: Int,
    @field: JsonProperty("formatted_address") val formatted_address: ArrayList<String> = ArrayList(),
    @field: JsonProperty("throughfare") val throughfare:String,
    @field: JsonProperty("building_name") val building_name: String,
    @field: JsonProperty("sub_building_name") val sub_building_name: String,
    @field: JsonProperty("sub_building_number") val sub_building_number: String,
    @field: JsonProperty("building_number") val building_number: String,
    @field: JsonProperty("line_1") val line_1:String,
    @field: JsonProperty("line_2") val line_2:String,
    @field: JsonProperty("line_3") val line_3: String,
    @field: JsonProperty("line_4") val line_4: String,
    @field: JsonProperty("loclity") val locality: String,
    @field: JsonProperty("town_or_city") val town_or_city: String,
    @field: JsonProperty("county") val county: String,
    @field: JsonProperty("country") val country: String,
    @field: JsonProperty("district") val district: String,
    @field: JsonProperty("residential") val residential: Boolean

)
