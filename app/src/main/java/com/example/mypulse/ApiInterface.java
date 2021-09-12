package com.example.mypulse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("registerPatient")
    Call<ResponseBody> registerPatient(@Field("first_name") String first_name,
                                       @Field("last_name") String last_name,
                                       @Field("email") String email,
                                       @Field("password") String password,
                                       @Field("mobile_no") String mobile_no);

    @POST("DoctorList")

    Call<ResponseBody> registerPatient(@Part("") RequestBody first_name);

}
