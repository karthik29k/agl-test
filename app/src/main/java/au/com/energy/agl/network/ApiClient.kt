package au.com.energy.agl.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers

class ApiClient {
    companion object {
        private var mRetrofit: Retrofit? = null
        private val baseURL: String = "http://agl-developer-test.azurewebsites.net"

        fun create(): ApiHelper {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder().baseUrl(baseURL)
                        .client(client).addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(rxAdapter).build()
            }
            return mRetrofit!!.create(ApiHelper::class.java)
        }
    }
}