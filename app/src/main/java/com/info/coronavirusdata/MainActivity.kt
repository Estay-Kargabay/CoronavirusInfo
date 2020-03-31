package com.info.coronavirusdata

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.UiThread
import com.google.gson.GsonBuilder

import com.info.coronavirusdata.Module.SearchModule
import com.info.coronavirusdata.Module.WorlodModule
import com.info.coronavirusdata.Module.kzModule
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var country :String?= ""
        val text = search_edittext.text
        Log.d("m","$country")
        kzJson()
        WorldJson()
        searchBTN.setOnClickListener { SearchJson(text.toString()) }}

    fun SearchJson(country: String) {
        println("Attempting to Fetch JSON")
        val url = "https://coronavirus-19-api.herokuapp.com/countries/$country"
        Log.d("ddd","sdncjsdnvkdnvndkdvcskcmdskncndskvs>>>>>>>>>$country")
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
              runOnUiThread {                 // Toast.makeText(this@MainActivity,"Қате енгіздіңіз",Toast.LENGTH_SHORT).show()
              }}

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
               // println(body)
               // Log.d("demo","$body")
               // textView.text=body
                if (body!==null){
                    search_edittext.text.clear()
                }
                try {
                    val gson = GsonBuilder().create()
                    val  SearchFeed = gson.fromJson(body, SearchModule::class.java)
                    Log.d("demo","${SearchFeed.cases}")
                    runOnUiThread {
                        coutry_name.text=SearchFeed.country
                        all_s.text=SearchFeed.cases.toString()
                        today_s.text=SearchFeed.todayCases.toString()
                        rec_s.text=SearchFeed.recovered.toString()
                        death_s.text=SearchFeed.deaths.toString()
                        Todaydeath_s.text=SearchFeed.todayDeaths.toString()}}
                catch (e:Exception ) {
                    runOnUiThread{
                        Toast.makeText(this@MainActivity,"Қате енгіздіңіз",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            fun displayError(error: Throwable) {
                Log.i("MYAPP", "Error while doing something", error)
            }

        })
    }
    fun kzJson() {
        println("Attempting to Fetch JSON")
        val url = "https://coronavirus-19-api.herokuapp.com/countries/Kazakhstan"
       // Log.d("ddd","sdncjsdnvkdnvndkdvcskcmdskncndskvs>>>>>>>>>$country")
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {                 // Toast.makeText(this@MainActivity,"Қате енгіздіңіз",Toast.LENGTH_SHORT).show()
                }}

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                // println(body)
                // Log.d("demo","$body")
                // textView.text=body
                if (body!==null){
                    search_edittext.text.clear()
                }
                try {
                    val gson = GsonBuilder().create()
                    val  kzFeed = gson.fromJson(body, kzModule::class.java)
                    Log.d("demo","${kzFeed.cases}")
                    runOnUiThread {
                        allnum_kz.text=kzFeed.cases.toString()
                        today_kz.text=kzFeed.todayCases.toString()
                        recovery_kz.text=kzFeed.recovered.toString()
                        death_kz.text=kzFeed.deaths.toString()
                        Todaydeath_kz.text=kzFeed.todayDeaths.toString()






                    }}
                catch (e:Exception ) {
                    runOnUiThread{
                        Toast.makeText(this@MainActivity,"Қате енгіздіңіз",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            fun displayError(error: Throwable) {
                Log.i("MYAPP", "Error while doing something", error)
            }

        })
    }
    fun WorldJson() {
        println("Attempting to Fetch JSON")
        val url = "https://coronavirus-19-api.herokuapp.com/all"
        // Log.d("ddd","sdncjsdnvkdnvndkdvcskcmdskncndskvs>>>>>>>>>$country")
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {                 // Toast.makeText(this@MainActivity,"Қате енгіздіңіз",Toast.LENGTH_SHORT).show()
                }}

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                // println(body)
                // Log.d("demo","$body")
                // textView.text=body
                if (body!==null){
                    search_edittext.text.clear()
                }
                try {
                    val gson = GsonBuilder().create()
                    val  WorldFeed = gson.fromJson(body, WorlodModule::class.java)
                    Log.d("demo","${WorldFeed.cases}")
                    runOnUiThread {
                        allnum_world.text=WorldFeed.cases.toString()
                        recovery_world.text=WorldFeed.recovered.toString()
                        death_world.text=WorldFeed.deaths.toString()
                    }}
                catch (e:Exception ) {
                    runOnUiThread{
                        Toast.makeText(this@MainActivity,"Қате енгіздіңіз",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            fun displayError(error: Throwable) {
                Log.i("MYAPP", "Error while doing something", error)
            }

        })
    }

}