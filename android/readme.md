#  [Kotlin] Retrofit 와 영화진흥위원회의 API 받아와서 영화 순위 만들기

참고 블로그 : https://velog.io/@jinny_0422/Retrofit2%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%B4%EC%84%9C-%EC%98%81%ED%99%94-%EC%A0%95%EB%B3%B4%EA%B0%80%EC%A0%B8%EC%98%A4%EA%B8%B0

![image](https://user-images.githubusercontent.com/66546156/132824642-7ee75bd0-c7b7-45a6-b8b9-5090c6234f05.png)

# 코드 작성시 애먹었던 사항

1. 코틀린 코드 (context와 xml의 요소 불러오기)

참조 코드는 이거였는데

recyclerView = findViewById(R.id.rv_result)
recyclerView.adapter = ResultRecyclerViewAdpater()
recyclerView.layoutManager = LinearLayoutManager(applicationContext)

예전에 수업들을때는 코틀린에서는 findViewById를 사용하지 않고도 불러올수 있다고 했었다

근데 안되길래 그냥 view.findviewbyid 사용했음.

나중에 알아보니까 안드로이드 4.1부터는 안쓴다고 하더라 

app단위 gradle에 요 코드를 추가하거나

apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

아니면 

import kotlinx.android.synthetic.main.activity_main.*

을 추가하라고 함
