package com.pilot.kotlinprac

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class BFragment : Fragment() {

    //asd//
    val CLIENT_ID : String = "4D9m4dpn8tcORt1UWm9L"
    val CLIENT_SECRET : String = "ggWxyQJ9vY"
    val BASE_URL_NAVER_API: String = "https://openapi.naver.com/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_NAVER_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api2 = retrofit.create(NaverAPI2::class.java)

    //var callPostTransferPapago = api2.transferPapago(CLIENT_ID,CLIENT_SECRET,"ko","en",myText)



    private lateinit var bf1 : TextView
    private lateinit var ed1 : EditText
    private lateinit var fromText :String
    private lateinit var btn1 :Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_b,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ed1 = view.findViewById(R.id.edit1)
        btn1 = view.findViewById<Button>(R.id.transBtn)
        btn1.setOnClickListener(View.OnClickListener {
            val myText:String = ed1.text.toString()
            var callPostTransferPapago = api2.transferPapago(CLIENT_ID,CLIENT_SECRET,"ko","en",myText)
            callPostTransferPapago.enqueue(object : Callback<ResultTransferPapago> {
                override fun onResponse(
                    call: Call<ResultTransferPapago>,
                    response: Response<ResultTransferPapago>
                ) {
                    Log.d(ContentValues.TAG, "성공 : ${response.body()}")

                    val papagoResponse = response.body()
                    var tText : String = papagoResponse!!.message!!.result!!.translatedText!!

                    bf1 = view.findViewById(R.id.texViewB)
                    bf1.text = tText
                }

                override fun onFailure(call: Call<ResultTransferPapago>, t: Throwable) {
                    Log.d(ContentValues.TAG, "실패 : $t")
                }
            })
        //callPostTransferPapago = api2.transferPapago(CLIENT_ID,CLIENT_SECRET,"ko","en",myText)
        })
    }
}