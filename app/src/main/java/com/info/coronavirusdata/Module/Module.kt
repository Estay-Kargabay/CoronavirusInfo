package com.info.coronavirusdata.Module

data class kzModule(
    val active: Int,
    val cases: Int,
    val casesPerOneMillion: Int,
    val country: String,
    val critical: Int,
    val deaths: Int,
    val deathsPerOneMillion: Int,
    val firstCase: String,
    val recovered: Int,
    val todayCases: Int,
    val todayDeaths: Int
)


data class WorlodModule(  val cases: Int,
                          val deaths: Int,
                          val recovered: Int)


data class SearchModule(   val active: Int,
                     val cases: Int,
                     val casesPerOneMillion: Int,
                     val country: String,
                     val critical: Int,
                     val deaths: Int,
                     val deathsPerOneMillion: Int,
                     val firstCase: String,
                     val recovered: Int,
                     val todayCases: Int,
                     val todayDeaths: Int)