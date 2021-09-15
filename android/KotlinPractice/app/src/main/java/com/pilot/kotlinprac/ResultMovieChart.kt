package com.pilot.kotlinprac

import com.google.gson.annotations.SerializedName

data class ResultMovieChart (
    @SerializedName("boxOfficeResult")
    var boxOfficeResult: BoxOfficeResult
)

data class BoxOfficeResult(
    @SerializedName("dailyBoxOfficeList")
    var dailyBoxOfficeList: List<MResult> = arrayListOf()
)

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

data class MResult (
    @SerializedName("rnum")
    var rnum: String = "",
    @SerializedName("rank")
    var rank: String = "",
    @SerializedName("rankInten")
    var rankInten: String = "",
    @SerializedName("movieNm")
    var movieNm: String = "",
    @SerializedName("openDt")
    var openDt: String = "",
    @SerializedName("salesAmt")
    var salesAmt: String = "",
    @SerializedName("salesAcc")
    var salesAcc: String = "",
    @SerializedName("audiAcc")
    var audiAcc: String = "",
    @SerializedName("audiChange")
    var audiChange: String = "",
    @SerializedName("showCnt")
    var showCnt: String = ""


)