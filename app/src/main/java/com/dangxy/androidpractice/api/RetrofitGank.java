package com.dangxy.androidpractice.api;

import android.content.Context;

import com.dangxy.androidpractice.AppApplication;
import com.dangxy.androidpractice.BuildConfig;
import com.dangxy.androidpractice.utils.MLog;
import com.dangxy.androidpractice.utils.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/13
 */

public class RetrofitGank {
    private static final String BASE_URL = "http://gank.io/api/";
    private static final long TIMEOUT_CONNECT = 30 * 1000;
    private static final long CACHE_SIZE = 1024 * 1024 * 50;

    public Retrofit newInstance(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okhttpClient(context))
                .build();
        return retrofit;
    }

    public OkHttpClient okhttpClient(Context mContext) {
        File cacheFile = new File(mContext.getCacheDir(), "gank-io");
        Cache cache = new Cache(cacheFile, CACHE_SIZE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(BuildConfig.DEBUG ?
                                HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .addInterceptor(new LoggingInterceptor())
                .addNetworkInterceptor(mCacheControlInterceptor).build();
        try {
            cache.size();
        } catch (IOException e) {
        }
        return okHttpClient;
    }

    /**
     * 缓存拦截器
     */
    private final Interceptor mCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            // Add FORCE_CACHE cache control for each request if network is not available.
            if (!NetWorkUtils.isNetworkAvailable(AppApplication.getContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                MLog.d("dang", "11111");
            }

            Response originalResponse = chain.proceed(request);

            if (NetWorkUtils.isNetworkAvailable(AppApplication.getContext())) {

                String cacheControl = request.cacheControl().toString();
                MLog.d("dang", "22222");

                // Add cache control header for response same as request's while network is available.
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .build();
            } else {
                // Add cache control header for response to FORCE_CACHE while network is not available.
                MLog.d("dang", "33333");

                return originalResponse.newBuilder()
                        .header("Cache-Control", CacheControl.FORCE_CACHE.toString())
                        .build();
            }
        }
    };

    /**
     * 日志拦截器
     */
    public class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //这个chain里面包含了request和response，所以你要什么都可以从这里拿
            Request request = chain.request();

            long t1 = System.nanoTime();//请求发起的时间
            MLog.d("DANG", String.format("发送请求 %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();//收到响应的时间

            //这里不能直接使用response.body().string()的方式输出日志
            //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
            //个新的response给应用层处理
            ResponseBody responseBody = response.peekBody(1024 * 1024);

            MLog.d("DANG", String.format("接收响应: [%s] %n返回json:【%s】 %.1fms%n%s",
                    response.request().url(),
                    responseBody.string(),
                    (t2 - t1) / 1e6d,
                    response.headers()));

            return response;
        }
    }

}
