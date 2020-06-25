package com.mbobiosio.mvvm.data;

import com.mbobiosio.mvvm.util.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * MVVM-Retrofit-RecyclerVIew
 * Created by Mbuodile Obiosio on Jun 25, 2020
 * https://twitter.com/cazewonder
 * Nigeria.
 */
public class ProfileAPIBuilder {

    private static Retrofit mRetrofit = null;

    public static Retrofit getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .retryOnConnectionFailure(true)
                .addInterceptor(chain -> {

                    Request request = chain.request();
                    Request finalRequest = request.newBuilder()
                            .addHeader("Accept", "application/json")
                            .method(request.method(), request.body())
                            .build();

                    return chain.proceed(finalRequest);
                })
                .build();

        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.PROFILE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
        }
        return mRetrofit;
    }

}
