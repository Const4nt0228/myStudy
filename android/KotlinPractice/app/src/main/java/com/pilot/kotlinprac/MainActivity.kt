package com.pilot.kotlinprac

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val CLIENT_ID : String = "4D9m4dpn8tcORt1UWm9L"
    val CLIENT_SECRET : String = "ggWxyQJ9vY"
    val BASE_URL_NAVER_API: String = "https://openapi.naver.com/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_NAVER_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(NaverAPI::class.java)
    val callGetSearchNews = api.getSearchNews(CLIENT_ID, CLIENT_SECRET, "테스트")

    val api2 = retrofit.create(NaverAPI2::class.java)
    val callPostTransferPapago = api2.transferPapago(CLIENT_ID,CLIENT_SECRET,"ko","en","테스트입니다. 이거 번역해주세요")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_A = findViewById<Button>(R.id.btn_fragmentA)
        val btn_B = findViewById<Button>(R.id.btn_fragmentB)
        val btn_C = findViewById<Button>(R.id.btn_fragmentC)
        val btn_D = findViewById<Button>(R.id.btn_fragmentD)


     /*   callGetSearchNews.enqueue(object : Callback<ResultGetSearchNews> {
            override fun onResponse(
                call: Call<ResultGetSearchNews>,
                response: Response<ResultGetSearchNews>
            ) {
                Log.d(TAG, "연결 성공 : ${response.body()}")
            }

            override fun onFailure(call: Call<ResultGetSearchNews>, t: Throwable) {
                Log.d(TAG, "연결 실패 : $t")
            }
        })*/

        /*callPostTransferPapago.enqueue(object : Callback<ResultTransferPapago> {
            override fun onResponse(
                call: Call<ResultTransferPapago>,
                response: Response<ResultTransferPapago>
            ) {
                Log.d(TAG, "성공 : ${response.body()}")
            }

            override fun onFailure(call: Call<ResultTransferPapago>, t: Throwable) {
                Log.d(TAG, "실패 : $t")
            }
        })*/


        btn_A.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, AFragment())
                .commit()
        }
        btn_B.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, BFragment())
                .commit()

        }

        btn_C.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, CFragment())
                .commit()

        }
        btn_D.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, DFragment())
                .commit()

        }


    }
}