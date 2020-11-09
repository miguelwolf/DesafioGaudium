package br.com.gaudium.entrega.webservice;

import br.com.gaudium.entrega.maps.RequestAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebRequest {

    private Retrofit retrofit;

    private static WebRequest mInstance;

    public WebRequest(String url) {

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    /**
     *
     * @param banco,
     * @return
     */
    public static synchronized WebRequest getInstance(String banco) {

        if (mInstance == null)
                mInstance = new WebRequest(banco);

        return mInstance;

    }

    public RequestAPI getApi() {

        return retrofit.create(RequestAPI.class);

    }

}
