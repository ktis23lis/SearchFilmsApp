package com.example.searchfilmsapp.model.interfaces

import android.os.Build
import android.os.Handler
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.viewbinding.BuildConfig
import com.example.searchfilmsapp.model.FactDTO
import com.example.searchfilmsapp.model.FilmsDTO
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

private const val YOUR_API_KEY = "1d8addf97a9886e6124b23d2897be981"
object FilmsLoader {
 @RequiresApi(Build.VERSION_CODES.N)
 fun loadFIlm(categories: String): FactDTO?{
        try {
            val uri =
                URL("https://api.themoviedb.org/3/movie/${categories}?api_key=1d8addf97a9886e6124b23d2897be981&language=en-US")
                lateinit var urlConnection: HttpURLConnection
                try{
                    urlConnection = uri.openConnection() as HttpURLConnection
                    urlConnection.requestMethod = "GET"
                    urlConnection.addRequestProperty("api_key",
                        "1d8addf97a9886e6124b23d2897be981")
                    urlConnection.readTimeout = 10000
                    val bufferedReader =
                        BufferedReader(InputStreamReader(urlConnection.inputStream))
                    val lines = if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                        getLinesForOld(bufferedReader)
                    } else {
                        getLines(bufferedReader)
                    }
                        return Gson().fromJson(lines, FactDTO::class.java)
                } catch (e: Exception){
                    Log.e(" ", "Fail connection", e)
                    e.printStackTrace()
                }finally {
                    urlConnection.disconnect()
                }
        }catch (e: MalformedURLException){
            Log.e(" ", "FAil URI", e)
            e.printStackTrace()
        }
     return null
    }
//    fun loadFIlm(categories: String): FilmsDTO?{
//        try {
//            val uri =
//                    URL("https://api.themoviedb.org/3/movie/${categories}?api_key=1d8addf97a9886e6124b23d2897be981&language=en-US")
//            lateinit var urlConnection: HttpURLConnection
//            try{
//                urlConnection = uri.openConnection() as HttpURLConnection
//                urlConnection.requestMethod = "GET"
//                urlConnection.addRequestProperty("api_key",
//                        "1d8addf97a9886e6124b23d2897be981")
//                urlConnection.readTimeout = 10000
//                val bufferedReader =
//                        BufferedReader(InputStreamReader(urlConnection.inputStream))
//                val lines = if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
//                    getLinesForOld(bufferedReader)
//                } else {
//                    getLines(bufferedReader)
//                }
//                return Gson().fromJson(lines, FactDTO::class.java)
//            } catch (e: Exception){
//                Log.e(" ", "Fail connection", e)
//                e.printStackTrace()
//            }finally {
//                urlConnection.disconnect()
//            }
//        }catch (e: MalformedURLException){
//            Log.e(" ", "FAil URI", e)
//            e.printStackTrace()
//        }
//        return null
//    }

    private fun getLinesForOld(reader: BufferedReader): String {
        val rawData = StringBuilder(1024)
        var nameVariable: String?

        while (reader.readLine().also { nameVariable = it } != null) {
            rawData.append(nameVariable).append("\n")
        }

        reader.close()
        return rawData.toString()
    }



    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n")) }

}