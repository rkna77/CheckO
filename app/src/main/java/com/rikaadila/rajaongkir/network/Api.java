package com.rikaadila.rajaongkir.network;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Rika Nur'adila
 */

public class Api {
    private static Retrofit retrofit = null;

    public static Retrofit getUrl() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(30, TimeUnit.SECONDS);

        /*if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }*/

        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("key", "c36bb020018a2d2e96d34c1f5c3ba5e1")
                    .build();
            return chain.proceed(request);
        });

        OkHttpClient client = builder.build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.rajaongkir.com/starter/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
