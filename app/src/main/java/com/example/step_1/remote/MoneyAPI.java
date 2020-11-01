package com.example.step_1.remote;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MoneyAPI {
    @GET("./items")
    Single<MoneyResponse> GetMoneyItem(@Query("type") String type);

    @POST("./items/add")
    Completable PostMoney(@Query("price") int price, @Query("name") String name, @Query("type") String type);
}
