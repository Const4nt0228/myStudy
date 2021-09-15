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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_c.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CFragment : Fragment() {

    val API_KEY : String = "b00348a64a57c9cdedeb1d3efcba9568"
    val targetDate : String = "20210909"
    val BASE_URL_MOVIE_API: String = "https://www.kobis.or.kr"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_MOVIE_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api2 = retrofit.create(MovieAPI::class.java)
    var callPostTransferMovie = api2.transferMovie(API_KEY,targetDate)
    var list2: List<MResult> = arrayListOf()

    lateinit var mainActivity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) mainActivity = context

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_c,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //

        callPostTransferMovie.enqueue(object : Callback<ResultMovieChart> {
            override fun onResponse(
                call: Call<ResultMovieChart>,
                response: Response<ResultMovieChart>
            ) {
                Log.d(ContentValues.TAG, "성공 : ${response.body()}")
                val movieResponse = response.body()
                list2 = movieResponse!!.boxOfficeResult!!.dailyBoxOfficeList

                var recyclerView : RecyclerView= view.findViewById(R.id.recycleView)
                recyclerView.adapter = ResultRecyclerViewAdpater()
                recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)

            }
            override fun onFailure(call: Call<ResultMovieChart>, t: Throwable) {
                Log.d(ContentValues.TAG, "실패 : $t")
            }
        })





    }


    inner class ResultRecyclerViewAdpater :
        RecyclerView.Adapter<ResultRecyclerViewAdpater.ResultViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ResultRecyclerViewAdpater.ResultViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
            return ResultViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list2.size
        }

        override fun onBindViewHolder(
            holder: ResultRecyclerViewAdpater.ResultViewHolder,
            position: Int
        ) {
            holder.apply {

                rankT.text = list2[position].rank
                movieNmT.text = list2[position].movieNm
                openDtT.text = list2[position].openDt
                audiAccT.text = list2[position].audiAcc
                count1T.text = list2[position].rankInten

            }
        }

        inner class ResultViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

            val rankT :TextView = view.findViewById(R.id.rank)
            val movieNmT :TextView = view.findViewById(R.id.movieNm)
            val openDtT :TextView = view.findViewById(R.id.openDT)
            val audiAccT :TextView = view.findViewById(R.id.audiAcc)
            val count1T :TextView = view.findViewById(R.id.count1)



        }
    }

}
