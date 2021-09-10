package com.pilot.kotlinprac

import com.google.gson.annotations.SerializedName

data class ResultTransferPapago (
    @SerializedName("message")
    var message: Message
)

data class Message(
    @SerializedName("result")
    var result: Result
)

data class Result (
    @SerializedName("scrLangType")
    var srcLangType: String = "",
    @SerializedName("tarLangType")
    var tarLangType: String = "",
    @SerializedName("translatedText")
    var translatedText: String = ""
)