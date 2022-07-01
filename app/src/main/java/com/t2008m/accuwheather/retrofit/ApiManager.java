package com.t2008m.accuwheather.retrofit;

import com.t2008m.accuwheather.entity.DailyWeather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    String KEY = "wrJpodkkKqzjeHksP60WJlpzjXjeSulE";
    public static String SERVER = "http://dataservice.accuweather.com";

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=wrJpodkkKqzjeHksP60WJlpzjXjeSulE&language=vi-vn&metric=true")
    Call<List<DailyWeather>> getHour();

}
