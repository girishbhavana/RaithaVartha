package com.raithavartha.app.model

data class Advisory(
    val id: Int,
    val cropEnglish: String,
    val cropKannada: String,
    val category: String,
    val titleEnglish: String,
    val titleKannada: String,
    val tipEnglish: String,
    val tipKannada: String,
    val diseaseKeywords: List<String>,
    val imageUrl: String,
    val dosage: String,
    val weather: String,
    val source: String
)

data class FarmerProfile(
    val name: String = "Ramesh Gowda",
    val mobile: String = "9876543210",
    val district: String = "Bangalore Rural",
    val taluk: String = "Hoskote",
    val language: String = "Kannada"
)
