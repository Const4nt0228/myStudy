package com.pilot.kotlinprac

import retrofit2.Call
import retrofit2.http.*

interface MovieAPI {

/*
    rnum - 순번
    rank - 해당일자 박스오피스 순위
    rankInten - 전일대비순위
    movieNm - 영화 이름 국문명
    openDt - 개봉일
    salesAmt - 해당일 매출액
    salesAcc - 누적매출액
    audiAcc - 누적관객수
    audiChange - 전일대비 관객수
    showCnt - 해당일자 상영한 스크린수
*/

  //  @FormUrlEncoded
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    fun transferMovie(
    @Query("key") key: String?,
    @Query("targetDt") targetDt: String?
    ): Call<ResultMovieChart>

}