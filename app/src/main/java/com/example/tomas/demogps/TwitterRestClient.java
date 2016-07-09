package com.example.tomas.demogps;
import com.loopj.android.http.*;

/**
 * Created by tomas on 08/07/2016.
 */
public class TwitterRestClient {
    //private static final String BASE_URL = "http://mindicador.cl/api";
    private static final String BASE_URL = "http://betacode.cl/BetacodeLabsMasterRest/Master/public/Lovers";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
