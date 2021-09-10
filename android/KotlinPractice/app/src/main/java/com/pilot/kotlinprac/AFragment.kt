package com.pilot.kotlinprac

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

 class AFragment : Fragment() {
     lateinit var mainActivity: MainActivity

     override fun onAttach(context: Context){
         super.onAttach(context)
         mainActivity = context as MainActivity
     }

     private lateinit var af1 : TextView

    val CLIENT_ID : String = "4D9m4dpn8tcORt1UWm9L"
    val CLIENT_SECRET : String = "ggWxyQJ9vY"
    val BASE_URL_NAVER_API: String = "https://openapi.naver.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_NAVER_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(NaverAPI::class.java)
    val callGetSearchNews = api.getSearchNews(CLIENT_ID, CLIENT_SECRET, "테스트")

     var sangsu : String? = null

     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a,container,false)
    }


     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)

         callGetSearchNews.enqueue(object : Callback<ResultGetSearchNews> {
             override fun onResponse(
                 call: Call<ResultGetSearchNews>,
                 response: Response<ResultGetSearchNews>
             ) {
                 Log.d(ContentValues.TAG, "연결 성공 : ${response.raw()}")
                 af1 = view.findViewById(R.id.texViewA)
                 af1.setText(response.body().toString())
             }

             override fun onFailure(call: Call<ResultGetSearchNews>, t: Throwable) {
                 Log.d(ContentValues.TAG, "연결 실패 : $t")
             }
         })


     }


}