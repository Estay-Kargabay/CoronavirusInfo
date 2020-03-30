package com.info.coronavirusdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val demo :String
        //val country = editText_Country.text
        //searchBTN.setOnClickListener { fetchJson(country.toString())}}




    fun fetchJson(country: String) {
        println("Attempting to Fetch JSON")
        val url = " https://coronavirus-19-api.herokuapp.com/countries/$country"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)
              //  textView.text=body
                val gson = GsonBuilder().create()

              //  val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                //runOnUiThread {
                  //  recyclerView_main.adapter = MainAdapter(homeFeed)
               // }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }
}}