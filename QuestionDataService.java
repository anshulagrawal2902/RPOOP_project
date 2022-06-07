package com.example.android.rpoop_api_fetcher.service;


import com.example.android.rpoop_api_fetcher.models.QuestionModel;
import com.example.android.rpoop_api_fetcher.models.ResultsModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface QuestionDataService {
    @GET("question/{company}")
    Call<ResultsModel> getQuestions(@Path("company") String companyName);

    @POST("upload/")
    Call<QuestionModel> uploadQuestion(@Body QuestionModel questionModel);

    @FormUrlEncoded
    @POST("upload/")
    Call<QuestionModel> uploadQuestion(
            @Field("companyName") String companyName,
            @Field("question") String question,
            @Field("questionLink") String questionLink
    );
}
